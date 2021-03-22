package com.ibm.cursomc.services;

import com.ibm.cursomc.domain.Cliente;
import com.ibm.cursomc.repositories.ClienteRepository;
import com.ibm.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {

        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado ID: " + id + ", Tipo: " + Cliente.class.getName()));
    }

}
