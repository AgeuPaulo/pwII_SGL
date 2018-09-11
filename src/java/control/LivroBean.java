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
import model.dao.DaoLivro;
import model.dao.entidades.Assunto;
import model.dao.entidades.Livro;
import model.dao.entidades.Tipo;

/**
 *
 * @author Ageeu
 */
@Named(value = "livroBean")
@SessionScoped
public class LivroBean implements Serializable {

     private List<Livro> lista;
     private Livro livro = new Livro();
     private Tipo tipo = new Tipo();
     private Assunto assunto = new Assunto();
     private DaoLivro daoL = new DaoLivro();
     
     
    public LivroBean() {
        this.lista = daoL.listaLivros();
    }

    public void salvarLivro() {
        this.daoL.salvar(this.livro);
        this.lista = this.daoL.listaLivros();
        mensagem("Aviso", "Cadastro realizado com sucesso");
    }
    
    public void editarLivro() {
        this.livro = daoL.bucar(this.livro.getIdLivro(), Livro.class);
    }

    public void excluirLivro() {
        this.daoL.remover(this.livro.getIdLivro(), Livro.class);  
        this.lista = this.daoL.listaLivros();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLista() {
        return lista;
    }

    public void setLista(List<Livro> lista) {
        this.lista = lista;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
