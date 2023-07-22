package cl.mockito.curso;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import cl.mockito.curso.model.CategoriasEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cl.mockito.curso.repositories.CategoriasEntityRepository;
import cl.mockito.curso.service.CategoriaService;

class CategoriaTest {
	
	@Mock
    CategoriasEntityRepository cmr;
	
	@InjectMocks
	CategoriaService cs;
	
	List<CategoriasEntity> categorias;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		categorias = new ArrayList<CategoriasEntity>();

		CategoriasEntity ct = new CategoriasEntity();
		
		ct = new CategoriasEntity();
		ct.setIdcategoria((short)1);
		ct.setNombre("Mock");
		
		categorias.add(ct);
		
		ct = new CategoriasEntity();
		ct.setIdcategoria((short)2);
		ct.setNombre("Maestro");
		
		categorias.add(ct);
	}

	@Test
	void findAll() {
		when(cmr.findAll()).thenReturn(categorias);
		assertNotNull(cmr.findAll());
		System.out.println(cs.findAll().get(0).getNombre());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void findById(Integer id) {
		when(cs.findById(id)).thenReturn(cs.findById(id));
		assertNotNull(cs.findById(id));		
		System.out.println(cs.findById(id));
	}

}
