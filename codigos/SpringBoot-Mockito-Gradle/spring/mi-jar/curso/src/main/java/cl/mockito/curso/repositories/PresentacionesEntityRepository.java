package cl.mockito.curso.repositories;

import cl.mockito.curso.model.PresentacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentacionesEntityRepository extends JpaRepository<PresentacionesEntity, Short> {
}