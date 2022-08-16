package br.com.mudi.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String nomeProduto;
    private BigDecimal valorNegociavel;
    private LocalDate dataEntrega;
    @Column(length = 2083)
    private String urlProduto;
    @Column(length = 2083)
    private String urlImagem;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<OfertaModel> ofertas;


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

    public BigDecimal getValorNegociavel() {
        return valorNegociavel;
    }

    public void setValorNegociavel(BigDecimal valorNegociavel) {
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

    public List<OfertaModel> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaModel> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valorNegociavel=" + valorNegociavel +
                ", dataEntrega=" + dataEntrega +
                ", urlProduto='" + urlProduto + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", ofertas=" + ofertas +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
