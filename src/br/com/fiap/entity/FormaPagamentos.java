/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "forma_pagamentos", catalog = "financeiro1", schema = "")
@NamedQueries({
    @NamedQuery(name = "FormaPagamentos.findAll", query = "SELECT f FROM FormaPagamentos f"),
    @NamedQuery(name = "FormaPagamentos.findById", query = "SELECT f FROM FormaPagamentos f WHERE f.id = :id"),
    @NamedQuery(name = "FormaPagamentos.findByDescricao", query = "SELECT f FROM FormaPagamentos f WHERE f.descricao = :descricao"),
    @NamedQuery(name = "FormaPagamentos.findByQuantidadeParcelas", query = "SELECT f FROM FormaPagamentos f WHERE f.quantidadeParcelas = :quantidadeParcelas")})
public class FormaPagamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamentosId")
    private List<Entradas> entradasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamentosId")
    private List<Saidas> saidasList;

    public FormaPagamentos() {
    }

    public FormaPagamentos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public List<Entradas> getEntradasList() {
        return entradasList;
    }

    public void setEntradasList(List<Entradas> entradasList) {
        this.entradasList = entradasList;
    }

    public List<Saidas> getSaidasList() {
        return saidasList;
    }

    public void setSaidasList(List<Saidas> saidasList) {
        this.saidasList = saidasList;
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
        if (!(object instanceof FormaPagamentos)) {
            return false;
        }
        FormaPagamentos other = (FormaPagamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fiap.entity.FormaPagamentos[ id=" + id + " ]";
    }
    
}
