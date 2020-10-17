package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.model.User;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
