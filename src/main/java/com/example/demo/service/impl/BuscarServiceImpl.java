package com.example.demo.service.impl;

import com.example.demo.dto.InicioRequestDTO;
import com.example.demo.service.BuscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Servicio
@Service
public class BuscarServiceImpl implements BuscarService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarPlaca(InicioRequestDTO inicioRequestDTO) throws IOException {
        String[] datosPlaca = null;
        Resource resource = resourceLoader.getResource("classpath:placas.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if(inicioRequestDTO.placa().equals(datos[1])) {
                    datosPlaca = new String[5];
                    datosPlaca[0] = datos[2];
                    datosPlaca[1] = datos[3];
                    datosPlaca[2] = datos[4];
                    datosPlaca[3] = datos[5];
                    datosPlaca[4] = datos[6];
                }
            }
        } catch(IOException e) {
            datosPlaca = null;
            throw new IOException(e);
        }

        return datosPlaca;
    }
}
