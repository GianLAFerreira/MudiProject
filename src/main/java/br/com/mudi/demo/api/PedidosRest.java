package br.com.mudi.demo.api;

import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.model.StatusPedido;
import br.com.mudi.demo.repository.PedidoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Inject
    private PedidoRepository pedidoRepository;

    @GetMapping("/aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);

        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
    }
}

