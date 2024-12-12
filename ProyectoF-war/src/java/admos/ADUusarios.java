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
import manipulaDatos.MDUsuarios;
import modeloDatos.Usuarios;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDUusarios")
@ViewScoped
public class ADUusarios implements Serializable {

    private List<Usuarios> usuariosList; // Lista de municipios para el select
    private Integer selectedUsuario; // ID del municipio seleccionado

    @Inject
    private MDUsuarios mdUsuarios; // Inyección del Session Bean
 
    /**
     * Creates a new instance of ADUusarios
     */
    
    @PostConstruct
    public void init() {
        usuariosList = mdUsuarios.obtenerUsuarios();
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Integer getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Integer selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    public ADUusarios() {
    }
    
}
