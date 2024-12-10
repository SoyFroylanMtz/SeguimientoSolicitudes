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
import javax.persistence.Lob;
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
@Table(name = "detalleCorreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCorreo.findAll", query = "SELECT d FROM DetalleCorreo d"),
    @NamedQuery(name = "DetalleCorreo.findByIDDetalleCorreo", query = "SELECT d FROM DetalleCorreo d WHERE d.iDDetalleCorreo = :iDDetalleCorreo"),
    @NamedQuery(name = "DetalleCorreo.findByExternoID", query = "SELECT d FROM DetalleCorreo d WHERE d.externoID = :externoID")})
public class DetalleCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDetalleCorreo")
    private Integer iDDetalleCorreo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "externoID")
    private int externoID;

    public DetalleCorreo() {
    }

    public DetalleCorreo(Integer iDDetalleCorreo) {
        this.iDDetalleCorreo = iDDetalleCorreo;
    }

    public DetalleCorreo(Integer iDDetalleCorreo, String asunto, String respuesta, String observacion, int externoID) {
        this.iDDetalleCorreo = iDDetalleCorreo;
        this.asunto = asunto;
        this.respuesta = respuesta;
        this.observacion = observacion;
        this.externoID = externoID;
    }

    public Integer getIDDetalleCorreo() {
        return iDDetalleCorreo;
    }

    public void setIDDetalleCorreo(Integer iDDetalleCorreo) {
        this.iDDetalleCorreo = iDDetalleCorreo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getExternoID() {
        return externoID;
    }

    public void setExternoID(int externoID) {
        this.externoID = externoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDetalleCorreo != null ? iDDetalleCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCorreo)) {
            return false;
        }
        DetalleCorreo other = (DetalleCorreo) object;
        if ((this.iDDetalleCorreo == null && other.iDDetalleCorreo != null) || (this.iDDetalleCorreo != null && !this.iDDetalleCorreo.equals(other.iDDetalleCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloDatos.DetalleCorreo[ iDDetalleCorreo=" + iDDetalleCorreo + " ]";
    }
    
}
