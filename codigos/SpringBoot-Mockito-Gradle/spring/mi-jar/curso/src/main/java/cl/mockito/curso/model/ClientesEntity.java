package cl.mockito.curso.model;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTES", schema = "GOVIEDO", catalog = "")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCLIENTE", nullable = false, precision = 0)
    private Short idcliente;
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
    @Column(name = "IDCOMUNA", nullable = false, precision = 0)
    private Short idcomuna;
    @Basic
    @Column(name = "TELEFONO", nullable = false, length = 100)
    private String telefono;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    public Short getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Short idcliente) {
        this.idcliente = idcliente;
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

    public Short getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Short idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apepat != null ? !apepat.equals(that.apepat) : that.apepat != null) return false;
        if (apemat != null ? !apemat.equals(that.apemat) : that.apemat != null) return false;
        if (idcomuna != null ? !idcomuna.equals(that.idcomuna) : that.idcomuna != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcliente != null ? idcliente.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apepat != null ? apepat.hashCode() : 0);
        result = 31 * result + (apemat != null ? apemat.hashCode() : 0);
        result = 31 * result + (idcomuna != null ? idcomuna.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
