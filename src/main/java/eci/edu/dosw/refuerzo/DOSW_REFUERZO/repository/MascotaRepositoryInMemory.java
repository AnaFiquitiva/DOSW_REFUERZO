package eci.edu.dosw.refuerzo.DOSW_REFUERZO.repository;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Mascota;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.model.Propietario;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MascotaRepositoryInMemory implements MascotaRepository {

    private final Map<Long, Mascota> mascotas = new ConcurrentHashMap<>();

    public MascotaRepositoryInMemory() {
        Propietario propietario1 = new Propietario(1L, "Juan Pérez", "555-1234", "juan.p@email.com");
        mascotas.put(1L, new Mascota(1L, "Firulais", "Perro", "Labrador", 5, propietario1));
        mascotas.put(2L, new Mascota(2L, "Michifus", "Gato", "Siames", 3, propietario1));
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.ofNullable(mascotas.get(id));
    }
}