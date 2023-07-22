package cl.mockito.curso.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COMUNAS", schema = "GOVIEDO", catalog = "")
public class ComunasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCOMUNA", nullable = false, precision = 0)
    private Short idcomuna;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "IDREGION", nullable = false, precision = 0)
    private Short idregion;
    @OneToMany(mappedBy = "comunasByIdcomuna")
    private Collection<ClientesEntity> clientesByIdcomuna;

    public Short getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Short idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getIdregion() {
        return idregion;
    }

    public void setIdregion(Short idregion) {
        this.idregion = idregion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComunasEntity that = (ComunasEntity) o;

        if (idcomuna != null ? !idcomuna.equals(that.idcomuna) : that.idcomuna != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (idregion != null ? !idregion.equals(that.idregion) : that.idregion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcomuna != null ? idcomuna.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (idregion != null ? idregion.hashCode() : 0);
        return result;
    }

    public Collection<ClientesEntity> getClientesByIdcomuna() {
        return clientesByIdcomuna;
    }

    public void setClientesByIdcomuna(Collection<ClientesEntity> clientesByIdcomuna) {
        this.clientesByIdcomuna = clientesByIdcomuna;
    }
}
