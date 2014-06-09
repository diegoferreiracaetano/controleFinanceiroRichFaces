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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "entradas", catalog = "financeiro1", schema = "")
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e"),
    @NamedQuery(name = "Entradas.findById", query = "SELECT e FROM Entradas e WHERE e.id = :id"),
    @NamedQuery(name = "Entradas.findByDescricao", query = "SELECT e FROM Entradas e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Entradas.findByValorTotal", query = "SELECT e FROM Entradas e WHERE e.valorTotal = :valorTotal")})
public class Entradas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private Double valorTotal;
    @JoinTable(name = "pagamentos_entradas", joinColumns = {
        @JoinColumn(name = "entradas_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "pagamentos_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Pagamentos> pagamentosList;
    @JoinColumn(name = "franquias_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Franquias franquiasId;
    @JoinColumn(name = "forma_pagamentos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormaPagamentos formaPagamentosId;
    @JoinColumn(name = "contas_id", referencedColumnName = "id")
    @ManyToOne
    private Contas contasId;

    public Entradas() {
    }

    public Entradas(Integer id) {
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pagamentos> getPagamentosList() {
        return pagamentosList;
    }

    public void setPagamentosList(List<Pagamentos> pagamentosList) {
        this.pagamentosList = pagamentosList;
    }

    public Franquias getFranquiasId() {
        return franquiasId;
    }

    public void setFranquiasId(Franquias franquiasId) {
        this.franquiasId = franquiasId;
    }

    public FormaPagamentos getFormaPagamentosId() {
        return formaPagamentosId;
    }

    public void setFormaPagamentosId(FormaPagamentos formaPagamentosId) {
        this.formaPagamentosId = formaPagamentosId;
    }

    public Contas getContasId() {
        return contasId;
    }

    public void setContasId(Contas contasId) {
        this.contasId = contasId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contasId == null) ? 0 : contasId.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime
				* result
				+ ((formaPagamentosId == null) ? 0 : formaPagamentosId
						.hashCode());
		result = prime * result
				+ ((franquiasId == null) ? 0 : franquiasId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pagamentosList == null) ? 0 : pagamentosList.hashCode());
		result = prime * result
				+ ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entradas other = (Entradas) obj;
		if (contasId == null) {
			if (other.contasId != null)
				return false;
		} else if (!contasId.equals(other.contasId))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (formaPagamentosId == null) {
			if (other.formaPagamentosId != null)
				return false;
		} else if (!formaPagamentosId.equals(other.formaPagamentosId))
			return false;
		if (franquiasId == null) {
			if (other.franquiasId != null)
				return false;
		} else if (!franquiasId.equals(other.franquiasId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pagamentosList == null) {
			if (other.pagamentosList != null)
				return false;
		} else if (!pagamentosList.equals(other.pagamentosList))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

    
}
