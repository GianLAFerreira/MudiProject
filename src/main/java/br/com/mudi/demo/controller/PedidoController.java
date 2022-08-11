package br.com.mudi.demo.controller;

import br.com.mudi.demo.dto.RequisicaoNovoPedido;
import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Inject
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido req){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido req, BindingResult result){

        if (result.hasErrors()){
            return "pedido/formulario";
        }

        Pedido pedido = req.toPedido();
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
