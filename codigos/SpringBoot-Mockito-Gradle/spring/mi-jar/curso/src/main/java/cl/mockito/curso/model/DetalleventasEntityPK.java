package cl.mockito.curso.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DetalleventasEntityPK implements Serializable {
    @Column(name = "IDVENTA", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idventa;
    @Column(name = "IDPRODUCTO", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short idproducto;

    public Short getIdventa() {
        return idventa;
    }

    public void setIdventa(Short idventa) {
        this.idventa = idventa;
    }

    public Short getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Short idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleventasEntityPK that = (DetalleventasEntityPK) o;

        if (idventa != null ? !idventa.equals(that.idventa) : that.idventa != null) return false;
        if (idproducto != null ? !idproducto.equals(that.idproducto) : that.idproducto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa != null ? idventa.hashCode() : 0;
        result = 31 * result + (idproducto != null ? idproducto.hashCode() : 0);
        return result;
    }
}
