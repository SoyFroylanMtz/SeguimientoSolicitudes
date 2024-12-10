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
@Table(name = "tipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipos.findAll", query = "SELECT t FROM Tipos t"),
    @NamedQuery(name = "Tipos.findByIDAtencion", query = "SELECT t FROM Tipos t WHERE t.iDAtencion = :iDAtencion"),
    @NamedQuery(name = "Tipos.findByTipo", query = "SELECT t FROM Tipos t WHERE t.tipo = :tipo")})
public class Tipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAtencion")
    private Integer iDAtencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipo")
    private String tipo;

    public Tipos() {
    }

    public Tipos(Integer iDAtencion) {
        this.iDAtencion = iDAtencion;
    }

    public Tipos(Integer iDAtencion, String tipo) {
        this.iDAtencion = iDAtencion;
        this.tipo = tipo;
    }

    public Integer getIDAtencion() {
        return iDAtencion;
    }

    public void setIDAtencion(Integer iDAtencion) {
        this.iDAtencion = iDAtencion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAtencion != null ? iDAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipos)) {
            return false;
        }
        Tipos other = (Tipos) object;
        if ((this.iDAtencion == null && other.iDAtencion != null) || (this.iDAtencion != null && !this.iDAtencion.equals(other.iDAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Tipos[ iDAtencion=" + iDAtencion + " ]";
    }
    
}
