package eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.*;


import lombok.Data;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class CrearCitaRequest {
    @NotNull(message = "El ID de la mascota es obligatorio")
    private Long idMascota;

    @NotNull(message = "El ID del veterinario es obligatorio")
    private Long idVeterinario;

    @NotNull(message = "La fecha y hora son obligatorias")
    @Future(message = "La fecha y hora deben ser futuras")
    private LocalDateTime fechaHora;

    @NotNull(message = "El motivo de la consulta es obligatorio")
    private String motivo;

    @NotNull(message = "El tipo de servicio es obligatorio")
    private TipoServicio tipoServicio;
}