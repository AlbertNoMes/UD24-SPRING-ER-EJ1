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

import mainApp.dto.Articulo;
import mainApp.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL IMPL. UN COPIAR Y PEGAR
	ArticuloServiceImpl articuloServiceImpl;
	
	// MAPEAMOS LOS METODOS DEL ServiceImpl
	@GetMapping("/articulos") // PERMITE LISTAR LOS ARTICULOS CON EL /api/articulos EN EL POSTMAN
	public List<Articulo> listaArticulo() {
		return articuloServiceImpl.listaArticulos();
	}

	@GetMapping("articulos/nombre/{nombre}") // PARA LISTAR POR UN nombre CONCRETO
	public List<Articulo> listarArticuloNombre(@PathVariable(name = "nombre") String nombre) {
		return articuloServiceImpl.listarArticuloNombre(nombre);
	}

	@PostMapping("/articulos") // PARA AÑADIR UN ARTICULO
	public Articulo saveArticulo(@RequestBody Articulo articulo) {
		return articuloServiceImpl.addArticulo(articulo);
	}

	@GetMapping("/articulos/{codigo}") // PARA LISTAR POR codigo
	public Articulo articuloById(@PathVariable(name = "codigo") int codigo) {
		/*Articulo art_id = new Articulo();
		art_id = articuloServiceImpl.getArticuloById(codigo);
		System.out.println("Articulo By ID: " + art_id);
		return art_id;*/
		return articuloServiceImpl.getArticuloById(codigo);
	}

	@PutMapping("/articulos/{codigo}") // PARA ACTUALIZAR POR codigo
	public Articulo actualizarArticulo(@PathVariable(name = "codigo") int codigo, @RequestBody Articulo articulo) {
		Articulo articulo_seleccionado = new Articulo();
		Articulo articulo_actualizado = new Articulo();

		articulo_seleccionado = articuloServiceImpl.getArticuloById(codigo);
		
		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricante(articulo.getFabricante());
		
		articulo_actualizado=articuloServiceImpl.actualizarArticulo(articulo_seleccionado);
		
		System.out.println("El articulo actualizado es: "+articulo_actualizado);

		return articulo_actualizado;
	}
	
	@DeleteMapping("/articulos/{codigo}") // PARA BORRAR POR codigo
	public void deleteArticulo(@PathVariable(name="codigo") int codigo) {
		articuloServiceImpl.deleteArticulo(codigo);
	}

}
