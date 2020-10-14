package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.MatchesDao;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesService {
    @Autowired
    MatchesDao matchesDao;

    public MatchesEntity findByMatchId(int matchId){
        return this.matchesDao.findByMatchId(matchId);
    }

    // TODO: to be updated
    public List<Object> findAllBookings() {
        return this.matchesDao.findByStudentId();
    }
}
