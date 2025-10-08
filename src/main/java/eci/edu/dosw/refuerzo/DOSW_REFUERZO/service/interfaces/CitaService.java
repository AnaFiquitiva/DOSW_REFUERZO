package eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.impl;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CitaResponse;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CrearCitaRequest;

import java.util.List;

public interface CitaService {
    CitaResponse agendarCita(CrearCitaRequest request);
    CitaResponse consultarCitaPorId(Long id);
    void cancelarCita(Long id);
    List<CitaResponse> listarCitasPorVeterinario(Long veterinarioId);
    List<CitaResponse> listarCitasPorMascota(Long mascotaId);
}