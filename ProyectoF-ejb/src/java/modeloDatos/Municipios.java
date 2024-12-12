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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyfroylan
 */
@Entity
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m ORDER BY m.num ASC"),
    @NamedQuery(name = "Municipios.findByIDMunicipio", query = "SELECT m FROM Municipios m WHERE m.iDMunicipio = :iDMunicipio"),
    @NamedQuery(name = "Municipios.findByNum", query = "SELECT m FROM Municipios m WHERE m.num = :num"),
    @NamedQuery(name = "Municipios.findByNombre", query = "SELECT m FROM Municipios m WHERE m.nombre = :nombre"),
})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMunicipio")
    private Integer iDMunicipio;
    @Column(name = "num")
    private Integer num;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    public Municipios() {
    }

    public Municipios(Integer iDMunicipio) {
        this.iDMunicipio = iDMunicipio;
    }

    public Integer getIDMunicipio() {
        return iDMunicipio;
    }

    public void setIDMunicipio(Integer iDMunicipio) {
        this.iDMunicipio = iDMunicipio;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
        hash += (iDMunicipio != null ? iDMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.iDMunicipio == null && other.iDMunicipio != null) || (this.iDMunicipio != null && !this.iDMunicipio.equals(other.iDMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Municipios[ iDMunicipio=" + iDMunicipio + " ]";
    }
    
}
