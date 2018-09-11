/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import model.dao.DaoAssunto;
import model.dao.entidades.Assunto;

/**
 *
 * @author Ageeu
 */
@Named(value = "assuntoBean")
@SessionScoped
public class AssuntoBean implements Serializable {

    private List<Assunto> lista;
    private Assunto assunto = new Assunto();
    private DaoAssunto daoA = new DaoAssunto();

    public AssuntoBean() {
        this.lista = daoA.listaAssuntos();
    }

    public List<Assunto> getLista() {
        return lista;
    }

    public void setLista(List<Assunto> lista) {
        this.lista = lista;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

}
