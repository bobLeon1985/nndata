package com.nndata.work.nndata.persintence.mapper;

import com.nndata.work.nndata.domain.Person;
import com.nndata.work.nndata.persintence.entity.Persona;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {ClienteMapper.class})
public interface PersonaMapper {
    @Mappings({
            @Mapping(source = "personaid", target = "personId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "genero", target = "gender"),
            @Mapping(source = "edad", target = "year"),
            @Mapping(source = "identificacion", target = "identification"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "telefono", target = "phone"),
            //@Mapping(source = "cliente",target = "item"),
            //@Mapping(source = "clienteList" , target = "itemsClients"),
    })
    Person toPerson(Persona persona);
    List<Person> toPerson(List<Persona> persona);

    @InheritInverseConfiguration
    //@Mapping(target = "cliente" , ignore = true)
    Persona toPersona(Person person);
}
