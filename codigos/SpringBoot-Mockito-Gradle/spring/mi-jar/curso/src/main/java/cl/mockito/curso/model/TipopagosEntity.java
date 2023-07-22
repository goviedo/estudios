package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "TIPOPAGOS", schema = "GOVIEDO", catalog = "")
public class TipopagosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTIPOPAGO", nullable = false, precision = 0)
    private Short idtipopago;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    public Short getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(Short idtipopago) {
        this.idtipopago = idtipopago;
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

        TipopagosEntity that = (TipopagosEntity) o;

        if (idtipopago != null ? !idtipopago.equals(that.idtipopago) : that.idtipopago != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtipopago != null ? idtipopago.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
