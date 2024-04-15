package com.example.registroprototipo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registroprototipo.Entity.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long>{

    
}
