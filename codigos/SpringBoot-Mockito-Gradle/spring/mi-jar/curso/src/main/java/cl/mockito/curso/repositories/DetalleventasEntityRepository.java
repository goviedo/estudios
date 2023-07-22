package cl.mockito.curso.repositories;

import cl.mockito.curso.model.DetalleventasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleventasEntityRepository extends JpaRepository<DetalleventasEntity, Short> {
}