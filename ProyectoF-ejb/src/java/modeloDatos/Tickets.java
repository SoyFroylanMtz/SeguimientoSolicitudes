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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyfroylan
 */
@Entity
@Table(name = "Tickets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByIDTicket", query = "SELECT t FROM Tickets t WHERE t.iDTicket = :iDTicket"),
    @NamedQuery(name = "Tickets.findByFolioTicket", query = "SELECT t FROM Tickets t WHERE t.folioTicket = :folioTicket"),
    @NamedQuery(name = "Tickets.findByFechaRecibida", query = "SELECT t FROM Tickets t WHERE t.fechaRecibida = :fechaRecibida"),
    @NamedQuery(name = "Tickets.findByHoraRecibida", query = "SELECT t FROM Tickets t WHERE t.horaRecibida = :horaRecibida"),
    @NamedQuery(name = "Tickets.findByFechaEmitida", query = "SELECT t FROM Tickets t WHERE t.fechaEmitida = :fechaEmitida"),
    @NamedQuery(name = "Tickets.findByHoraEmitida", query = "SELECT t FROM Tickets t WHERE t.horaEmitida = :horaEmitida"),
    @NamedQuery(name = "Tickets.findByFechaCompletada", query = "SELECT t FROM Tickets t WHERE t.fechaCompletada = :fechaCompletada"),
    @NamedQuery(name = "Tickets.findByHoraCompletada", query = "SELECT t FROM Tickets t WHERE t.horaCompletada = :horaCompletada"),
    @NamedQuery(name = "Tickets.findByFechaAsignada", query = "SELECT t FROM Tickets t WHERE t.fechaAsignada = :fechaAsignada"),
    @NamedQuery(name = "Tickets.findByHorAsignada", query = "SELECT t FROM Tickets t WHERE t.horAsignada = :horAsignada"),
    @NamedQuery(name = "Tickets.findByUserID", query = "SELECT t FROM Tickets t WHERE t.userID = :userID"),
    @NamedQuery(name = "Tickets.findByProcesoID", query = "SELECT t FROM Tickets t WHERE t.procesoID = :procesoID"),
    @NamedQuery(name = "Tickets.findByTipoID", query = "SELECT t FROM Tickets t WHERE t.tipoID = :tipoID")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTicket")
    private Integer iDTicket;
    @Size(max = 30)
    @Column(name = "folioTicket")
    private String folioTicket;
    @Column(name = "fechaRecibida")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibida;
    @Column(name = "horaRecibida")
    @Temporal(TemporalType.TIME)
    private Date horaRecibida;
    @Column(name = "fechaEmitida")
    @Temporal(TemporalType.DATE)
    private Date fechaEmitida;
    @Column(name = "horaEmitida")
    @Temporal(TemporalType.TIME)
    private Date horaEmitida;
    @Column(name = "fechaCompletada")
    @Temporal(TemporalType.DATE)
    private Date fechaCompletada;
    @Column(name = "horaCompletada")
    @Temporal(TemporalType.TIME)
    private Date horaCompletada;
    @Column(name = "fechaAsignada")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignada;
    @Column(name = "horAsignada")
    @Temporal(TemporalType.TIME)
    private Date horAsignada;
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "procesoID")
    private Integer procesoID;
    @Column(name = "tipoID")
    private Integer tipoID;

    public Tickets() {
    }

    public Tickets(Integer iDTicket) {
        this.iDTicket = iDTicket;
    }

    public Integer getIDTicket() {
        return iDTicket;
    }

    public void setIDTicket(Integer iDTicket) {
        this.iDTicket = iDTicket;
    }

    public String getFolioTicket() {
        return folioTicket;
    }

    public void setFolioTicket(String folioTicket) {
        this.folioTicket = folioTicket;
    }

    public Date getFechaRecibida() {
        return fechaRecibida;
    }

    public void setFechaRecibida(Date fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    public Date getHoraRecibida() {
        return horaRecibida;
    }

    public void setHoraRecibida(Date horaRecibida) {
        this.horaRecibida = horaRecibida;
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

    public Date getFechaCompletada() {
        return fechaCompletada;
    }

    public void setFechaCompletada(Date fechaCompletada) {
        this.fechaCompletada = fechaCompletada;
    }

    public Date getHoraCompletada() {
        return horaCompletada;
    }

    public void setHoraCompletada(Date horaCompletada) {
        this.horaCompletada = horaCompletada;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public Date getHorAsignada() {
        return horAsignada;
    }

    public void setHorAsignada(Date horAsignada) {
        this.horAsignada = horAsignada;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getProcesoID() {
        return procesoID;
    }

    public void setProcesoID(Integer procesoID) {
        this.procesoID = procesoID;
    }

    public Integer getTipoID() {
        return tipoID;
    }

    public void setTipoID(Integer tipoID) {
        this.tipoID = tipoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTicket != null ? iDTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.iDTicket == null && other.iDTicket != null) || (this.iDTicket != null && !this.iDTicket.equals(other.iDTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Tickets[ iDTicket=" + iDTicket + " ]";
    }
    
}
