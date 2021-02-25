package br.com.zup.casaDoCodigo.paiseestado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/estado")
	@Transactional
	public String criaEstado(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.toModel(manager);
		
		Query query = manager.createQuery("select e from Estado e where e.pais.id = :id and e.nome = :nome");
		query.setParameter("id", form.getIdPais());
		query.setParameter("nome", form.getNome());
		List<?> resultList = query.getResultList();
		
		if(resultList.size() >= 1) {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse estado já foi cadastrado nesse país!");
		} else {
			manager.persist(estado);
			return estado.toString();
		}
	}
}