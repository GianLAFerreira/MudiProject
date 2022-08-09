package br.com.mudi.demo.controller;

import br.com.mudi.demo.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){

        Pedido pedido = new Pedido("Console Xbox Series S", 2.119, LocalDate.now(),
                "https://www.amazon.com.br/Microsoft-Console-Xbox-Series-S/dp/B08JN2VMGX/?_encoding=UTF8&pd_rd_w=uzZk2&content-id=amzn1.sym.07271deb-23ee-498c-8f97-f25954bcc083&pf_rd_p=07271deb-23ee-498c-8f97-f25954bcc083&pf_rd_r=BPPHPYSB6TF814PMBJVC&pd_rd_wg=c1ewI&pd_rd_r=012b442f-1b44-439c-9eaf-5d7d1d27a783&ref_=pd_gw_ci_mcx_mr_hp_atf_m",
                "https://m.media-amazon.com/images/I/51q4dGy14OL._AC_SX569_.jpg",
                "top de linha");



        List<Pedido> pedidos = List.of(pedido, pedido);
        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}
