package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "PRESENTACIONES", schema = "GOVIEDO", catalog = "")
public class PresentacionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRESENTACION", nullable = false, precision = 0)
    private Short idpresentacion;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    public Short getIdpresentacion() {
        return idpresentacion;
    }

    public void setIdpresentacion(Short idpresentacion) {
        this.idpresentacion = idpresentacion;
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

        PresentacionesEntity that = (PresentacionesEntity) o;

        if (idpresentacion != null ? !idpresentacion.equals(that.idpresentacion) : that.idpresentacion != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpresentacion != null ? idpresentacion.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
