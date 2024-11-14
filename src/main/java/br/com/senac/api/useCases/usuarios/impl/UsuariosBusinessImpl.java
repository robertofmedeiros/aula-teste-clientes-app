package br.com.senac.api.useCases.usuarios.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senac.api.entitys.Usuarios;
import br.com.senac.api.frameWork.annotions.Business;
import br.com.senac.api.useCases.usuarios.UsuariosBusiness;
import br.com.senac.api.useCases.usuarios.domains.UsuariosRequestDom;
import br.com.senac.api.useCases.usuarios.domains.UsuariosResponseDom;
import br.com.senac.api.useCases.usuarios.impl.repositorys.UsuariosRepository;

@Business
public class UsuariosBusinessImpl implements UsuariosBusiness{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UsuariosResponseDom login(UsuariosRequestDom usuario) {
        Optional<Usuarios> result = usuariosRepository.findByEmail(usuario.getEmail());
        if(result.isPresent()) {
            if(result.get().getSenha().equals(usuario.getSenha())) {
                return new UsuariosResponseDom(result.get().getId(), result.get().getEmail(), result.get().getSenha());
            }

            throw new RuntimeException("Senha invalida!");
        }
        
        throw new RuntimeException("Usuarios não encontrado!");
    }

    @Override
    public UsuariosResponseDom criar(UsuariosRequestDom usuario) {
        Usuarios result = usuariosRepository.save(new Usuarios(usuario.getEmail(), usuario.getSenha()));

        return new UsuariosResponseDom(result.getId(), result.getEmail(), result.getSenha());
    }

}
