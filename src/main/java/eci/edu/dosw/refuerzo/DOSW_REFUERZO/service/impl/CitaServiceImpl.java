package eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.impl;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CitaResponse;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CrearCitaRequest;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.exception.RecursoNoEncontradoException;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Cita;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository.CitaRepository;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository.MascotaRepository;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository.VeterinarioRepository;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.interfaces.CitaService;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.interfaces.ValidadorCita;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.util.CitaMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final CitaMapper citaMapper;
    private final ValidadorCita validadorCita;

    public CitaServiceImpl(CitaRepository citaRepository, MascotaRepository mascotaRepository, VeterinarioRepository veterinarioRepository, CitaMapper citaMapper, ValidadorCita validadorCita) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
        this.citaMapper = citaMapper;
        this.validadorCita = validadorCita;
    }

    @Override
    @Transactional
    public CitaResponse agendarCita(CrearCitaRequest request) {
        var mascota = mascotaRepository.findById(request.getIdMascota())
                .orElseThrow(() -> new RecursoNoEncontradoException("Mascota no encontrada con ID: " + request.getIdMascota()));
        var veterinario = veterinarioRepository.findById(request.getIdVeterinario())
                .orElseThrow(() -> new RecursoNoEncontradoException("Veterinario no encontrado con ID: " + request.getIdVeterinario()));

        Cita nuevaCita = citaMapper.toEntity(request);
        nuevaCita.setMascota(mascota);
        nuevaCita.setVeterinario(veterinario);

        validadorCita.validar(nuevaCita);

        Cita citaGuardada = citaRepository.save(nuevaCita);
        return citaMapper.toResponse(citaGuardada);
    }

    @Override
    public CitaResponse consultarCitaPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cita no encontrada con ID: " + id));
        return citaMapper.toResponse(cita);
    }

    @Override
    @Transactional
    public void cancelarCita(Long id) {
        if (citaRepository.findById(id).isEmpty()) {
            throw new RecursoNoEncontradoException("Cita no encontrada con ID: " + id);
        }
        citaRepository.deleteById(id);
    }

    @Override
    public List<CitaResponse> listarCitasPorVeterinario(Long veterinarioId) {
        if (veterinarioRepository.findById(veterinarioId).isEmpty()) {
            throw new RecursoNoEncontradoException("Veterinario no encontrado con ID: " + veterinarioId);
        }
        return citaRepository.findByVeterinarioId(veterinarioId).stream()
                .map(citaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitaResponse> listarCitasPorMascota(Long mascotaId) {
        if (mascotaRepository.findById(mascotaId).isEmpty()) {
            throw new RecursoNoEncontradoException("Mascota no encontrada con ID: " + mascotaId);
        }
        return citaRepository.findByMascotaId(mascotaId).stream()
                .map(citaMapper::toResponse)
                .collect(Collectors.toList());
    }
}