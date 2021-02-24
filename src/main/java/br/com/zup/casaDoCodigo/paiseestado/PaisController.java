package br.com.zup.casaDoCodigo.paiseestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/pais")
	@Transactional
	public String criaPais(@RequestBody @Valid PaisForm form) {
		Pais pais = new Pais(form.getNome());
		manager.persist(pais);
		return pais.toString();
	}
}