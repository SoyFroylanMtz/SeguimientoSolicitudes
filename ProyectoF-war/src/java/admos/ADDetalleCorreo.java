/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import accesoDatos.DetalleCorreoFacade;
import accesoDatos.ExternosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import manipulaDatos.MDDetalleCorreo;
import modeloDatos.DetalleCorreo;
import modeloDatos.Externos;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDDetalleCorreo")
@SessionScoped
public class ADDetalleCorreo implements Serializable {

    @Inject
    private MDDetalleCorreo mDDetalleCorreo;
    @Inject
    private ExternosFacade externosFacade;

    private List<DetalleCorreo> listaDetalles;
    private Map<Integer, Externos> mapaExternos;

    private String asunto;

    @PostConstruct
    public void init() {
        System.out.println("Inicializando ADDetalleCorreo...");
        cargarDetalles(); // Cargar todos los detalles al inicio
    }

    /**
     * Creates a new instance of ADDetalleCorreo
     */
    public void guardarDetalleCorreo(Integer selectedExterno) {
        try {

            mDDetalleCorreo.crearDetalleCorreo("hola", selectedExterno);

        } catch (Exception e) {

        }
    }

    public void cargarDetalles() {
        listaDetalles = mDDetalleCorreo.obtenerTodosLosDetalles(); // Obtener todos los detalles
        mapaExternos = new HashMap<>();

        for (DetalleCorreo detalle : listaDetalles) {
            Externos externo = externosFacade.find(detalle.getExternoID());
            if (externo != null) {
                mapaExternos.put(detalle.getExternoID(), externo); // Asociar Externo con su ID
            } else {
                System.out.println("No se encontró Externo para ID: " + detalle.getExternoID());
            }
        }
    }

    public Externos externoByID(Integer externoID) {
        return mapaExternos.get(externoID); // Busca en el mapa
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public List<DetalleCorreo> getListaDetalles() {
        return listaDetalles;
    }

    public Map<Integer, Externos> getMapaExternos() {
        return mapaExternos;
    }

    public void setMapaExternos(Map<Integer, Externos> mapaExternos) {
        this.mapaExternos = mapaExternos;
    }

    public void setListaDetalles(List<DetalleCorreo> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public ADDetalleCorreo() {
    }

}
