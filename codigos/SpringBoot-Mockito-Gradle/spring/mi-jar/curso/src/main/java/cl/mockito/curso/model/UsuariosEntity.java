package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS", schema = "GOVIEDO", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDUSUARIO", nullable = false, precision = 0)
    private Short idusuario;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "APEPAT", nullable = false, length = 100)
    private String apepat;
    @Basic
    @Column(name = "APEMAT", nullable = false, length = 100)
    private String apemat;
    @Basic
    @Column(name = "IDSUCURSAL", nullable = false, precision = 0)
    private Short idsucursal;
    @ManyToOne
    @JoinColumn(name = "IDSUCURSAL", referencedColumnName = "IDSUCURSAL", nullable = false)
    private SucursalesEntity sucursalesByIdsucursal;

    public Short getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Short idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public Short getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Short idsucursal) {
        this.idsucursal = idsucursal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idusuario != null ? !idusuario.equals(that.idusuario) : that.idusuario != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apepat != null ? !apepat.equals(that.apepat) : that.apepat != null) return false;
        if (apemat != null ? !apemat.equals(that.apemat) : that.apemat != null) return false;
        if (idsucursal != null ? !idsucursal.equals(that.idsucursal) : that.idsucursal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusuario != null ? idusuario.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apepat != null ? apepat.hashCode() : 0);
        result = 31 * result + (apemat != null ? apemat.hashCode() : 0);
        result = 31 * result + (idsucursal != null ? idsucursal.hashCode() : 0);
        return result;
    }

    public SucursalesEntity getSucursalesByIdsucursal() {
        return sucursalesByIdsucursal;
    }

    public void setSucursalesByIdsucursal(SucursalesEntity sucursalesByIdsucursal) {
        this.sucursalesByIdsucursal = sucursalesByIdsucursal;
    }
}
