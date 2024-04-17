package com.example.registroprototipo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registroprototipo.Entity.Producto;
import com.example.registroprototipo.Repositorio.ProductoRepo;

@Service
public class ProductoService {

    @Autowired
    ProductoRepo productoRepo;

    public Producto agregarprodu(Producto producto){
        return productoRepo.save(producto);
    }

    //ya está
    public void borrarproducto(Long id){
        productoRepo.deleteById(id);
    }

    //ya está
    public List<Producto> obtenerproductos(){
        return productoRepo.findAll();
    }

    public Producto buscarProductoporId(Long id){

        return productoRepo.findById(id).orElse(null);
    }

    public Producto filtrarProductosPornombre(String nombre){
        return productoRepo.findByNombre(nombre);
    }

    public Producto actualizardeProducto(Long id, Producto productoactualizar){
        Optional<Producto> optionalProducto = productoRepo.findById(id);
        if (optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            producto.setNombre(productoactualizar.getNombre());
            producto.setPrice(productoactualizar.getPrice());
            return productoRepo.save(producto);
        } else{
            throw new RuntimeException("Producto no encontrado con ID: "+ id);
        }
       
    }



}
