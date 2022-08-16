package br.com.mudi.demo.api;

import br.com.mudi.demo.dto.RequisicaoNovaOferta;
import br.com.mudi.demo.model.OfertaModel;
import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Inject
    private PedidoRepository pedidoRepository;
    
    @PostMapping
    public OfertaModel CriaOferta(@Valid  RequisicaoNovaOferta requisicao){

        Optional<Pedido> pedidoBucado = pedidoRepository.findById(requisicao.getPedidoId());

        if (!pedidoBucado.isPresent()){
            return null;
        }
        Pedido pedido = pedidoBucado.get();

        OfertaModel nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);
        System.out.println("Salvou o pedido");

        return nova;
    }
}
