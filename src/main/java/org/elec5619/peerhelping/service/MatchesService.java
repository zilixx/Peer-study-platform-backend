package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.MatchesDao;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatchesService {
    @Autowired
    MatchesDao matchesDao;

    public List<Map<String, Object>> findAllBookings(int sid) {
        return this.matchesDao.findByStudentId(sid);
    }

    public void deleteByMatchId(int matchId) {
        this.matchesDao.deleteByMatchId(matchId);
    }

    public MatchesEntity findByMatchId(int matchId){
        return this.matchesDao.findByMatchId(matchId);
    }
}
