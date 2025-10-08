package eci.edu.dosw.refuerzo.DOSW_REFUERZO.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
    private Long id;
    private String nombre;
    private String especialidad;
    private String numeroLicencia;
}