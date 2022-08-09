package br.com.mudi.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private String nomeProduto;
    private Double valorNegociavel;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido(String nomeProduto, Double valorNegociavel, LocalDate dataEntrega, String urlProduto, String urlImagem, String descricao) {
        this.nomeProduto = nomeProduto;
        this.valorNegociavel = valorNegociavel;
        this.dataEntrega = dataEntrega;
        this.urlProduto = urlProduto;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
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
}
