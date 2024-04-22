package com.example.registroprototipo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.registroprototipo.Entity.Producto;
import com.example.registroprototipo.Entity.Usuario;
import com.example.registroprototipo.Repositorio.UserRepo;
import com.example.registroprototipo.Service.ProductoService;

    @RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // @Autowired
    // private UserRepo userRepo;

    // @PostMapping("/add-prod")
    // public ResponseEntity<String> addProductToUser(@RequestParam Long userId, @RequestBody Producto producto ){
    //     Usuario usuario = userRepo.findById(userId).orElseThrow( () -> new com.example.registroprototipo.NotFoundException("User not found"));
    //     producto.setUsuario(usuario);
    //     productoRepo.save(producto);
    //     return ResponseEntity.ok("{\"message\": \"Producto agregado exitosamente\"}");
        
    // }
    @PostMapping("/agregar")
    public Producto agregarprodu(@RequestBody Producto producto){
        return productoService.agregarprodu(producto);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarproducto(@PathVariable Long id){
        productoService.borrarproducto(id);
    }

    @GetMapping("/obtener")
    @ResponseBody
    public List<Producto> obtenerproductos(){
        return productoService.obtenerproductos();
    }

    @GetMapping("/obtener/{id}")
    @ResponseBody
    public Producto buscarProductoporId(@PathVariable Long id){
        return productoService.buscarProductoporId(id);
    }

    @GetMapping("/filtrar")
    @ResponseBody
    public ResponseEntity<Producto> filtrarProductosPornombre(@RequestParam String nombre){
        Producto producto = productoService.filtrarProductosPornombre(nombre);
        if(producto != null){
            return ResponseEntity.ok(producto);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
   

    @PutMapping("/modificar/{id}")
    public Producto actualizardeProducto(@PathVariable Long id, @RequestBody Producto productoactualizar){
        return productoService.actualizardeProducto(id, productoactualizar);
    }


}
