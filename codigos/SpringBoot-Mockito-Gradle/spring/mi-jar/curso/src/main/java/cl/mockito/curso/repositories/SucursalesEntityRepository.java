package cl.mockito.curso.repositories;

import cl.mockito.curso.model.SucursalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesEntityRepository extends JpaRepository<SucursalesEntity, Short> {
}