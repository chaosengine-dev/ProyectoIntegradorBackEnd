package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.model.Usuarios;
import com.proyecto.portfolio.service.IUsuariosService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class LoginController {
    
    @Autowired
    private IUsuariosService interfaceUsuario;
    
    @GetMapping("auth/login")
    public String mostrarLogin(){
        return "logueando";
    }
    
    @PostMapping("auth/login")    
    @CrossOrigin(origins="http://localhost:8080")
    //public Usuarios login(@RequestParam("user") String user, @RequestParam("password") String password){
    public Usuarios login(@RequestBody Usuarios datos){
        //Validar en la base de datos la existencia del usuario y la clave y 
        Boolean isValid = false;
        List<Usuarios> usuarios = interfaceUsuario.getUsuarios();
        for (int i = 0; i < usuarios.size() && !isValid; i++){
            String userBD = usuarios.get(i).getUser().trim();
            String userParam = datos.getUser().trim();

            if (Objects.equals(userParam, userBD)){
                
                if (Objects.equals(usuarios.get(i).getPassword(), datos.getPassword())){
                                System.out.println(userBD + " " + userParam);
                    isValid = true;
                }
            }
        }
        System.out.println(isValid);
        // Fin valida usuario
        if (isValid){
            String token = getJWTToken(datos.getUser());
            Usuarios usuario = new Usuarios();
            usuario.setUser(datos.getUser());
            usuario.setPassword(datos.getPassword());
            usuario.setToken(token);
            return usuario; 
        } else {
            return null;
        }

    }
    
    	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
    
}
