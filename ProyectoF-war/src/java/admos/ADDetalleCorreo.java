/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import manipulaDatos.MDDetalleCorreo;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDDetalleCorreo")
@SessionScoped
public class ADDetalleCorreo implements Serializable {

    @Inject
    private MDDetalleCorreo mDDetalleCorreo;
    
    private String asunto;
    
    /**
     * Creates a new instance of ADDetalleCorreo
     */
    public void guardarDetalleCorreo(Integer selectedExterno) {
        try {
            
            mDDetalleCorreo.crearDetalleCorreo("hola", selectedExterno);

        } catch (Exception e) {
            
        }
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    

    public ADDetalleCorreo() {
    }

}
