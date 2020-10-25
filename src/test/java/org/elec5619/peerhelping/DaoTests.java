package org.elec5619.peerhelping;

import org.elec5619.peerhelping.dao.CoursesDao;
import org.elec5619.peerhelping.dao.MatchesDao;
import org.elec5619.peerhelping.service.MatchesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DaoTests {
    @Autowired
    MatchesDao matchesDao;

    @Autowired
    CoursesDao coursesDao;

    @Autowired
    MatchesService matchesService;

    @Test
    void testMatchesDao(){
        var res = matchesDao.findTopMatchId();
        System.out.println(res);
    }

    @Test
    void testCoursesDao() {
        var res = coursesDao.getCoursesEntityByCourseCode("COMP5347").getCourseId();
        System.out.println(res);
    }

    @Test
    void testInsertNewBooking() {
        matchesService.addBooking(1008, 1006, "ELEC5619" );
    }
}
