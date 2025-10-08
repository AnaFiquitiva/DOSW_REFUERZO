package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;


import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    void deleteById(Long id);
    List<Cita> findByVeterinarioId(Long veterinarioId);
    List<Cita> findByMascotaId(Long mascotaId);
}