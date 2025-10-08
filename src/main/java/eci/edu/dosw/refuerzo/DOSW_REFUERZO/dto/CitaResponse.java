package eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.TipoServicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaResponse {
    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private MascotaResponse mascota;
    private VeterinarioResponse veterinario;
    private TipoServicio tipoServicio;
}