package com.restapp.Controller;

import java.util.List;
import java.util.Optional;

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

import com.restapp.Model.Evento;
import com.restapp.Model.Responsavel;
import com.restapp.Repository.EventoRepository;
import com.restapp.Repository.ResponsavelRepository;

@RestController
public class EventoController {

	@Autowired
	EventoRepository eventoRepository;

	@Autowired
	ResponsavelRepository responsavelRepository;
	
	@GetMapping("/evento")
	public ResponseEntity<List<Evento>> getAllEvento(){
		List<Evento>eventoList = eventoRepository.findAll();
		if(eventoList.isEmpty()) {
			System.out.println("erro do sistema no endpoint evento");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Evento>>(eventoList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Evento>getOneEvento(@PathVariable(value = "id") long id){
		Optional<Evento>eventoO = eventoRepository.findById(id);
		
		if(!eventoO.isPresent()) {
			System.out.println("evento nao cadastrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Evento>(eventoO.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/evento")
	public ResponseEntity<Evento> saveEvento(@RequestBody Evento evento){
		return new ResponseEntity<Evento>(eventoRepository.save(evento), HttpStatus.CREATED);
	}

	@DeleteMapping("/evento/{id}")
	public ResponseEntity <?> deleteEvento(@PathVariable(value="id") long id){
		Optional<Evento> eventoO = eventoRepository.findById(id);
		if(!eventoO.isPresent()){
			System.out.println("evento nao localizado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			eventoRepository.delete(eventoO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/evento/{id}")
	public ResponseEntity<Evento> updateEvento(@PathVariable(value="id") long id, @RequestBody Evento evento){
		Optional<Evento> eventoO = eventoRepository.findById(id);
		if(!eventoO.isPresent()){
			System.out.println("evento nao encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			evento.setId_evento(eventoO.get().getId_evento());
			return new ResponseEntity<Evento>(eventoRepository.save(evento), HttpStatus.OK);
		}
	}

	@GetMapping("/responsavel")
	public ResponseEntity<List<Responsavel>>getAllResponsavel(){
		List<Responsavel>responsavelList = responsavelRepository.findAll();
		if(responsavelList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<Responsavel>>(responsavelList, HttpStatus.OK);
		}
	}

	
	@GetMapping("/responsavel/{id_responsavel}")
	public ResponseEntity<Responsavel> getOneResponsavel(@PathVariable(value = "id_responsavel") long id_responsavel){
		Optional<Responsavel>responsavell = responsavelRepository.findById(id_responsavel);
		
		if(!responsavell.isPresent()) {
			System.out.println("evento nao cadastrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Responsavel>(responsavell.get(), HttpStatus.OK);
		}
	}

	@PostMapping("/responsavel")
	public ResponseEntity<Responsavel> saveResponsavel(@RequestBody Responsavel responsavel){
		return new ResponseEntity<Responsavel>(responsavelRepository.save(responsavel), HttpStatus.CREATED);
	}

	@DeleteMapping("/responsavel/{id_responsavel}")
	public ResponseEntity <?> deleteResponsavel(@PathVariable(value="id_responsavel") long id_responsavel){
		Optional<Responsavel> responsavell = responsavelRepository.findById(id_responsavel);
		if(!responsavell.isPresent()){
			System.out.println("evento nao localizado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			responsavelRepository.delete(responsavell.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/responsavel/{id_responsavel}")
	public ResponseEntity<Responsavel> updateResponsavel(@PathVariable(value="id_responsavel") long id_responsavel, @RequestBody Responsavel responsavel){
		Optional<Responsavel> responsavell = responsavelRepository.findById(id_responsavel);
		if(!responsavell.isPresent()){
			System.out.println("evento nao encontrado");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			responsavel.setId_responsavel(responsavell.get().getId_responsavel());
			return new ResponseEntity<Responsavel>(responsavelRepository.save(responsavel), HttpStatus.OK);
		}
	}
}
