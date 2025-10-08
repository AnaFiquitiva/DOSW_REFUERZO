package eci.edu.dosw.refuerzo.DOSW_REFUERZO.util;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CitaResponse;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CrearCitaRequest;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    CitaResponse toResponse(Cita cita);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mascota", ignore = true)
    @Mapping(target = "veterinario", ignore = true)
    Cita toEntity(CrearCitaRequest request);

    List<CitaResponse> toResponseList(List<Cita> citas);
}