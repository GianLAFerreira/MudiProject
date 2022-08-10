package br.com.mudi.demo.controller;

import br.com.mudi.demo.dto.RequisicaoNovoPedido;
import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Inject
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido req){

        Pedido pedido = req.toPedido();
        pedidoRepository.save(pedido);

        return "pedido/formulario";
    }
}
