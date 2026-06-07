//Desenvolvido por Arthur 
//Data: 07/06/2026

package com.denuncialixo.backend.repository;

import com.denuncialixo.backend.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long>
{
  List<Denuncia> findByUsuarioId(Long usuarioId);
  List<Denuncia> findByStatus(Denuncia.Status status);


}

    


