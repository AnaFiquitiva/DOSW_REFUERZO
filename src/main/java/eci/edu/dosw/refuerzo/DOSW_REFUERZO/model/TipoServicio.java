package eci.edu.dosw.refuerzo.DOSW_REFUERZO.model;


import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum TipoServicio implements Servicio {

    CONSULTA_GENERAL("Consulta General", new BigDecimal("50.00")),
    VACUNACION("Vacunación", new BigDecimal("30.00")),
    CIRUGIA_MENOR("Cirugía Menor", new BigDecimal("250.00")),
    LIMPIEZA_DENTAL("Limpieza Dental", new BigDecimal("100.00"));

    private final String nombre;
    private final BigDecimal costoBase;

    TipoServicio(String nombre, BigDecimal costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }
}