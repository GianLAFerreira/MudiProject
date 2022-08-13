package br.com.mudi.demo.controller;

import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.model.StatusPedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("usuario")
public class UserController {

    @Inject
    PedidoRepository pedidoRepository;

    @GetMapping("pedidos")
    public String home(Model model, Principal principal){

        Iterable<Pedido> pedidos = pedidoRepository.findAllByUserame(principal.getName());
        model.addAttribute("pedidos", pedidos);
        return "usuario/home";
    }

    @GetMapping("pedidos/{status}")
    public String aguardando(@PathVariable("status") String status, Model model, Principal principal){

        Iterable<Pedido> pedidos = pedidoRepository.findByStatusAndUsuario(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)), principal.getName());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/usuario/home";
    }
}
