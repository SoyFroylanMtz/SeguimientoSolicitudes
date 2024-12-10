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
@Table(name = "plataformas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plataformas.findAll", query = "SELECT p FROM Plataformas p"),
    @NamedQuery(name = "Plataformas.findByIDPlataforma", query = "SELECT p FROM Plataformas p WHERE p.iDPlataforma = :iDPlataforma"),
    @NamedQuery(name = "Plataformas.findByNombre", query = "SELECT p FROM Plataformas p WHERE p.nombre = :nombre")})
public class Plataformas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPlataforma")
    private Integer iDPlataforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;

    public Plataformas() {
    }

    public Plataformas(Integer iDPlataforma) {
        this.iDPlataforma = iDPlataforma;
    }

    public Plataformas(Integer iDPlataforma, String nombre) {
        this.iDPlataforma = iDPlataforma;
        this.nombre = nombre;
    }

    public Integer getIDPlataforma() {
        return iDPlataforma;
    }

    public void setIDPlataforma(Integer iDPlataforma) {
        this.iDPlataforma = iDPlataforma;
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
        hash += (iDPlataforma != null ? iDPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataformas)) {
            return false;
        }
        Plataformas other = (Plataformas) object;
        if ((this.iDPlataforma == null && other.iDPlataforma != null) || (this.iDPlataforma != null && !this.iDPlataforma.equals(other.iDPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Plataformas[ iDPlataforma=" + iDPlataforma + " ]";
    }
    
}
