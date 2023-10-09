package com.example.safaeats.converter;

import com.example.safaeats.dto.PersonaDTO;
import com.example.safaeats.model.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {


    @Mapping(source = "fechaNacimiento", target = "fecha_nacimiento", qualifiedByName = "conversorFechaString")
    PersonaDTO toDTO(Persona entity);

    @Mapping(target = "fechaNacimiento", source = "fecha_nacimiento", qualifiedByName = "conversorStringFecha")
    Persona toEntity(PersonaDTO dto);

    List<PersonaDTO> toDTO(List<Persona> listEntity);

    List<Persona> toEntity(List<PersonaDTO> listDTOs);



    @Named(value ="conversorFechaString")
    default String LocalDateToString(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }

    @Named(value ="conversorStringFecha")
    default LocalDate StringToLocalDate(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha,formatter);
    }

}
