package geekBrains.security.repository;

import geekBrains.security.entities.Role;
import geekBrains.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
