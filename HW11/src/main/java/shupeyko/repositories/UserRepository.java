package shupeyko.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shupeyko.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
