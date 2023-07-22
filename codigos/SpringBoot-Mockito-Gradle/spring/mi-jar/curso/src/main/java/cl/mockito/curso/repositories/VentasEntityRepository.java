package cl.mockito.curso.repositories;

import cl.mockito.curso.model.VentasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasEntityRepository extends JpaRepository<VentasEntity, Short> {
}