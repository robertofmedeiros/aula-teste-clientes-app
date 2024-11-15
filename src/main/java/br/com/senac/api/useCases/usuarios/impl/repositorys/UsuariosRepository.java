package br.com.senac.api.useCases.usuarios.impl.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.api.entitys.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
    Optional<Usuarios> findByEmail(String email);
}
