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
@Table(name = "tipoAtencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAtencion.findAll", query = "SELECT t FROM TipoAtencion t"),
    @NamedQuery(name = "TipoAtencion.findByIDTipoAtencion", query = "SELECT t FROM TipoAtencion t WHERE t.iDTipoAtencion = :iDTipoAtencion"),
    @NamedQuery(name = "TipoAtencion.findByNombre", query = "SELECT t FROM TipoAtencion t WHERE t.nombre = :nombre")})
public class TipoAtencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTipoAtencion")
    private Integer iDTipoAtencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;

    public TipoAtencion() {
    }

    public TipoAtencion(Integer iDTipoAtencion) {
        this.iDTipoAtencion = iDTipoAtencion;
    }

    public TipoAtencion(Integer iDTipoAtencion, String nombre) {
        this.iDTipoAtencion = iDTipoAtencion;
        this.nombre = nombre;
    }

    public Integer getIDTipoAtencion() {
        return iDTipoAtencion;
    }

    public void setIDTipoAtencion(Integer iDTipoAtencion) {
        this.iDTipoAtencion = iDTipoAtencion;
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
        hash += (iDTipoAtencion != null ? iDTipoAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtencion)) {
            return false;
        }
        TipoAtencion other = (TipoAtencion) object;
        if ((this.iDTipoAtencion == null && other.iDTipoAtencion != null) || (this.iDTipoAtencion != null && !this.iDTipoAtencion.equals(other.iDTipoAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.TipoAtencion[ iDTipoAtencion=" + iDTipoAtencion + " ]";
    }
    
}
