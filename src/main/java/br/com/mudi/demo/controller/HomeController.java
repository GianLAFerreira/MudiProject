package br.com.mudi.demo.controller;

import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.model.StatusPedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.security.Principal;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Inject
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model, Pageable principal){

        Iterable<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, PageRequest.of(0,10, Sort.by("id").descending()));
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
