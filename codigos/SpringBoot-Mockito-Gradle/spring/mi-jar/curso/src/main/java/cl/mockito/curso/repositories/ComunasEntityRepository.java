package cl.mockito.curso.repositories;

import cl.mockito.curso.model.ComunasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunasEntityRepository extends JpaRepository<ComunasEntity, Short> {
}