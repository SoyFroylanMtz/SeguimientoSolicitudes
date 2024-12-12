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
    private List<Municipios> municipiosList; // Lista de municipios para el select
    private Integer selectedMunicipio; // ID del municipio seleccionado

    @Inject
    private MDMunicipios mdMunicipios; // Inyección del Session Bean

    @PostConstruct
    public void init() {
        municipiosList = mdMunicipios.obtenerMunicipios();
        if (municipiosList != null) {
            System.out.println("Municipios cargados: " + municipiosList.size());
            for (Municipios municipio : municipiosList) {
                System.out.println("Municipio: ID = " + municipio.getIDMunicipio() + ", Nombre = " + municipio.getNombre());
            }
        } else {
            System.out.println("La lista de municipios es nula.");
        }
    }

    // Getters y setters
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
