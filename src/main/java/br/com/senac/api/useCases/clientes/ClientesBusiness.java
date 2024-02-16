package br.com.senac.api.useCases.clientes;

import br.com.senac.api.frameWork.utils.SenacException;
import br.com.senac.api.useCases.clientes.domanis.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

public interface ClientesBusiness {
    ClientesResponseDom criarCliente(ClientesRequestDom cliente) throws SenacException;
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom carregarCliente(Long id);

    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom cliente) throws SenacException;
    void deletarCliente(Long id);
}
