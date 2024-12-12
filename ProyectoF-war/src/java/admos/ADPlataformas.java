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
import manipulaDatos.MDPlataforma;
import modeloDatos.Plataformas;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDPlataformas")
@ViewScoped
public class ADPlataformas implements Serializable {

    private List<Plataformas> plataformasList; 
    private Integer selectedPlataforma; 

    @Inject
    private MDPlataforma mdPlataformas; 

    @PostConstruct
    public void init() {
        plataformasList = mdPlataformas.obtenerPlataformas();
    }

    public List<Plataformas> getPlataformasList() {
        return plataformasList;
    }

    public void setPlataformasList(List<Plataformas> plataformasList) {
        this.plataformasList = plataformasList;
    }

    public Integer getSelectedPlataforma() {
        return selectedPlataforma;
    }

    public void setSelectedPlataforma(Integer selectedPlataforma) {
        this.selectedPlataforma = selectedPlataforma;
    }
    
    /**
     * Creates a new instance of ADPlataformas
     */
    public ADPlataformas() {
    }
    
}
