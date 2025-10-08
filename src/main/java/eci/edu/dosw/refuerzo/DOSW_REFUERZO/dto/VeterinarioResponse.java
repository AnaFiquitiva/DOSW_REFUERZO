package eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeterinarioResponse {
    private Long id;
    private String nombre;
    private String especialidad;
}
