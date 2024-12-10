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
@Table(name = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesos.findAll", query = "SELECT p FROM Procesos p"),
    @NamedQuery(name = "Procesos.findByIDProceso", query = "SELECT p FROM Procesos p WHERE p.iDProceso = :iDProceso"),
    @NamedQuery(name = "Procesos.findByType", query = "SELECT p FROM Procesos p WHERE p.type = :type")})
public class Procesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDProceso")
    private Integer iDProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "type")
    private String type;

    public Procesos() {
    }

    public Procesos(Integer iDProceso) {
        this.iDProceso = iDProceso;
    }

    public Procesos(Integer iDProceso, String type) {
        this.iDProceso = iDProceso;
        this.type = type;
    }

    public Integer getIDProceso() {
        return iDProceso;
    }

    public void setIDProceso(Integer iDProceso) {
        this.iDProceso = iDProceso;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProceso != null ? iDProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesos)) {
            return false;
        }
        Procesos other = (Procesos) object;
        if ((this.iDProceso == null && other.iDProceso != null) || (this.iDProceso != null && !this.iDProceso.equals(other.iDProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Procesos[ iDProceso=" + iDProceso + " ]";
    }
    
}
