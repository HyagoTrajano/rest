package com.restapp.Controller;

import java.util.List;

import com.restapp.Model.Convidado;
import com.restapp.Repository.ConvidadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConvidadoController {
    
    @Autowired
    ConvidadoRepository convidadoRepository;

	@GetMapping("/convidado")
	public ResponseEntity<List<Convidado>>getAllConvidado(){
		List<Convidado>convidadoList = convidadoRepository.findAll();
		if(convidadoList.isEmpty()) {
			System.out.println("erro do sistema no endpoint evento");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Convidado>>(convidadoList, HttpStatus.OK);
		}
	}


	@GetMapping("/convidado/{id_convidado}")
	public ResponseEntity<Convidado>getOneEvento(@PathVariable(value = "id_convidado") long id_convidado){
		java.util.Optional<Convidado>convidadoO = convidadoRepository.findById(id_convidado);
		
		if(!convidadoO.isPresent()) {
			System.out.println("evento nao cadastrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Convidado>(convidadoO.get(), HttpStatus.OK);
		}
	}

	
	@PostMapping("/convidado")
	public ResponseEntity<Convidado> saveConvidado(@RequestBody Convidado convidado){
		return new ResponseEntity<Convidado>(convidadoRepository.save(convidado), HttpStatus.CREATED);
	}

	@DeleteMapping("/convidado/{id_convidado}")
	public ResponseEntity <?> deleteConvidado(@PathVariable(value="id_convidado") long id_convidado){
		java.util.Optional<Convidado> convidadoO = convidadoRepository.findById(id_convidado);
		if(!convidadoO.isPresent()){
			System.out.println("evento nao localizado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			convidadoRepository.delete(convidadoO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/convidado/{id_convidado}")
	public ResponseEntity<Convidado> updateConvidado(@PathVariable(value="id_convidado") long id_convidado, @RequestBody Convidado convidado){
		java.util.Optional<Convidado> convidadoO = convidadoRepository.findById(id_convidado);
		if(!convidadoO.isPresent()){
			System.out.println("evento nao encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			convidado.setId_convidado(convidadoO.get().getId_convidado());
			return new ResponseEntity<Convidado>(convidadoRepository.save(convidado), HttpStatus.OK);
		}
	}
}
