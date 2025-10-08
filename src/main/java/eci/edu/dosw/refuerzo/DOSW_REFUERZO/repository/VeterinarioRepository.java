package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Veterinario;

import java.util.Optional;

public interface VeterinarioRepository {
    Optional<Veterinario> findById(Long id);
}