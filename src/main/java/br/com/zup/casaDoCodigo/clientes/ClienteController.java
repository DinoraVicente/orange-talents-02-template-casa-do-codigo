package br.com.zup.casaDoCodigo.clientes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/cliente")
	@Transactional
	public String cadastraCliente(@RequestBody @Valid ClienteForm form) {
		Cliente cliente = form.toModel(manager);
		manager.persist(cliente);
		
		return cliente.toString();
	}
}