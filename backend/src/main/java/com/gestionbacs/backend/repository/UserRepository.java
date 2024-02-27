package com.gestionbacs.backend.repository;

import com.gestionbacs.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   
   Optional<User> findByMatricule(String matricule);


    boolean existsByEmail(String email);
}
