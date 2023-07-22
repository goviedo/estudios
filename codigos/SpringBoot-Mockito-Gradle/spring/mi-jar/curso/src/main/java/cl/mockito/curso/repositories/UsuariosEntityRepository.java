package cl.mockito.curso.repositories;

import cl.mockito.curso.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosEntityRepository extends JpaRepository<UsuariosEntity, Short> {
}