package mainApp.service;

import java.util.List;

import mainApp.dto.Articulo;

public interface IArticuloService {

	// METODOS DEL CRUD
	public List<Articulo> listaArticulos(); // LISTAR TODOS LOS ARTICULOS

	public Articulo addArticulo(Articulo articulo); // ADD NUEVO ARTICULO

	public Articulo getArticuloById(int codigo); // GET ARTICULO BY ID

	public List<Articulo> listarArticuloNombre(String nombre); // LISTA ARTICULO POR NOMBRE

	public Articulo actualizarArticulo(Articulo articulo); // ACTUALIZA DATOS DEL ARTICULO

	public void deleteArticulo(int codigo); // ELIMINA EL ARTICULO

}
