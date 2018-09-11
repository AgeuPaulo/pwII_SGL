/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.entidades.Livro;

/**
 *
 * @author Ageeu
 */
public class DaoLivro extends GenericDao<Livro> {
    
     public List<Livro> listaLivros() {
        List<Livro> usuarios = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Livro u", Livro.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }

}
