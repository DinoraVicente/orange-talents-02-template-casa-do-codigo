package br.com.zup.casaDoCodigo.detalhesite;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.casaDoCodigo.livros.Livro;

@RestController
public class DetalhesSiteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/produto/{id}")
	@Transactional
	public DetalhesSiteLivros list(@PathVariable Long id){
		//find retorna nulo caso não encontre o id
		Livro livroBuscado = Optional.ofNullable(manager.find(Livro.class, id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		DetalhesSiteLivros detalhesSiteLivros = new DetalhesSiteLivros(livroBuscado);
		return detalhesSiteLivros;
	}
}
