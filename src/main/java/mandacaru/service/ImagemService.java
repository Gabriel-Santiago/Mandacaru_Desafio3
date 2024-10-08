package mandacaru.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mandacaru.model.Imagem;
import mandacaru.model.Imovel;
import mandacaru.repository.ImagemRepository;
import mandacaru.repository.ImovelRepository;

@Service
public class ImagemService { 

	@Autowired
	ImagemRepository imagemRepository;
	
	@Autowired
	ImovelRepository imovelRepository;
	
	// relacionado save
	
	public void save(Imagem entity,int imovel_id) {
		Imovel imovel = imovelRepository.findById(imovel_id).get();
		entity.setNome(imovel.getTitulo() + " " + Timestamp.from(Instant.now()));
		entity.setImovel(imovel);
		imagemRepository.save(entity);
	}


	// relacionado find
	
	public Imagem find(int id) {
		if (id < 1) {
			return null;
		}
		Optional<Imagem> imagem = imagemRepository.findById(id);

		if (imagem.isPresent()) {
			return imagem.get();
		}
		return null;
	}
	
	public List<Imagem> findAll() {
		return imagemRepository.findAll();
	}
	
	// relacionado delete

	public void delete(int id) {
		Imagem imagem = find(id);
		imagemRepository.delete(imagem);
	}

}
