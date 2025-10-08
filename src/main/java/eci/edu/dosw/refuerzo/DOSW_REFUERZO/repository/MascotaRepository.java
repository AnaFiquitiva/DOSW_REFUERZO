package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Mascota;
import java.util.Optional;

public interface MascotaRepository {
    Optional<Mascota> findById(Long id);
}