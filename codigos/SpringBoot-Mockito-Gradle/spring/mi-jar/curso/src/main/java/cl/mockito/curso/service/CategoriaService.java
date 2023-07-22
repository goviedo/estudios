package cl.mockito.curso.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cl.mockito.curso.model.CategoriasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import cl.mockito.curso.repositories.CategoriasEntityRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaService {
	
	@Autowired
	private CategoriasEntityRepository cr;

	public List<CategoriasEntity> findAll() {
		return cr.findAll();
	}

	public Optional<CategoriasEntity> findById(Integer categoriaId) {
		return cr.findById(categoriaId);
	}

	public CategoriasEntity save(@Valid CategoriasEntity categoria) {
		return cr.save(categoria);
	}

	public void delete(CategoriasEntity categoria) {
		cr.delete(categoria);
		
	}

}
