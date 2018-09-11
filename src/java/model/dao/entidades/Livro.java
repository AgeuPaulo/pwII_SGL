/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "livros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findByIdLivro", query = "SELECT l FROM Livro l WHERE l.idLivro = :idLivro")
    , @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Livro.findByAutor", query = "SELECT l FROM Livro l WHERE l.autor = :autor")
    , @NamedQuery(name = "Livro.findByAno", query = "SELECT l FROM Livro l WHERE l.ano = :ano")
    , @NamedQuery(name = "Livro.findByCidade", query = "SELECT l FROM Livro l WHERE l.cidade = :cidade")
    , @NamedQuery(name = "Livro.findByResumo", query = "SELECT l FROM Livro l WHERE l.resumo = :resumo")})
public class Livro implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_livro")
    private Long idLivro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "resumo")
    private String resumo;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @JoinColumn(name = "id_assunto", referencedColumnName = "id_assunto")
    @ManyToOne(optional = false)
    private Assunto idAssunto;

    public Livro() {
    }

    public Livro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Livro(Long idLivro, String titulo, String autor, Date ano, String cidade, String resumo) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.cidade = cidade;
        this.resumo = resumo;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Assunto getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(Assunto idAssunto) {
        this.idAssunto = idAssunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivro != null ? idLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.idLivro == null && other.idLivro != null) || (this.idLivro != null && !this.idLivro.equals(other.idLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.entidades.Livro[ idLivro=" + idLivro + " ]";
    }

    @Override
    public Long getId() {
        return idLivro;
    }
    
}
