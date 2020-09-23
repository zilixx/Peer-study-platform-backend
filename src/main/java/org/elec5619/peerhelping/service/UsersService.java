package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.UsersDao;
import org.elec5619.peerhelping.domain.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService{
    @Autowired
    UsersDao usersDao;

    public UsersEntity findBySidAndPassword(int sid, String pwd) {
        return usersDao.findBySidAndPassword(sid, pwd);
    }

}
