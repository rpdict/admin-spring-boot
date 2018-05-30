package sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sys.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@CrossOrigin
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}