package cl.mockito.curso.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "VENTAS", schema = "GOVIEDO", catalog = "")
public class VentasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVENTA", nullable = false, precision = 0)
    private Short idventa;
    @Basic
    @Column(name = "FECHA", nullable = false)
    private Timestamp fecha;
    @Basic
    @Column(name = "IDCLIENTE", nullable = false, precision = 0)
    private Short idcliente;
    @Basic
    @Column(name = "IDTIPOPAGO", nullable = false, precision = 0)
    private Short idtipopago;
    @Basic
    @Column(name = "IDUSUARIO", nullable = false, precision = 0)
    private Short idusuario;
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE", nullable = false)
    private ClientesEntity clientesByIdcliente;
    @ManyToOne
    @JoinColumn(name = "IDTIPOPAGO", referencedColumnName = "IDTIPOPAGO", nullable = false)
    private TipopagosEntity tipopagosByIdtipopago;
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    private UsuariosEntity usuariosByIdusuario;

    public Short getIdventa() {
        return idventa;
    }

    public void setIdventa(Short idventa) {
        this.idventa = idventa;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Short getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Short idcliente) {
        this.idcliente = idcliente;
    }

    public Short getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(Short idtipopago) {
        this.idtipopago = idtipopago;
    }

    public Short getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Short idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasEntity that = (VentasEntity) o;

        if (idventa != null ? !idventa.equals(that.idventa) : that.idventa != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (idcliente != null ? !idcliente.equals(that.idcliente) : that.idcliente != null) return false;
        if (idtipopago != null ? !idtipopago.equals(that.idtipopago) : that.idtipopago != null) return false;
        if (idusuario != null ? !idusuario.equals(that.idusuario) : that.idusuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa != null ? idventa.hashCode() : 0;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (idcliente != null ? idcliente.hashCode() : 0);
        result = 31 * result + (idtipopago != null ? idtipopago.hashCode() : 0);
        result = 31 * result + (idusuario != null ? idusuario.hashCode() : 0);
        return result;
    }

    public ClientesEntity getClientesByIdcliente() {
        return clientesByIdcliente;
    }

    public void setClientesByIdcliente(ClientesEntity clientesByIdcliente) {
        this.clientesByIdcliente = clientesByIdcliente;
    }

    public TipopagosEntity getTipopagosByIdtipopago() {
        return tipopagosByIdtipopago;
    }

    public void setTipopagosByIdtipopago(TipopagosEntity tipopagosByIdtipopago) {
        this.tipopagosByIdtipopago = tipopagosByIdtipopago;
    }

    public UsuariosEntity getUsuariosByIdusuario() {
        return usuariosByIdusuario;
    }

    public void setUsuariosByIdusuario(UsuariosEntity usuariosByIdusuario) {
        this.usuariosByIdusuario = usuariosByIdusuario;
    }
}
