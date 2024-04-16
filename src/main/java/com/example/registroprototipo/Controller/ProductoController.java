package com.example.registroprototipo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registroprototipo.Entity.Producto;
import com.example.registroprototipo.Entity.Usuario;
import com.example.registroprototipo.Repositorio.ProductoRepo;
import com.example.registroprototipo.Repositorio.UserRepo;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add-prod")
    public ResponseEntity<String> addProductToUser(@RequestParam Long userId, @RequestBody Producto producto ){
        Usuario usuario = userRepo.findById(userId).orElseThrow( () -> new com.example.registroprototipo.NotFoundException("User not found"));
        producto.setUsuario(usuario);
        productoRepo.save(producto);
        return ResponseEntity.ok("{\"message\": \"Producto agregado exitosamente\"}");
        
    }















    
}
