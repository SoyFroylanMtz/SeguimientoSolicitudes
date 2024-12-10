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
@Table(name = "correos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correos.findAll", query = "SELECT c FROM Correos c"),
    @NamedQuery(name = "Correos.findByIDCorreo", query = "SELECT c FROM Correos c WHERE c.iDCorreo = :iDCorreo"),
    @NamedQuery(name = "Correos.findByCorreo", query = "SELECT c FROM Correos c WHERE c.correo = :correo"),
    @NamedQuery(name = "Correos.findByNombre", query = "SELECT c FROM Correos c WHERE c.nombre = :nombre")})
public class Correos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCorreo")
    private Integer iDCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    public Correos() {
    }

    public Correos(Integer iDCorreo) {
        this.iDCorreo = iDCorreo;
    }

    public Correos(Integer iDCorreo, String correo, String nombre) {
        this.iDCorreo = iDCorreo;
        this.correo = correo;
        this.nombre = nombre;
    }

    public Integer getIDCorreo() {
        return iDCorreo;
    }

    public void setIDCorreo(Integer iDCorreo) {
        this.iDCorreo = iDCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        hash += (iDCorreo != null ? iDCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correos)) {
            return false;
        }
        Correos other = (Correos) object;
        if ((this.iDCorreo == null && other.iDCorreo != null) || (this.iDCorreo != null && !this.iDCorreo.equals(other.iDCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.Correos[ iDCorreo=" + iDCorreo + " ]";
    }
    
}
