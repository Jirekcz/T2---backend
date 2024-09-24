package com.example.demo.controller;

import com.example.demo.dto.InicioRequestDTO;
import com.example.demo.dto.InicioResponseDTO;
import com.example.demo.service.BuscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/buscar")
public class BuscarController {

    @Autowired
    BuscarService buscarService;

    @PostMapping("/search")
    public InicioResponseDTO search(@RequestBody InicioRequestDTO inicioRequestDTO) {
        try {
            String[] datosPlaca = buscarService.buscarPlaca(inicioRequestDTO);
            if (datosPlaca == null) {
                return new InicioResponseDTO("01", "ERROR: Placa no encontrada", "", "", "", "", "");
            } else {
                return new InicioResponseDTO("00", "", datosPlaca[0], datosPlaca[1], datosPlaca[2], datosPlaca[3], datosPlaca[4]);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return new InicioResponseDTO("99", "ERROR: Ocurrio un problema", "", "", "", "", "");
        }
    }

}
