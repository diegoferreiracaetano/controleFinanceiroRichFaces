/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author DIEGO
 */
@Entity
@Table(name = "saidas", catalog = "financeiro1", schema = "")
@NamedQueries({
    @NamedQuery(name = "Saidas.findAll", query = "SELECT s FROM Saidas s"),
    @NamedQuery(name = "Saidas.findById", query = "SELECT s FROM Saidas s WHERE s.id = :id"),
    @NamedQuery(name = "Saidas.findByDataEmissao", query = "SELECT s FROM Saidas s WHERE s.dataEmissao = :dataEmissao"),
    @NamedQuery(name = "Saidas.findByDataVencimento", query = "SELECT s FROM Saidas s WHERE s.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Saidas.findByDataPagamento", query = "SELECT s FROM Saidas s WHERE s.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "Saidas.findByRecido", query = "SELECT s FROM Saidas s WHERE s.recido = :recido"),
    @NamedQuery(name = "Saidas.findByDescricao", query = "SELECT s FROM Saidas s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Saidas.findByValor", query = "SELECT s FROM Saidas s WHERE s.valor = :valor")})
public class Saidas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "recido")
    private String recido;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @ManyToMany(mappedBy = "saidasList")
    private List<Pagamentos> pagamentosList;
    @JoinColumn(name = "forma_pagamentos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormaPagamentos formaPagamentosId;
    @JoinColumn(name = "despesas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Despesas despesasId;
    @JoinColumn(name = "cedentes_id", referencedColumnName = "id")
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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getRecido() {
        return recido;
    }

    public void setRecido(String recido) {
        this.recido = recido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
    
}
