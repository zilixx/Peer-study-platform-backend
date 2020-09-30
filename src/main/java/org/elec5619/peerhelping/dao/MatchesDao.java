package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.data.repository.CrudRepository;

public interface MatchesDao extends CrudRepository<MatchesEntity, Long> {
    MatchesEntity findByMatchId(int matchId);

    // TODO: to be updated
}
