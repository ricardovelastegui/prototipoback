package com.example.registroprototipo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registroprototipo.Entity.Usuario;

@Repository
public interface UserRepo extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
    
}
