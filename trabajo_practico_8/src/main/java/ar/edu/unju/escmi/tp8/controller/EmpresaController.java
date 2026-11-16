package ar.edu.unju.escmi.tp8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;

/**
 * API REST para el recurso Empresa.
 * Recibe las solicitudes HTTP y delega la lógica en IEmpresaService.
 */
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	@Autowired
	private IEmpresaService empresaService;

	/** GET /api/empresas -> lista de todas las empresas (200). */
	@GetMapping
	public ResponseEntity<List<Empresa>> obtenerEmpresas() {
		return ResponseEntity.ok(empresaService.obtenerEmpresas());
	}

	/** GET /api/empresas/{id} -> la empresa con ese id (200) o 404 si no existe. */
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
		Empresa empresa = empresaService.obtenerEmpresaPorId(id);
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empresa);
	}

	/** POST /api/empresas -> alta de una empresa enviada en el body como JSON (201). */
	@PostMapping
	public ResponseEntity<Empresa> guardarEmpresa(@RequestBody Empresa empresa) {
		Empresa empresaGuardada = empresaService.guardarEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaGuardada);
	}

	/** PUT /api/empresas/{id} -> modificación completa de la empresa (200) o 404 si no existe. */
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> modificarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
		empresa.setId(id); // el id de la URL indica qué empresa se modifica
		Empresa empresaModificada = empresaService.modificarEmpresa(empresa);
		if (empresaModificada == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empresaModificada);
	}

	/** DELETE /api/empresas/{id} -> baja de la empresa (204) o 404 si no existe. */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
		boolean eliminada = empresaService.eliminarEmpresa(id);
		if (!eliminada) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
