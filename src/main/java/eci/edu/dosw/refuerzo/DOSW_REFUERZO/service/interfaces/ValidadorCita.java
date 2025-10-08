package eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.impl;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Cita;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository.CitaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidadorCita {

    private final CitaRepository citaRepository;

    public ValidadorCita(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void validar(Cita nuevaCita) {
        List<Cita> citasDelVeterinario = citaRepository.findByVeterinarioId(nuevaCita.getVeterinario().getId());
        for (Cita citaExistente : citasDelVeterinario) {
            if (citaExistente.getFechaHora().equals(nuevaCita.getFechaHora())) {
                throw new CitaConflictivaException(
                        "El veterinario " + nuevaCita.getVeterinario().getNombre() +
                                " ya tiene una cita agendada a esa hora."
                );
            }
        }
    }
}
