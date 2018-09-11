/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.entidades.Assunto;

/**
 *
 * @author Ageeu
 */
public class DaoAssunto extends GenericDao<Assunto> {
    
    public List<Assunto> listaAssuntos() {
        List<Assunto> usuarios = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Assunto u", Assunto.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
}
