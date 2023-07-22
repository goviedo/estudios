package cl.mockito.curso.repositories;

import cl.mockito.curso.model.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesEntityRepository extends JpaRepository<ClientesEntity, Short> {
}