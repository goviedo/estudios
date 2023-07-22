package cl.mockito.curso.service;

import cl.mockito.curso.model.ClientesEntity;
import cl.mockito.curso.repositories.ClientesEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteService {

    @Autowired
    ClientesEntityRepository cer;

    public List<ClientesEntity> findAll() {
        return cer.findAll();
    }

    public Optional<ClientesEntity> findById(Short clienteId) {
        return cer.findById(clienteId);
    }

    public ClientesEntity save(ClientesEntity clienteEntity) {
        return cer.save(clienteEntity);
    }

    public void delete(ClientesEntity clientesEntity) {
        cer.delete(clientesEntity);
    }
}
