package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UsersDao extends CrudRepository<UsersEntity, Long> {
    UsersEntity findBySid(int sid);

    @Modifying
    @Transactional
    void deleteBySid(int sid);

    UsersEntity findBySidAndPassword(int sid, String pwd);
}
