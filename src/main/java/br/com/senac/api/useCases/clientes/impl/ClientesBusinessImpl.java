package br.com.senac.api.useCases.clientes.impl;

import br.com.senac.api.entitys.Clientes;
import br.com.senac.api.frameWork.annotions.Business;
import br.com.senac.api.frameWork.utils.SenacException;
import br.com.senac.api.useCases.clientes.ClientesBusiness;
import br.com.senac.api.useCases.clientes.domanis.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domanis.ClientesResponseDom;
import br.com.senac.api.useCases.clientes.impl.mappers.ClientesMappers;
import br.com.senac.api.useCases.clientes.impl.respositorys.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Business
public class ClientesBusinessImpl implements ClientesBusiness {
    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom cliente) throws SenacException {
        List<String> messages = this.validacoesCliente(cliente);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Clientes in = ClientesMappers.clientesRequestDomToClientes(cliente);

        Clientes result = clientesRepository.save(in);

        return ClientesMappers.clientesToClientesResponseDom(result);
    }

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        List<Clientes> result = clientesRepository.findAll();

        List<ClientesResponseDom> out = ClientesMappers.listClientesToListClientesResponseDom(result);

        return out;
    }

    @Override
    public ClientesResponseDom carregarCliente(Long id) {
        Optional<Clientes> result = clientesRepository.findById(id);

        if(result.isPresent()){
            return ClientesMappers.clientesToClientesResponseDom(result.get());
        }

        return null;
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom cliente) throws SenacException {
        List<String> messages = this.validacoesCliente(cliente);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Optional<Clientes> result = clientesRepository.findById(id).map(record -> {
            record.setNome(cliente.getNome());
            record.setSobreNome(cliente.getSobreNome());
            return clientesRepository.save(record);
        });

        if(result.isPresent()){
            return ClientesMappers.clientesToClientesResponseDom(result.get());
        }

        return null;
    }

    public List<String> validacoesCliente(ClientesRequestDom cliente){
        List<String> messages = new ArrayList<>();

        if(cliente.getNome() == null || cliente.getNome().equals("")){
            messages.add("Nome do cliente não informado");
        }

        if(cliente.getSobreNome() == null || cliente.getSobreNome().equals("")){
            messages.add("Sobrenome do cliente não informado");
        }

        return messages;
    }
}
