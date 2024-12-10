/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDatos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyfroylan
 */
@Entity
@Table(name = "detalleOficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOficio.findAll", query = "SELECT d FROM DetalleOficio d"),
    @NamedQuery(name = "DetalleOficio.findByIDDetalleOficio", query = "SELECT d FROM DetalleOficio d WHERE d.iDDetalleOficio = :iDDetalleOficio"),
    @NamedQuery(name = "DetalleOficio.findByFolioOficio", query = "SELECT d FROM DetalleOficio d WHERE d.folioOficio = :folioOficio"),
    @NamedQuery(name = "DetalleOficio.findByTipoSolicitud", query = "SELECT d FROM DetalleOficio d WHERE d.tipoSolicitud = :tipoSolicitud"),
    @NamedQuery(name = "DetalleOficio.findByFolioSolicitud", query = "SELECT d FROM DetalleOficio d WHERE d.folioSolicitud = :folioSolicitud"),
    @NamedQuery(name = "DetalleOficio.findByFechaEmitida", query = "SELECT d FROM DetalleOficio d WHERE d.fechaEmitida = :fechaEmitida"),
    @NamedQuery(name = "DetalleOficio.findByHoraEmitida", query = "SELECT d FROM DetalleOficio d WHERE d.horaEmitida = :horaEmitida"),
    @NamedQuery(name = "DetalleOficio.findByExternoID", query = "SELECT d FROM DetalleOficio d WHERE d.externoID = :externoID")})
public class DetalleOficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDetalleOficio")
    private Integer iDDetalleOficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "folioOficio")
    private String folioOficio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipoSolicitud")
    private String tipoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "folioSolicitud")
    private String folioSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmitida")
    @Temporal(TemporalType.DATE)
    private Date fechaEmitida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaEmitida")
    @Temporal(TemporalType.TIME)
    private Date horaEmitida;
    @Lob
    @Size(max = 65535)
    @Column(name = "asunto")
    private String asunto;
    @Lob
    @Size(max = 65535)
    @Column(name = "respuesa")
    private String respuesa;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "externoID")
    private int externoID;

    public DetalleOficio() {
    }

    public DetalleOficio(Integer iDDetalleOficio) {
        this.iDDetalleOficio = iDDetalleOficio;
    }

    public DetalleOficio(Integer iDDetalleOficio, String folioOficio, String tipoSolicitud, String folioSolicitud, Date fechaEmitida, Date horaEmitida, int externoID) {
        this.iDDetalleOficio = iDDetalleOficio;
        this.folioOficio = folioOficio;
        this.tipoSolicitud = tipoSolicitud;
        this.folioSolicitud = folioSolicitud;
        this.fechaEmitida = fechaEmitida;
        this.horaEmitida = horaEmitida;
        this.externoID = externoID;
    }

    public Integer getIDDetalleOficio() {
        return iDDetalleOficio;
    }

    public void setIDDetalleOficio(Integer iDDetalleOficio) {
        this.iDDetalleOficio = iDDetalleOficio;
    }

    public String getFolioOficio() {
        return folioOficio;
    }

    public void setFolioOficio(String folioOficio) {
        this.folioOficio = folioOficio;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getFolioSolicitud() {
        return folioSolicitud;
    }

    public void setFolioSolicitud(String folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    public Date getFechaEmitida() {
        return fechaEmitida;
    }

    public void setFechaEmitida(Date fechaEmitida) {
        this.fechaEmitida = fechaEmitida;
    }

    public Date getHoraEmitida() {
        return horaEmitida;
    }

    public void setHoraEmitida(Date horaEmitida) {
        this.horaEmitida = horaEmitida;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getRespuesa() {
        return respuesa;
    }

    public void setRespuesa(String respuesa) {
        this.respuesa = respuesa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getExternoID() {
        return externoID;
    }

    public void setExternoID(int externoID) {
        this.externoID = externoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDetalleOficio != null ? iDDetalleOficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOficio)) {
            return false;
        }
        DetalleOficio other = (DetalleOficio) object;
        if ((this.iDDetalleOficio == null && other.iDDetalleOficio != null) || (this.iDDetalleOficio != null && !this.iDDetalleOficio.equals(other.iDDetalleOficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.DetalleOficio[ iDDetalleOficio=" + iDDetalleOficio + " ]";
    }
    
}
