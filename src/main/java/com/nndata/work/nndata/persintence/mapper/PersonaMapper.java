package com.nndata.work.nndata.persintence.mapper;

import com.nndata.work.nndata.domain.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {ClienteMapper.class})
public interface PersonaMapper {

}
