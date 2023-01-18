package shupeyko.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shupeyko.entities.Authority;

@Repository
public interface RoleRepository extends CrudRepository<Authority, Long> {
}
