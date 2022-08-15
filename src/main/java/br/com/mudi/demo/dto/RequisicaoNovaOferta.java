package br.com.mudi.demo.dto;

import br.com.mudi.demo.model.OfertaModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class RequisicaoNovaOferta {
    private UUID pedidoId;
    private String valor;
    private String dataEntrega;
    private String comentario;

    public UUID getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public OfertaModel toOferta() {
        OfertaModel oferta = new OfertaModel();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        oferta.setValor(new BigDecimal(this.valor));

        return oferta;
    }
}
