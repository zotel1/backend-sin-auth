package com.no_country.salud_vital.infra.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.no_country.salud_vital.domain.usuarios.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.no_country.salud_vital.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener el token del header
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            var token = authHeader.replace("Bearer ", "");
            try {
                var nombreUsuario = tokenService.getUsuario(token); // Cambiado a getUsuario
                if (nombreUsuario != null) {
                    // Token válido
                    var usuario = usuarioRepository.findByLogin(nombreUsuario);
                    if (usuario == null) {
                        // Crea un nuevo usuario en la base de datos si no existe
                        usuario = new Usuario();
                        usuario.setLogin(nombreUsuario);
                        // Suponiendo que el token tiene un "name" y "email" en el payload
                       // usuario.setNombre(decodedJWT.getClaim("name").asString());
                       // usuario.setEmail(decodedJWT.getClaim("email").asString());
                        usuario.setClave("");
                        usuarioRepository.save(usuario);
                    }
                        var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                            usuario.getAuthorities()); // Forzamos un inicio de sesión
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (JWTDecodeException e) {
                // Manejar el error de decodificación del token
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
