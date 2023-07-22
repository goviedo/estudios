package cl.mockito.curso.service;

import cl.mockito.curso.model.ClientesEntity;
import cl.mockito.curso.repositories.ClientesEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @Mock
    ClientesEntityRepository cer;

    @InjectMocks
    ClienteService cs;



    List<ClientesEntity> clientes = new ArrayList<ClientesEntity>();
    ClientesEntity c;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);




        c = new ClientesEntity();
        c.setIdcliente((short)1);
        c.setNombre("Gonzalo");
        c.setApemat("Lambert");
        c.setApepat("Oviedo");
        c.setEmail("goviedo.sevenit@gmail.com");
        c.setIdcomuna((short)1);
        c.setTelefono("+56963723603");

        clientes.add(c);

        c = new ClientesEntity();
        c.setIdcliente((short)2);
        c.setNombre("Maria");
        c.setApemat("Teresa");
        c.setApepat("Molero");
        c.setEmail("molero@gmail.com");
        c.setIdcomuna((short)2);
        c.setTelefono("+56976345678");

        clientes.add(c);
    }

    @Test
    void findAll() {
        when(cer.findAll()).thenReturn(clientes);
        assertNotNull(cer.findAll());
    }

    Optional<ClientesEntity> getClienteId(Short id) {

        Optional<ClientesEntity> cl = clientes.stream().filter(c->c.getIdcliente().equals((Short)id)).findFirst();

        return cl;
        /*
        for(ClientesEntity cl:clientes) {
            if(cl.getIdcliente().equals((Short)id)) {

                return Optional.of(cl);
            }
        }
        return Optional.empty();

         */
    }

    // fakes, stubs, spikes. Tipos de tests.
    @DisplayName("Existen los ids 1 y 2")
    @ParameterizedTest
    @ValueSource(shorts = {1,2})
    void findById(Short id) {

        when(cs.findById(id)).thenReturn(getClienteId(id));

        ClientesEntity c = new ClientesEntity();

        Optional<ClientesEntity> ce = cs.findById(id);

        if(ce.isPresent()) {
            c = ce.get();
        }

        assertEquals((short)id,c.getIdcliente());
    }

    // fakes, stubs, spikes. Tipos de tests.
    @DisplayName("No existe el id 3, ni el 50, ni el 100")
    @ParameterizedTest
    @ValueSource(shorts = {3,50,100})
    void findByIdNoExisteElId3(Short id) {

        when(cs.findById(id)).thenReturn(getClienteId(id));

        ClientesEntity c = new ClientesEntity();

        Optional<ClientesEntity> ce = cs.findById(id);

        if(ce.isPresent()) {
            c = ce.get();
        }

        assertNotEquals((short)id,c.getIdcliente());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}