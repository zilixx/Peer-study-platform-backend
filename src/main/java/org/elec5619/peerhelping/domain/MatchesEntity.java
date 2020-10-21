package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "matches", schema = "peerhelping")
public class MatchesEntity {
    private int matchId;
    private String matchTime;

    @Id
    @Column(name = "matchID", nullable = false)
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Basic
    @Column(name = "matchTime", nullable = false, length = 45)
    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesEntity that = (MatchesEntity) o;
        return matchId == that.matchId &&
                Objects.equals(matchTime, that.matchTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, matchTime);
    }
}
