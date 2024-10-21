package com.example.msgestionenvio.entity;

import com.example.msgestionenvio.dto.ClienteDto;
import com.example.msgestionenvio.dto.LibrocargaDto;
import com.example.msgestionenvio.dto.RegistroenvioDto;
import com.example.msgestionenvio.feign.LibrocargaFeign;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Gestionenvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private String categoria;


    private Integer registroenvioId;
    @Transient
    private RegistroenvioDto registroenvioDto ;

    private Integer LibrocargaId;
    @Transient
    private LibrocargaDto librocargaDto;

    private Integer ClienteId;
    @Transient
    private ClienteDto clienteDto;



}
