package cl.mockito.curso.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CATEGORIAS", schema = "GOVIEDO", catalog = "")
public class CategoriasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCATEGORIA", nullable = false, precision = 0)
    private Short idcategoria;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "categoriasByIdcategoria")
    private Collection<ProductosEntity> productosByIdcategoria;

    public Short getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Short idcategoria) {
        this.idcategoria = idcategoria;
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

        CategoriasEntity that = (CategoriasEntity) o;

        if (idcategoria != null ? !idcategoria.equals(that.idcategoria) : that.idcategoria != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcategoria != null ? idcategoria.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<ProductosEntity> getProductosByIdcategoria() {
        return productosByIdcategoria;
    }

    public void setProductosByIdcategoria(Collection<ProductosEntity> productosByIdcategoria) {
        this.productosByIdcategoria = productosByIdcategoria;
    }
}
