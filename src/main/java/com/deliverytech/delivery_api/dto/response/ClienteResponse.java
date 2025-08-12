package com.deliverytech.delivery_api.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;
}
