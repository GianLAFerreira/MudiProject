package br.com.mudi.demo.controller;

import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.inject.Inject;
import java.util.List;



@Controller
public class HomeController {

    @Inject
    PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public String home(Model model){


        Iterable<Pedido> pedidos = pedidoRepository.findAll();


        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}
