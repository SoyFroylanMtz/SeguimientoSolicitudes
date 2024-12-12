/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import manipulaDatos.MDCorreos;
import modeloDatos.Correos;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDCorreos")
@ViewScoped
public class ADCorreos implements Serializable {

    private List<Correos> correosList; 
    private Integer selectedCorreo; 

    @Inject
    private MDCorreos mdCorreos;
    
    /**
     * Creates a new instance of ADCorreos
     */
    
    @PostConstruct
    public void init() {
        correosList = mdCorreos.obtenerCorreos();
    }

    public Integer getSelectedCorreo() {
        return selectedCorreo;
    }

    public void setSelectedCorreo(Integer selectedCorreo) {
        this.selectedCorreo = selectedCorreo;
    }

    public List<Correos> getCorreosList() {
        return correosList;
    }

    public void setCorreosList(List<Correos> correosList) {
        this.correosList = correosList;
    }
    
    public ADCorreos() {
    }
    
}
