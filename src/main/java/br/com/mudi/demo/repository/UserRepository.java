package br.com.mudi.demo.repository;

import br.com.mudi.demo.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {

    UserModel findByUsername(String username);
}
