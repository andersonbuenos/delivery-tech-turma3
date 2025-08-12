package com.deliverytech.delivery_api.config;

import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Seeds initial Cliente data for local runs and tests.
 * Idempotent: checks email uniqueness before inserting.
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    @Override
    public void run(String... args) {
        // Predefined sample clients (avoid email used in tests: maria@email.com)
        List<Cliente> seeds = List.of(
                Cliente.builder()
                        .nome("João Silva")
                        .email("joao.silva@teste.com")
                        .telefone("11988880001")
                        .ativo(true)
                        .build(),
                Cliente.builder()
                        .nome("Ana Souza")
                        .email("ana.souza@teste.com")
                        .telefone("21988880002")
                        .ativo(true)
                        .build(),
                Cliente.builder()
                        .nome("Pedro Santos")
                        .email("pedro.santos@teste.com")
                        .telefone("31988880003")
                        .ativo(false)
                        .build());

        // Insert only if email not present to keep seeding idempotent
        seeds.forEach(c -> {
            if (!clienteRepository.existsByEmail(c.getEmail())) {
                clienteRepository.save(c);
            }
        });
    }
}
