package com.example.registroprototipo.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.registroprototipo.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;

    private String password;
    private UserRole role;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

    @Override
    public String toString(){
        //omito mostrar la propiedad de productos 
        return "Usuario{" + "id=" + id + ", username='" +  username + '\'' + 
        ", password='" +  password + '\'' + 
        ", role='" + role + '\'' + '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, username, password, role);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if ( obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id) && 
               Objects.equals(username, usuario.username) &&
               Objects.equals(password, usuario.password) &&
               Objects.equals(role, usuario.role);

    }



}
