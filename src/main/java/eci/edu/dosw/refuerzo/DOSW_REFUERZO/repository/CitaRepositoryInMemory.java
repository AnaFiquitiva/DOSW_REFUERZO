package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;

import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Cita;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CitaRepositoryInMemory implements CitaRepository {

    private final Map<Long, Cita> citas = new ConcurrentHashMap<>();
    private final AtomicLong secuenciaIds = new AtomicLong();

    @Override
    public Cita save(Cita cita) {
        if (cita.getId() == null) {
            cita.setId(secuenciaIds.incrementAndGet());
        }
        citas.put(cita.getId(), cita);
        return cita;
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return Optional.ofNullable(citas.get(id));
    }

    @Override
    public void deleteById(Long id) {
        citas.remove(id);
    }

    @Override
    public List<Cita> findByVeterinarioId(Long veterinarioId) {
        return citas.values().stream()
                .filter(c -> c.getVeterinario().getId().equals(veterinarioId))
                .toList();
    }

    @Override
    public List<Cita> findByMascotaId(Long mascotaId) {
        return citas.values().stream()
                .filter(c -> c.getMascota().getId().equals(mascotaId))
                .toList();
    }
}