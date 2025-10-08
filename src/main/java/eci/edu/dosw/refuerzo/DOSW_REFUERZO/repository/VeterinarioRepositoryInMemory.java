package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Veterinario;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VeterinarioRepositoryInMemory implements VeterinarioRepository {

    private final Map<Long, Veterinario> veterinarios = new ConcurrentHashMap<>();

    public VeterinarioRepositoryInMemory() {
        veterinarios.put(1L, new Veterinario(1L, "Dra. Ana Gómez", "General", "VET-001"));
        veterinarios.put(2L, new Veterinario(2L, "Dr. Carlos Ruiz", "Cirugía", "VET-002"));
    }

    @Override
    public Optional<Veterinario> findById(Long id) {
        return Optional.ofNullable(veterinarios.get(id));
    }
}