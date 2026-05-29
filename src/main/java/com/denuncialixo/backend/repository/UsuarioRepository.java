//criado por Arthur
//data: 25/05/2026
package com.denuncialixo.backend.repository;

import com.denuncialixo.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> buscarPorEmail(@Param("email") String email);

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Optional<Usuario> buscarPorId(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = :email")
    boolean emailJaExiste(@Param("email") String email);
}