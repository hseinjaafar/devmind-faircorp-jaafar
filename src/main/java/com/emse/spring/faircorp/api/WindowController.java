package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/windows") // (2)
@Transactional // (3)
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }

    @PostMapping
    public WindowDto create(@RequestBody WindowDto dto) {
        Room room = roomDao.getById(dto.getRoomId());
        Window window= null;
        if (dto.getId() == null) {
            window = windowDao.save(new Window(dto.getName(), dto.getWindowStatus(), room));
        }
        else {
            window = windowDao.getById(dto.getId());
            window.setName(dto.getName());
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }




}
