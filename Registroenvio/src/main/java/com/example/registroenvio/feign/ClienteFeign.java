package com.example.registroenvio.feign;

import com.example.registroenvio.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path ="/clientes")
public interface ClienteFeign {
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Integer id);
}
