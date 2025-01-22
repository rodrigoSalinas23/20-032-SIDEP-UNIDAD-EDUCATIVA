package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.services.EstablecimientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(name = "Establecimiento API", path = "/establecimiento")
public class EstablecimientoController {

    private final EstablecimientoService establecimientoService;

    @GetMapping("")
    public ResponseEntity<List<EstablecimientoModel>> findAll() {
        return ResponseEntity.ok(this.establecimientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablecimientoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.establecimientoService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<EstablecimientoModel> save(@RequestBody EstablecimientoModel model) {
        return ResponseEntity.ok(this.establecimientoService.save(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablecimientoModel> update(@PathVariable Long id, @RequestBody EstablecimientoModel model) {
        return ResponseEntity.ok(this.establecimientoService.update(id, model));
    }

}
