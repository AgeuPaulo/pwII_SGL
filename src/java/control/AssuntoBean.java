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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    public void salvarAssunto() {
        this.daoA.salvar(this.assunto);
        this.lista = this.daoA.listaAssuntos();
        mensagem("Aviso", "Cadastro realizado com sucesso");
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
    
    public void mensagem(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
