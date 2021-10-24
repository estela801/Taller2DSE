/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.RegistroDao;
import javax.faces.bean.SessionScoped;
import modelo.entidad.Registro;


/**
 *
 * @author elcon
 */
@ManagedBean
@SessionScoped
public class RegistroControl {

    /**
     * Creates a new instance of registroControl
     */
    private List<Registro> listaRegistros;
    private Registro registro;

    public RegistroControl() {
        registro = new Registro();
    }

    public List<Registro> getListaRegistros() {
        RegistroDao ad = new RegistroDao();
        listaRegistros = ad.listarRegistros();
        return listaRegistros;
    }

    public void setListaRegistros(List<Registro> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public void limpiarRegistro() {
        registro = new Registro();
    }

    public void agregarRegistro() {
        RegistroDao ad = new RegistroDao();
        ad.agregar(registro);
    }

    public void modificarRegistro() {
        RegistroDao ad = new RegistroDao();
        ad.modificar(registro);
        limpiarRegistro();
    }

    public void eliminarRegistro() {
        RegistroDao ad = new RegistroDao();
        ad.eliminar(registro);
        limpiarRegistro();
    }
}
