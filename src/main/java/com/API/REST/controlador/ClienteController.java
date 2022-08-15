package com.API.REST.controlador;

import com.API.REST.exception.ResourceNotFoundException;
import com.API.REST.modelo.Cliente;
import com.API.REST.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clienteAPI")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteById(@PathVariable(value = "id") Long clienteId) {
        return clienteRepository.findById(String.valueOf(clienteId))
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
    }

    @PostMapping("/clientes")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    public Cliente updateCliente(@PathVariable(value = "id") Long clienteId,
                                 @Valid @RequestBody Cliente clienteDetails) {

        Cliente cliente = clienteRepository.findById(String.valueOf(clienteId))
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));

        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setFechaNacimiento(clienteDetails.getFechaNacimiento());
        cliente.setFechaIngreso(clienteDetails.getFechaIngreso());
        cliente.setEstatura(clienteDetails.getEstatura());
        cliente.setPeso(clienteDetails.getPeso());
        cliente.setSexo(clienteDetails.getSexo());
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        Cliente cliente = clienteRepository.findById(String.valueOf(clienteId))
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
        clienteRepository.delete(cliente);
        return ResponseEntity.ok().build();
    }
}
