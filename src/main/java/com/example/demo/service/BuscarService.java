package com.example.demo.service;

import com.example.demo.dto.InicioRequestDTO;

import java.io.IOException;

public interface BuscarService {
    String[] buscarPlaca(InicioRequestDTO inicioRequestDTO) throws IOException;
}
