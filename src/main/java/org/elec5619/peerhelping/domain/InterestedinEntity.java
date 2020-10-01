package org.elec5619.peerhelping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "interestedin", schema = "peerhelping", catalog = "")
public class InterestedinEntity {
    private int interestId;

    @Id
    @Column(name = "interestId", nullable = false)
    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestedinEntity that = (InterestedinEntity) o;
        return interestId == that.interestId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(interestId);
    }
}
