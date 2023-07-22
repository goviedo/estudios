package cl.mockito.curso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import cl.mockito.curso.service.CategoriaService;
import cl.mockito.curso.model.*;


@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/categorias")
    public List < CategoriasEntity > getAllCategorias() {
        return categoriaService.findAll();
    }
    @GetMapping("/categorias/{id}")
    public ResponseEntity < CategoriasEntity > getCategoriaById(@PathVariable(value = "id") Integer categoriaId)
            throws ResourceNotFoundException {
        CategoriasEntity categoria = categoriaService.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("CategoriasEntity no encontrada para este ID :: " + categoriaId));
        return ResponseEntity.ok().body(categoria);
    }
    @PostMapping("/categorias")
    public CategoriasEntity createCategoria(@Valid @RequestBody CategoriasEntity categoria) {
        return categoriaService.save(categoria);
    }
    @PutMapping("/categorias/{id}")
    public ResponseEntity < CategoriasEntity > updateCategoria(@PathVariable(value = "id") Integer categoriaId,
                                                      @Valid @RequestBody CategoriasEntity categoriaDetails) throws ResourceNotFoundException {
        CategoriasEntity categoria = categoriaService.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("CategoriasEntity no encontrada para este ID :: " + categoriaId));
        categoria.setNombre(categoriaDetails.getNombre());
        final CategoriasEntity updatedCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok(updatedCategoria);
    }
    @DeleteMapping("/categorias/{id}")
    public Map < String, Boolean > deleteCategoria(@PathVariable(value = "id") Integer categoriaId)
            throws ResourceNotFoundException {
        CategoriasEntity categoria = categoriaService.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("CategoriasEntity no encontrada para este ID :: " + categoriaId));
        categoriaService.delete(categoria);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}