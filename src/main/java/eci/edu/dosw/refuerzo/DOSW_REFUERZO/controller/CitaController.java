package eci.edu.dosw.refuerzo.DOSW_REFUERZO.controller;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CitaResponse;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.dto.CrearCitaRequest;
import eci.edu.dosw.refuerzo.DOSW_REFUERZO.service.interfaces.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponse> agendarCita(@Valid @RequestBody CrearCitaRequest request) {
        CitaResponse citaCreada = citaService.agendarCita(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(citaCreada.getId())
                .toUri();
        return ResponseEntity.created(location).body(citaCreada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponse> consultarCita(@PathVariable Long id) {
        CitaResponse cita = citaService.consultarCitaPorId(id);
        return ResponseEntity.ok(cita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarCita(@PathVariable Long id) {
        citaService.cancelarCita(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veterinarios/{veterinarioId}/citas")
    public ResponseEntity<List<CitaResponse>> listarCitasPorVeterinario(@PathVariable Long veterinarioId) {
        List<CitaResponse> citas = citaService.listarCitasPorVeterinario(veterinarioId);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/mascotas/{mascotaId}/citas")
    public ResponseEntity<List<CitaResponse>> listarCitasPorMascota(@PathVariable Long mascotaId) {
        List<CitaResponse> citas = citaService.listarCitasPorMascota(mascotaId);
        return ResponseEntity.ok(citas);
    }
}