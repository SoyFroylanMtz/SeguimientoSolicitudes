/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import manipulaDatos.MDExterno;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDExternos")
@SessionScoped
public class ADExternos implements Serializable {

    @Inject
    private MDExterno mDExterno;
    @Inject
    private ADMunicipios aDMunicipios;
    @Inject
    private ADPlataformas aDPlataformas;
    @Inject
    private ADCorreos aDCorreos;
    
    private Integer selectedMunicipio;
    private Integer selectedPlataforma;
    private Integer selectedCorreo;
    /**
     * Creates a new instance of ADExternos
     */
    public void guardarExterno(Integer selectedTicket) {
        selectedMunicipio = aDMunicipios.getSelectedMunicipio();
        selectedPlataforma = aDPlataformas.getSelectedPlataforma();
        selectedCorreo = aDCorreos.getSelectedCorreo();
        
        mDExterno.crearExterno(selectedMunicipio, selectedPlataforma, selectedTicket, selectedCorreo);
    }

    public ADExternos() {
    }

}
