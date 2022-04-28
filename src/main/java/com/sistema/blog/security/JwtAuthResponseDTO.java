package com.sistema.blog.security;

import lombok.Getter;
import lombok.Setter;

public class JwtAuthResponseDTO {

    @Getter @Setter
    private String tokenAcceso;

    @Getter @Setter
    private String tipoToken = "Bearer";

    public JwtAuthResponseDTO(String tokenAcceso, String tipoToken) {
        this.tokenAcceso = tokenAcceso;
        this.tipoToken = tipoToken;
    }

    public JwtAuthResponseDTO(String tokenAcceso) {
        this.tokenAcceso = tokenAcceso;
    }

    
    
}
