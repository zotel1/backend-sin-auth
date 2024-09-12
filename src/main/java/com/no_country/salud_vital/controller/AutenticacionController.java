package com.no_country.salud_vital.controller;

import com.no_country.salud_vital.infra.security.DatosJWTToken;
import com.no_country.salud_vital.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@AuthenticationPrincipal OidcUser principal) {
        String JWTtoken = tokenService.generarToken(principal);
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}

