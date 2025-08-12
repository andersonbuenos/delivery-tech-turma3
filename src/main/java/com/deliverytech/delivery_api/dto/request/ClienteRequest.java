package com.deliverytech.delivery_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class ClienteRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
}
