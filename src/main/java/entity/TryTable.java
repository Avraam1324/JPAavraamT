package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "try_table", schema = "public", catalog = "Try")
public class TryTable {
    private int id;
    private String tryColoms;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "try_coloms", nullable = true, length = -1)
    public String getTryColoms() {
        return tryColoms;
    }

    public void setTryColoms(String tryColoms) {
        this.tryColoms = tryColoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TryTable tryTable = (TryTable) o;

        if (id != tryTable.id) return false;
        if (tryColoms != null ? !tryColoms.equals(tryTable.tryColoms) : tryTable.tryColoms != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tryColoms != null ? tryColoms.hashCode() : 0);
        return result;
    }
}
