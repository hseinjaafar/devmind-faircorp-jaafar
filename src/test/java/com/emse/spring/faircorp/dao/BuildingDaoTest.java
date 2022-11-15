
package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BuildingDaoTest {

    @Autowired
    private HeaterDao heaterDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindHeatersInBuilding() {
        List<Heater> result = buildingDao.findAllHeatersInBuilding((long) -10);
        Assertions.assertThat(result)
                .hasSize(0);
    }

    @Test
    public void shouldFindWindowsInBuilding() {
        List<Window> result = buildingDao.findAllWindowsInBuilding((long) -10);
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN),Tuple.tuple(-7L, WindowStatus.CLOSED));
    }

}