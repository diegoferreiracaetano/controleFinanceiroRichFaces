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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "saidas", catalog = "financeiro1", schema = "")
public class Saidas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "recibo")
    private String recibo;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private Double valorTotal;
    @ManyToMany(mappedBy = "saidasList")
    private List<Pagamentos> pagamentosList;
    @JoinColumn(name = "forma_pagamentos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormaPagamentos formaPagamentosId;
    @JoinColumn(name = "despesas_id",nullable = true, referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Despesas despesasId;
    @JoinColumn(name = "cedentes_id",nullable = true, referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cedentes cedentesId;

    public Saidas() {
    }

    public Saidas(Integer id) {
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

    public List<Pagamentos> getPagamentosList() {
        return pagamentosList;
    }

    public void setPagamentosList(List<Pagamentos> pagamentosList) {
        this.pagamentosList = pagamentosList;
    }

    public FormaPagamentos getFormaPagamentosId() {
        return formaPagamentosId;
    }

    public void setFormaPagamentosId(FormaPagamentos formaPagamentosId) {
        this.formaPagamentosId = formaPagamentosId;
    }

    public Despesas getDespesasId() {
        return despesasId;
    }

    public void setDespesasId(Despesas despesasId) {
        this.despesasId = despesasId;
    }

    public Cedentes getCedentesId() {
        return cedentesId;
    }

    public void setCedentesId(Cedentes cedentesId) {
        this.cedentesId = cedentesId;
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
        if (!(object instanceof Saidas)) {
            return false;
        }
        Saidas other = (Saidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fiap.entity.Saidas[ id=" + id + " ]";
    }
    
    

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
    
}
