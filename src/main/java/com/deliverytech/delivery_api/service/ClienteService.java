package com.deliverytech.delivery_api.service;


import com.deliverytech.delivery_api.dto.request.ClienteRequest;
import com.deliverytech.delivery_api.dto.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse criar(ClienteRequest request);
    List<ClienteResponse> listar();
    ClienteResponse buscarPorId(Long id);
    ClienteResponse atualizar(Long id, ClienteRequest request);
    void deletar(Long id);
}