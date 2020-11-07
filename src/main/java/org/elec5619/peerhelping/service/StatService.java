package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.StatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatService {
    @Autowired
    StatDao statDao;

    public List<Map<String, Object>> getAllStatNumbers() {
        return statDao.getAllNumbers();
    }
}
