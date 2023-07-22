package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "DETALLEVENTAS", schema = "GOVIEDO", catalog = "")
@IdClass(DetalleventasEntityPK.class)
public class DetalleventasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVENTA", nullable = false, precision = 0)
    private Short idventa;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUCTO", nullable = false, precision = 0)
    private Short idproducto;
    @Basic
    @Column(name = "CANTIDAD", nullable = false, precision = 0)
    private Short cantidad;

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

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleventasEntity that = (DetalleventasEntity) o;

        if (idventa != null ? !idventa.equals(that.idventa) : that.idventa != null) return false;
        if (idproducto != null ? !idproducto.equals(that.idproducto) : that.idproducto != null) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa != null ? idventa.hashCode() : 0;
        result = 31 * result + (idproducto != null ? idproducto.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
