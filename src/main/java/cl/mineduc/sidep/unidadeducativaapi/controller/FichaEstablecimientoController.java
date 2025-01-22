package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.services.FichaEstablecimientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(name = "Ficha Establecimiento API", path = "/ficha-establecimiento")
public class FichaEstablecimientoController {

    private final FichaEstablecimientoService fichaEstablecimientoService;

    @GetMapping("")
    public ResponseEntity<List<FichaEstablecimientoModel>> findAll() {
        return ResponseEntity.ok(this.fichaEstablecimientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaEstablecimientoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.fichaEstablecimientoService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<FichaEstablecimientoModel> save(@RequestBody FichaEstablecimientoModel model) {
        return ResponseEntity.ok(this.fichaEstablecimientoService.save(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaEstablecimientoModel> update(@PathVariable Long id, @RequestBody FichaEstablecimientoModel model) {
        return ResponseEntity.ok(this.fichaEstablecimientoService.update(id, model));
    }

}
