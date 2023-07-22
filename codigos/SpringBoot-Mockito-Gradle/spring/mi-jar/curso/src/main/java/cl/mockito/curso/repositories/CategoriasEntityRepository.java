package cl.mockito.curso.repositories;

import cl.mockito.curso.model.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriasEntityRepository extends JpaRepository<CategoriasEntity, Integer> {

}
