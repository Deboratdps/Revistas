package br.com.tiacademy.revistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.revistas.domain.Revista;
import br.com.tiacademy.revistas.repository.RevistaRepository;

import java.util.List;
import java.util.Objects;


@Service
public class RevistaService {
	@Autowired
	private RevistaRepository revistaRepository;
	
	public List<Revista> listar(){
		return revistaRepository.findAll();
	}
	
	public Revista porId(Long id){
		return revistaRepository.findById(id).orElse(null);
	}
	
	public Revista criar(Revista revista){
		return revistaRepository.save(revista);
	}
	
	public Revista editar(Long id, Revista editado) {
		var recuperado = porId(id);
		
		if(Objects.isNull(recuperado)) {
			throw new RuntimeException("Não foi encontrado");
		}
		
		recuperado.setNome(editado.getNome());
		
		return revistaRepository.save(recuperado);
	}
	
	public void excluir(Long id) {		
		revistaRepository.deleteById(id);
	}
}
