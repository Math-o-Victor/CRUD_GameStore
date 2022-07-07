package br.org.generation.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.gamestore.models.ProdutoModel;
import br.org.generation.gamestore.repository.ProdutoRepository;

@RestController
@RequestMapping("/loja")
@CrossOrigin("*")
public class ProdutoController{
	
	@Autowired
	private ProdutoRepository dados;
	
	@GetMapping
	public ResponseEntity
	
	<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(dados.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id){
		return dados.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/pesqNome/{nome}")
	public ResponseEntity<Object> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(dados.findAllByNomeContainingIgnoreCase(nome));
    }
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel prod){
		return ResponseEntity.status(HttpStatus.CREATED).body(dados.save(prod));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel prod){
		return ResponseEntity.status(HttpStatus.OK).body(dados.save(prod));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		dados.deleteById(id);
	}

}
