package org.elec5619.peerhelping.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "interestedin", schema = "peerhelping", catalog = "")
public class InterestedinEntity {
    private String teach;

    @Basic
    @Column(name = "teach", nullable = false, length = 45)
    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestedinEntity that = (InterestedinEntity) o;
        return Objects.equals(teach, that.teach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teach);
    }
}
