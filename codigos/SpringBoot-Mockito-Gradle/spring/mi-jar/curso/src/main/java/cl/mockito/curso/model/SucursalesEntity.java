package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "SUCURSALES", schema = "GOVIEDO", catalog = "")
public class SucursalesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDSUCURSAL", nullable = false, precision = 0)
    private Short idsucursal;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "IDCOMUNA", nullable = true, precision = 0)
    private Short idcomuna;
    @ManyToOne
    @JoinColumn(name = "IDCOMUNA", referencedColumnName = "IDCOMUNA")
    private ComunasEntity comunasByIdcomuna;

    public Short getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Short idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Short idcomuna) {
        this.idcomuna = idcomuna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SucursalesEntity that = (SucursalesEntity) o;

        if (idsucursal != null ? !idsucursal.equals(that.idsucursal) : that.idsucursal != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (idcomuna != null ? !idcomuna.equals(that.idcomuna) : that.idcomuna != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsucursal != null ? idsucursal.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (idcomuna != null ? idcomuna.hashCode() : 0);
        return result;
    }

    public ComunasEntity getComunasByIdcomuna() {
        return comunasByIdcomuna;
    }

    public void setComunasByIdcomuna(ComunasEntity comunasByIdcomuna) {
        this.comunasByIdcomuna = comunasByIdcomuna;
    }
}
