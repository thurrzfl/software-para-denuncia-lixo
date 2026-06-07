// Desenvolvido por: Arthur
// Data: 07/06/2026

package com.denuncialixo.backend.controller;

import com.denuncialixo.backend.model.Denuncia;
import com.denuncialixo.backend.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping
    public ResponseEntity<Denuncia> criar(@RequestBody Denuncia denuncia) {
        return ResponseEntity.ok(denunciaService.criar(denuncia));
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> listarTodas() {
        return ResponseEntity.ok(denunciaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> buscarPorId(@PathVariable Long id) {
        return denunciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Denuncia>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(denunciaService.listarPorUsuario(usuarioId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Denuncia>> listarPorStatus(@PathVariable Denuncia.Status status) {
        return ResponseEntity.ok(denunciaService.listarPorStatus(status));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Denuncia> atualizarStatus(@PathVariable Long id,
                                                     @RequestParam Denuncia.Status novoStatus) {
        return ResponseEntity.ok(denunciaService.atualizarStatus(id, novoStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        denunciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}