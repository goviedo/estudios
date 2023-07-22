package cl.mockito.curso.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PRODUCTOS", schema = "GOVIEDO", catalog = "")
public class ProductosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUCTO", nullable = false, precision = 0)
    private Short idproducto;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "PRECIO", nullable = false, precision = 0)
    private Short precio;
    @Basic
    @Column(name = "STOCK", nullable = false, precision = 0)
    private Short stock;
    @Basic
    @Column(name = "IDCATEGORIA", nullable = false, precision = 0)
    private Short idcategoria;
    @Basic
    @Column(name = "IDPRESENTACION", nullable = false, precision = 0)
    private Short idpresentacion;
    @OneToMany(mappedBy = "productosByIdproducto")
    private Collection<DetalleventasEntity> detalleventasByIdproducto;
    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "IDCATEGORIA", nullable = false)
    private CategoriasEntity categoriasByIdcategoria;
    @ManyToOne
    @JoinColumn(name = "IDPRESENTACION", referencedColumnName = "IDPRESENTACION", nullable = false)
    private PresentacionesEntity presentacionesByIdpresentacion;

    public Short getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Short idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getPrecio() {
        return precio;
    }

    public void setPrecio(Short precio) {
        this.precio = precio;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }

    public Short getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Short idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Short getIdpresentacion() {
        return idpresentacion;
    }

    public void setIdpresentacion(Short idpresentacion) {
        this.idpresentacion = idpresentacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosEntity that = (ProductosEntity) o;

        if (idproducto != null ? !idproducto.equals(that.idproducto) : that.idproducto != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (idcategoria != null ? !idcategoria.equals(that.idcategoria) : that.idcategoria != null) return false;
        if (idpresentacion != null ? !idpresentacion.equals(that.idpresentacion) : that.idpresentacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproducto != null ? idproducto.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (idcategoria != null ? idcategoria.hashCode() : 0);
        result = 31 * result + (idpresentacion != null ? idpresentacion.hashCode() : 0);
        return result;
    }

    public Collection<DetalleventasEntity> getDetalleventasByIdproducto() {
        return detalleventasByIdproducto;
    }

    public void setDetalleventasByIdproducto(Collection<DetalleventasEntity> detalleventasByIdproducto) {
        this.detalleventasByIdproducto = detalleventasByIdproducto;
    }

    public CategoriasEntity getCategoriasByIdcategoria() {
        return categoriasByIdcategoria;
    }

    public void setCategoriasByIdcategoria(CategoriasEntity categoriasByIdcategoria) {
        this.categoriasByIdcategoria = categoriasByIdcategoria;
    }

    public PresentacionesEntity getPresentacionesByIdpresentacion() {
        return presentacionesByIdpresentacion;
    }

    public void setPresentacionesByIdpresentacion(PresentacionesEntity presentacionesByIdpresentacion) {
        this.presentacionesByIdpresentacion = presentacionesByIdpresentacion;
    }
}
