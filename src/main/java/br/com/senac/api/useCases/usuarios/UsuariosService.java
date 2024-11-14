package br.com.senac.api.useCases.usuarios;

import br.com.senac.api.useCases.usuarios.domains.UsuariosRequestDom;
import br.com.senac.api.useCases.usuarios.domains.UsuariosResponseDom;

public interface UsuariosService {
    UsuariosResponseDom login(UsuariosRequestDom usuario);
    UsuariosResponseDom criar(UsuariosRequestDom usuario);
}
