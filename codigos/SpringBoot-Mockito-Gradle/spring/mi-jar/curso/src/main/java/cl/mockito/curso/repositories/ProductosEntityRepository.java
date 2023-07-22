package cl.mockito.curso.repositories;

import cl.mockito.curso.model.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosEntityRepository extends JpaRepository<ProductosEntity, Short> {
}