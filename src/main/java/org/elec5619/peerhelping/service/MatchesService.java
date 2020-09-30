package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.MatchesDao;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchesService {
    @Autowired
    MatchesDao matchesDao;

    public MatchesEntity findByMatchId(int matchId){
        return this.matchesDao.findByMatchId(matchId);
    }

    // TODO: to be updated
    //TODO: Error creating bean with name 'matchesDao' defined in org.elec5619.peerhelping.dao.MatchesDao defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Cannot resolve reference to bean 'jpaMappingContext' while setting bean
    // TODO: Error creating bean with name 'jpaMappingContext': Invocation of init method failed; nested exception is org.hibernate.AnnotationException: No identifier specified for entity: org.elec5619.peerhelping.domain.CalendarEntity
}
