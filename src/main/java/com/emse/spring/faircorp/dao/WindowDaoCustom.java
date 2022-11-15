package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface WindowDaoCustom {
    int deleteByRoom(@Param("id") Long id);
    List<Window> findRoomOpenWindows(Long id);

}