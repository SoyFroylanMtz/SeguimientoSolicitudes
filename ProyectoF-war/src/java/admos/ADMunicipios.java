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
import manipulaDatos.MDMunicipios;
import modeloDatos.Municipios;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDMunicipios")
@ViewScoped
public class ADMunicipios implements Serializable {

    /**
     * Creates a new instance of ADMunicipios
     */
    private List<Municipios> municipiosList; 
    private Integer selectedMunicipio; 

    @Inject
    private MDMunicipios mdMunicipios; 

    @PostConstruct
    public void init() {
        municipiosList = mdMunicipios.obtenerMunicipios();
    }

    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    public Integer getSelectedMunicipio() {
        return selectedMunicipio;
    }

    public void setSelectedMunicipio(Integer selectedMunicipio) {
        this.selectedMunicipio = selectedMunicipio;
    }

}
