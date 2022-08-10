package br.com.mudi.demo.repository;

import br.com.mudi.demo.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, UUID> {

    List<Pedido> findByNomeProduto(String nome);


}
