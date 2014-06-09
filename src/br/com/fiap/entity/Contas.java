/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "contas", catalog = "financeiro1", schema = "")
@NamedQueries({
    @NamedQuery(name = "Contas.findAll", query = "SELECT c FROM Contas c"),
    @NamedQuery(name = "Contas.findById", query = "SELECT c FROM Contas c WHERE c.id = :id"),
    @NamedQuery(name = "Contas.findByNome", query = "SELECT c FROM Contas c WHERE c.nome = :nome"),
    @NamedQuery(name = "Contas.findByAgencia", query = "SELECT c FROM Contas c WHERE c.agencia = :agencia"),
    @NamedQuery(name = "Contas.findByConta", query = "SELECT c FROM Contas c WHERE c.conta = :conta")})
public class Contas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "agencia")
    private String agencia;
    @Column(name = "conta")
    private String conta;
    @OneToMany(mappedBy = "contasId")
    private List<Entradas> entradasList;

    public Contas() {
    }

    public Contas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public List<Entradas> getEntradasList() {
        return entradasList;
    }

    public void setEntradasList(List<Entradas> entradasList) {
        this.entradasList = entradasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contas)) {
            return false;
        }
        Contas other = (Contas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fiap.entity.Contas[ id=" + id + " ]";
    }
    
}
