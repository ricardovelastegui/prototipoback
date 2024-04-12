package com.example.registroprototipo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registroprototipo.Entity.Usuario;
import com.example.registroprototipo.Repositorio.UserRepo;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        if (userRepo.findByUsername(usuario.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"El usuario ya existe\"}");
        }
        userRepo.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Usuario registrado exitosamente\"}");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = userRepo.findByUsername(usuario.getUsername());
        if (usuarioExistente == null || !usuarioExistente.getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }
    
}
