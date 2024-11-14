package br.com.senac.api.useCases.usuarios.impl;

import org.springframework.stereotype.Service;

import br.com.senac.api.useCases.usuarios.UsuariosBusiness;
import br.com.senac.api.useCases.usuarios.UsuariosService;
import br.com.senac.api.useCases.usuarios.domains.UsuariosRequestDom;
import br.com.senac.api.useCases.usuarios.domains.UsuariosResponseDom;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    private UsuariosBusiness usuariosBusiness;

    public UsuariosServiceImpl(UsuariosBusinessImpl usuariosBusinessImpl) {
        this.usuariosBusiness = usuariosBusinessImpl;
    }

    

    @Override
    public UsuariosResponseDom login(UsuariosRequestDom usuario) {
        return usuariosBusiness.login(usuario);
    }

    @Override
    public UsuariosResponseDom criar(UsuariosRequestDom usuario) {
        return usuariosBusiness.criar(usuario);
    }

}
