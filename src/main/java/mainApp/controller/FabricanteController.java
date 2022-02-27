package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Fabricante;
import mainApp.service.FabricanteServiceImpl;

@RestController
@RequestMapping("/api")
public class FabricanteController {

	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL IMPL. UN COPIAR Y PEGAR
	FabricanteServiceImpl fabricanteServiceImpl;

	// MAPEAMOS LOS METODOS DEL ServiceImpl
	@GetMapping("/fabricantes") // PERMITE LISTAR LOS FABRICANTES CON EL /api/fabricantes EN EL POSTMAN
	public List<Fabricante> listaFabricante() {
		return fabricanteServiceImpl.listaFabricante();
	}

	@GetMapping("fabricantes/nombre/{nombre}") // PARA LISTAR POR UN nombre CONCRETO
	public List<Fabricante> listarFabricanteNombre(@PathVariable(name = "nombre") String nombre) {
		return fabricanteServiceImpl.listarFabricanteNombre(nombre);
	}

	@PostMapping("/fabricantes") // PARA AÑADIR UN FABRICANTE
	public Fabricante saveFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteServiceImpl.addFabricante(fabricante);
	}

	@GetMapping("/fabricantes/{codigo}") // PARA LISTAR POR codigo
	public Fabricante fabricanteById(@PathVariable(name = "codigo") int codigo) {
		/*
		 * Fabricante fab_id = new Fabricante(); fab_id =
		 * fabricanteServiceImpl.getFabricanteById(codigo);
		 * System.out.println("Fabricante By ID: " + fab_id); return fab_id;
		 */
		return fabricanteServiceImpl.getFabricanteById(codigo);
	}

	@PutMapping("/fabricantes/{codigo}") // PARA ACTUALIZAR POR codigo
	public Fabricante actualizarFabricante(@PathVariable(name = "codigo") int codigo,
			@RequestBody Fabricante fabricante) {
		Fabricante fabricante_seleccionado = new Fabricante();
		Fabricante fabricante_actualizado = new Fabricante();

		fabricante_seleccionado = fabricanteServiceImpl.getFabricanteById(codigo);

		fabricante_seleccionado.setNombre(fabricante.getNombre());

		fabricante_actualizado = fabricanteServiceImpl.actualizarFabricante(fabricante_seleccionado);

		System.out.println("El fabricante actualizado es: " + fabricante_actualizado);

		return fabricante_actualizado;
	}

	@DeleteMapping("/fabricantes/{codigo}") // PARA BORRAR POR codigo
	public void deleteFabricante(@PathVariable(name = "codigo") int codigo) {
		fabricanteServiceImpl.deleteFabricante(codigo);
	}
	
	//hola

}
