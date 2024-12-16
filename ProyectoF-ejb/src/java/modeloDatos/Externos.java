/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDatos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyfroylan
 */
@Entity
@Table(name = "externos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externos.findAll", query = "SELECT e FROM Externos e"),
    @NamedQuery(name = "Externos.findByIDExterno", query = "SELECT e FROM Externos e WHERE e.iDExterno = :iDExterno"),
    @NamedQuery(name = "Externos.findByFolioExterno", query = "SELECT e FROM Externos e WHERE e.folioExterno = :folioExterno"),
    @NamedQuery(name = "Externos.findByMunicipioID", query = "SELECT e FROM Externos e WHERE e.municipioID = :municipioID"),
    @NamedQuery(name = "Externos.findByPlataformaID", query = "SELECT e FROM Externos e WHERE e.plataformaID = :plataformaID"),
    @NamedQuery(name = "Externos.findByTipoAtencionID", query = "SELECT e FROM Externos e WHERE e.tipoAtencionID = :tipoAtencionID"),
    @NamedQuery(name = "Externos.findByTicketID", query = "SELECT e FROM Externos e WHERE e.ticketID = :ticketID"),
    @NamedQuery(name = "Externos.findByCorreoID", query = "SELECT e FROM Externos e WHERE e.correoID = :correoID")})
public class Externos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDExterno")
    private Integer iDExterno;
    @Size(max = 30)
    @Column(name = "folioExterno")
    private String folioExterno;
    @Column(name = "municipioID")
    private Integer municipioID;
    @Column(name = "plataformaID")
    private Integer plataformaID;
    @Column(name = "tipoAtencionID")
    private Integer tipoAtencionID;
    @Column(name = "ticketID")
    private Integer ticketID;
    @Column(name = "correoID")
    private Integer correoID;
    @ManyToOne
    @JoinColumn(name = "municipioID", referencedColumnName = "IDMunicipio", insertable = false, updatable = false)
    private Municipios municipio;
    @ManyToOne
    @JoinColumn(name = "plataformaID", referencedColumnName = "IDPlataforma", insertable = false, updatable = false)
    private Plataformas plataforma;

    public Externos() {
    }

    public Externos(Integer iDExterno) {
        this.iDExterno = iDExterno;
    }

    public Integer getIDExterno() {
        return iDExterno;
    }

    public void setIDExterno(Integer iDExterno) {
        this.iDExterno = iDExterno;
    }

    public String getFolioExterno() {
        return folioExterno;
    }

    public void setFolioExterno(String folioExterno) {
        this.folioExterno = folioExterno;
    }

    public Integer getMunicipioID() {
        return municipioID;
    }

    public void setMunicipioID(Integer municipioID) {
        this.municipioID = municipioID;
    }

    public Integer getPlataformaID() {
        return plataformaID;
    }

    public void setPlataformaID(Integer plataformaID) {
        this.plataformaID = plataformaID;
    }

    public Integer getTipoAtencionID() {
        return tipoAtencionID;
    }

    public void setTipoAtencionID(Integer tipoAtencionID) {
        this.tipoAtencionID = tipoAtencionID;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getCorreoID() {
        return correoID;
    }

    public void setCorreoID(Integer correoID) {
        this.correoID = correoID;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }

    public Plataformas getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataformas plataforma) {
        this.plataforma = plataforma;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDExterno != null ? iDExterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Externos)) {
            return false;
        }
        Externos other = (Externos) object;
        if ((this.iDExterno == null && other.iDExterno != null) || (this.iDExterno != null && !this.iDExterno.equals(other.iDExterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Externos[ iDExterno=" + iDExterno + " ]";
    }

}
