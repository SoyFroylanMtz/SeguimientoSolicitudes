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
@Table(name = "cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByIDCargo", query = "SELECT c FROM Cargos c WHERE c.iDCargo = :iDCargo"),
    @NamedQuery(name = "Cargos.findByNombre", query = "SELECT c FROM Cargos c WHERE c.nombre = :nombre")})
public class Cargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCargo")
    private Integer iDCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;

    public Cargos() {
    }

    public Cargos(Integer iDCargo) {
        this.iDCargo = iDCargo;
    }

    public Cargos(Integer iDCargo, String nombre) {
        this.iDCargo = iDCargo;
        this.nombre = nombre;
    }

    public Integer getIDCargo() {
        return iDCargo;
    }

    public void setIDCargo(Integer iDCargo) {
        this.iDCargo = iDCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCargo != null ? iDCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.iDCargo == null && other.iDCargo != null) || (this.iDCargo != null && !this.iDCargo.equals(other.iDCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Cargos[ iDCargo=" + iDCargo + " ]";
    }
    
}
