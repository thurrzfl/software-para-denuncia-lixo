//desenvolvido por arthur
//data 07/06/2026

package com.denuncialixo.backend.service;
import com.denuncialixo.backend.model.Denuncia;
import com.denuncialixo.backend.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService 
{
  @Autowired
  private DenunciaRepository denunciaRepository;


  public Denuncia criar(Denuncia denuncia)
  
  {
    denuncia.setStatus(Denuncia.Status.PENDENTE);
    return denunciaRepository.save(denuncia);
  }

  public List<Denuncia> listarTodas()
  
  {
    return denunciaRepository.findAll();
  }
  public Optional<Denuncia> buscarPorId(Long id)
  
  {
    return denunciaRepository.findById(id);
  }

  public List<Denuncia> listarPorUsuario(Long usuarioId)
  
  {
    return denunciaRepository.findByUsuarioId(usuarioId);
  }
   
  public List<Denuncia> listarPorStatus(Denuncia.Status status)
   
   {
    return denunciaRepository.findByStatus(status);
   }
 
    public Denuncia atualizarStatus(Long id, Denuncia.Status novoStatus) {
        Denuncia denuncia = denunciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denúncia não encontrada"));
        denuncia.setStatus(novoStatus);
        return denunciaRepository.save(denuncia);
    }

    public void deletar(Long id) {
        denunciaRepository.deleteById(id);
    }
}
