/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.entidades;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "assuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assunto.findAll", query = "SELECT a FROM Assunto a")
    , @NamedQuery(name = "Assunto.findByIdAssunto", query = "SELECT a FROM Assunto a WHERE a.idAssunto = :idAssunto")
    , @NamedQuery(name = "Assunto.findByInformacao", query = "SELECT a FROM Assunto a WHERE a.informacao = :informacao")
    , @NamedQuery(name = "Assunto.findByObservacao", query = "SELECT a FROM Assunto a WHERE a.observacao = :observacao")})
public class Assunto implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_assunto")
    private Long idAssunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "informacao")
    private String informacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAssunto")
    private Collection<Livro> livroCollection;

    public Assunto() {
    }

    public Assunto(Long idAssunto) {
        this.idAssunto = idAssunto;
    }

    public Assunto(Long idAssunto, String informacao, String observacao) {
        this.idAssunto = idAssunto;
        this.informacao = informacao;
        this.observacao = observacao;
    }

    public Long getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(Long idAssunto) {
        this.idAssunto = idAssunto;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public Collection<Livro> getLivroCollection() {
        return livroCollection;
    }

    public void setLivroCollection(Collection<Livro> livroCollection) {
        this.livroCollection = livroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAssunto != null ? idAssunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assunto)) {
            return false;
        }
        Assunto other = (Assunto) object;
        if ((this.idAssunto == null && other.idAssunto != null) || (this.idAssunto != null && !this.idAssunto.equals(other.idAssunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.entidades.Assunto[ idAssunto=" + idAssunto + " ]";
    }

    @Override
    public Long getId() {
        return idAssunto;
    }
    
}
