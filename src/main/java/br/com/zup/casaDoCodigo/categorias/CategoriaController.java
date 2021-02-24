package br.com.zup.casaDoCodigo.categorias;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastra(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.toModel();
		manager.persist(categoria);
		return categoria.toString();
	}
}