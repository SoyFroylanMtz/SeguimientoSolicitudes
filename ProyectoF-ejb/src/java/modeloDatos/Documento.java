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
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIDDocumento", query = "SELECT d FROM Documento d WHERE d.iDDocumento = :iDDocumento"),
    @NamedQuery(name = "Documento.findByTipOrigen", query = "SELECT d FROM Documento d WHERE d.tipOrigen = :tipOrigen"),
    @NamedQuery(name = "Documento.findByOrigenID", query = "SELECT d FROM Documento d WHERE d.origenID = :origenID"),
    @NamedQuery(name = "Documento.findByFechaSubida", query = "SELECT d FROM Documento d WHERE d.fechaSubida = :fechaSubida")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDocumento")
    private Integer iDDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "tipOrigen")
    private String tipOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "origenID")
    private int origenID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "url")
    private String url;
    @Column(name = "fechaSubida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSubida;

    public Documento() {
    }

    public Documento(Integer iDDocumento) {
        this.iDDocumento = iDDocumento;
    }

    public Documento(Integer iDDocumento, String tipOrigen, int origenID, String url) {
        this.iDDocumento = iDDocumento;
        this.tipOrigen = tipOrigen;
        this.origenID = origenID;
        this.url = url;
    }

    public Integer getIDDocumento() {
        return iDDocumento;
    }

    public void setIDDocumento(Integer iDDocumento) {
        this.iDDocumento = iDDocumento;
    }

    public String getTipOrigen() {
        return tipOrigen;
    }

    public void setTipOrigen(String tipOrigen) {
        this.tipOrigen = tipOrigen;
    }

    public int getOrigenID() {
        return origenID;
    }

    public void setOrigenID(int origenID) {
        this.origenID = origenID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDocumento != null ? iDDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.iDDocumento == null && other.iDDocumento != null) || (this.iDDocumento != null && !this.iDDocumento.equals(other.iDDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Documento[ iDDocumento=" + iDDocumento + " ]";
    }
    
}
