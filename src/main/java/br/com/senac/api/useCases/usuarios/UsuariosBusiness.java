package br.com.senac.api.useCases.usuarios;

import br.com.senac.api.useCases.usuarios.domains.UsuariosRequestDom;
import br.com.senac.api.useCases.usuarios.domains.UsuariosResponseDom;

public interface UsuariosBusiness {
    UsuariosResponseDom login(UsuariosRequestDom usuario);
    UsuariosResponseDom criar(UsuariosRequestDom usuario);
}
