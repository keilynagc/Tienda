
package com.tienda.Service.impl;

import com.tienda.Service.UsuarioDetailsService;
import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService { //Metodo UserDetailsService en ProjectConfig

     @Autowired
     private UsuarioDao usuarioDao;
     
      @Autowired
      private HttpSession session;
      
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar en base de datos el usuario por medio del Dao.
       Usuario usuario = usuarioDao.findByUsername(username);
       
       if(username == null){
           throw new UsernameNotFoundException("El usuario" + username + "no existe");
       }
       
       //Variables de session
        session.removeAttribute("usuarioImagen");//Por si hay una antes mejor se borra
        session.setAttribute("usuarioImagen",usuario.getRutaImagen());
        
        //Extraer los roles
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol:usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(),roles);
    }
    
}
