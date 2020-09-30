package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.InterestedInDao;
import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class InterestedInService {
    @Autowired
    InterestedInDao interestedInDao;

    public InterestedinEntity findInterestBySid(int sid){
        return this.interestedInDao.findBySid(sid);
    }

    public InterestedinEntity findInterestByCourseId(int courseId){
        return this.interestedInDao.findByCourseId(courseId);
    }
}
