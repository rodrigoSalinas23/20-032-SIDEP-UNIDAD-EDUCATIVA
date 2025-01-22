package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import cl.mineduc.sidep.unidadeducativaapi.services.UnidadEducativaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(name = "Unidad educativa API", path = "/unidad-educativa")
public class UnidadEducativaController {

    private final UnidadEducativaService unidadEducativaService;

    @GetMapping("")
    public ResponseEntity<List<UnidadEducativaModel>> findAll() {
        return ResponseEntity.ok(this.unidadEducativaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadEducativaModel> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.unidadEducativaService.findById(id));
    }

    @GetMapping("/rbd/{rbd}")
    public ResponseEntity<UnidadEducativaModel> findByRbd(@PathVariable("rbd") Long rbd) {
        return ResponseEntity.ok(this.unidadEducativaService.findByRbd(rbd));
    }

    @PostMapping("")
    public ResponseEntity<UnidadEducativaModel> save(@RequestBody UnidadEducativaModel model) {
        return ResponseEntity.ok(this.unidadEducativaService.save(model));
    }

    @PutMapping("/{rbd}")
    public ResponseEntity<UnidadEducativaModel> update(@PathVariable("rbd") Long rbd,
                                                       @RequestBody UnidadEducativaModel model) {
        return ResponseEntity.ok(this.unidadEducativaService.update(rbd, model));
    }


}
