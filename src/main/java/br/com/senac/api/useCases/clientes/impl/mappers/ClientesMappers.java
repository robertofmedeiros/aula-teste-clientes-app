package br.com.senac.api.useCases.clientes.impl.mappers;

import br.com.senac.api.entitys.Clientes;
import br.com.senac.api.useCases.clientes.domanis.ClientesRequestDom;
import br.com.senac.api.useCases.clientes.domanis.ClientesResponseDom;

import java.util.List;

public class ClientesMappers {
    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(clientes.getId());
        out.setNome(clientes.getNome());
        out.setSobreNome(clientes.getSobreNome());

        return out;
    }

    public static List<ClientesResponseDom> listClientesToListClientesResponseDom(List<Clientes> clientes){
        List<ClientesResponseDom> out = clientes.stream()
                .map(ClientesMappers :: clientesToClientesResponseDom)
                .toList();

        return out;
    }

    public static Clientes clientesRequestDomToClientes(ClientesRequestDom clientesRequestDom){
        Clientes out = new Clientes();
        out.setNome(clientesRequestDom.getNome());
        out.setSobreNome(clientesRequestDom.getSobreNome());

        return out;
    }
}
