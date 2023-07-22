package cl.mockito.curso.repositories;

import cl.mockito.curso.model.TipopagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipopagosEntityRepository extends JpaRepository<TipopagosEntity, Short> {
}