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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Externos.findByCargoID", query = "SELECT e FROM Externos e WHERE e.cargoID = :cargoID"),
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "folioExterno")
    private String folioExterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "municipioID")
    private int municipioID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cargoID")
    private int cargoID;
    @Column(name = "plataformaID")
    private Integer plataformaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoAtencionID")
    private int tipoAtencionID;
    @Column(name = "ticketID")
    private Integer ticketID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correoID")
    private int correoID;

    public Externos() {
    }

    public Externos(Integer iDExterno) {
        this.iDExterno = iDExterno;
    }

    public Externos(Integer iDExterno, String folioExterno, int municipioID, int cargoID, int tipoAtencionID, int correoID) {
        this.iDExterno = iDExterno;
        this.folioExterno = folioExterno;
        this.municipioID = municipioID;
        this.cargoID = cargoID;
        this.tipoAtencionID = tipoAtencionID;
        this.correoID = correoID;
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

    public int getMunicipioID() {
        return municipioID;
    }

    public void setMunicipioID(int municipioID) {
        this.municipioID = municipioID;
    }

    public int getCargoID() {
        return cargoID;
    }

    public void setCargoID(int cargoID) {
        this.cargoID = cargoID;
    }

    public Integer getPlataformaID() {
        return plataformaID;
    }

    public void setPlataformaID(Integer plataformaID) {
        this.plataformaID = plataformaID;
    }

    public int getTipoAtencionID() {
        return tipoAtencionID;
    }

    public void setTipoAtencionID(int tipoAtencionID) {
        this.tipoAtencionID = tipoAtencionID;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public int getCorreoID() {
        return correoID;
    }

    public void setCorreoID(int correoID) {
        this.correoID = correoID;
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
