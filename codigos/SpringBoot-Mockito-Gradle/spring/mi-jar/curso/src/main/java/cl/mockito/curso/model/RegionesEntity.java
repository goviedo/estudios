package cl.mockito.curso.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "REGIONES", schema = "GOVIEDO", catalog = "")
public class RegionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDREGION", nullable = false, precision = 0)
    private Short idregion;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "regionesByIdregion")
    private Collection<ComunasEntity> comunasByIdregion;

    public Short getIdregion() {
        return idregion;
    }

    public void setIdregion(Short idregion) {
        this.idregion = idregion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionesEntity that = (RegionesEntity) o;

        if (idregion != null ? !idregion.equals(that.idregion) : that.idregion != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idregion != null ? idregion.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<ComunasEntity> getComunasByIdregion() {
        return comunasByIdregion;
    }

    public void setComunasByIdregion(Collection<ComunasEntity> comunasByIdregion) {
        this.comunasByIdregion = comunasByIdregion;
    }
}
