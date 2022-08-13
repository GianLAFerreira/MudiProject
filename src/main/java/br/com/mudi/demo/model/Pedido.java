package br.com.mudi.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String nomeProduto;
    private Double valorNegociavel;
    private LocalDate dataEntrega;
    @Column(length = 2083)
    private String urlProduto;
    @Column(length = 2083)
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;





    public Pedido(String nomeProduto, Double valorNegociavel, LocalDate dataEntrega, String urlProduto, String urlImagem, String descricao) {
        this.nomeProduto = nomeProduto;
        this.valorNegociavel = valorNegociavel;
        this.dataEntrega = dataEntrega;
        this.urlProduto = urlProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
    }

    public Pedido() {

    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorNegociavel() {
        return valorNegociavel;
    }

    public void setValorNegociavel(Double valorNegociavel) {
        this.valorNegociavel = valorNegociavel;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
