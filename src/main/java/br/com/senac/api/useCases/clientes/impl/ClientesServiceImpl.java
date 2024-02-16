package br.com.senac.api.useCases.clientes.impl;

import br.com.senac.api.frameWork.utils.SenacException;
import br.com.senac.api.useCases.clientes.ClientesBusiness;
import br.com.senac.api.useCases.clientes.ClientesService;
import br.com.senac.api.useCases.clientes.domanis.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domanis.ClientesResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesBusinessImpl clientesBusiness;

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom cliente) throws SenacException {
        return clientesBusiness.criarCliente(cliente);
    }

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return clientesBusiness.carregarClientes();
    }

    @Override
    public ClientesResponseDom carregarCliente(Long id) {
        return clientesBusiness.carregarCliente(id);
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom cliente) throws SenacException {
        return clientesBusiness.atualizarCliente(id, cliente);
    }

    @Override
    public void deletarCliente(Long id) {
        clientesBusiness.deletarCliente(id);
    }
}
