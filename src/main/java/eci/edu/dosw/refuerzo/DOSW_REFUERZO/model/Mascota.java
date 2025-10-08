package eci.edu.dosw.refuerzo.DOSW_REFUERZO.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mascota {
    @EqualsAndHashCode.Include
    private Long id;
    private String nombre;
    private String tipo; // Ej: "Perro", "Gato"
    private String raza;
    private int edad;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Propietario propietario;
}
