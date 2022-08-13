package br.com.mudi.demo.repository;

import br.com.mudi.demo.model.Pedido;
import br.com.mudi.demo.model.StatusPedido;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, UUID> {

    List<Pedido> findByNomeProduto(String nome);

    List<Pedido> findByStatus(StatusPedido stats, PageRequest pageRequest);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUserame(String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusAndUsuario(@Param("status") StatusPedido status, @Param("username") String username);
}
