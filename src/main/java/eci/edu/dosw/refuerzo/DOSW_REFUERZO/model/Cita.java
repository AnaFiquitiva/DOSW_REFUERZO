package eci.edu.dosw.refuerzo.DOSW_REFUERZO.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita {
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Mascota mascota;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Veterinario veterinario;

    private TipoServicio tipoServicio;
}