package com.nndata.work.nndata.persintence.mapper;

import com.nndata.work.nndata.domain.Client;
import com.nndata.work.nndata.persintence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mappings({
            @Mapping(source = "clienteid", target = "clientId"),
            @Mapping(source = "contrasenia", target = "password"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "personaid", target = "item"),
            //@Mapping(source = "cuentaList" , target = "cuentaList")
    })
    Client toClient(Cliente cliente);
    List<Client> toClients (List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "cuentaList", ignore = true)
    Cliente toCliente(Client client);
}
