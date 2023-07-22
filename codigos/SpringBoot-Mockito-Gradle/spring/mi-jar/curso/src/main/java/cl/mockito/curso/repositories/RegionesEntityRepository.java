package cl.mockito.curso.repositories;

import cl.mockito.curso.model.RegionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionesEntityRepository extends JpaRepository<RegionesEntity, Short> {
}