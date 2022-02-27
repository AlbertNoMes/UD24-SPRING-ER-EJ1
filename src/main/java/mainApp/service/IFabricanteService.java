package mainApp.service;

import java.util.List;

import mainApp.dto.Fabricante;

public interface IFabricanteService {
	
	public List<Fabricante> listaFabricante(); //LISTAR TODOS LOS FABRICANTES
	
	public Fabricante addFabricante(Fabricante fabricante); // ADD NUEVO FABRICANTE

	public Fabricante getFabricanteById(int codigo); // GET FABRICANTE BY ID

	public List<Fabricante> listarFabricanteNombre(String nombre); // LISTA FABRICANTE POR NOMBRE

	public Fabricante actualizarFabricante(Fabricante fabricante); // ACTUALIZA DATOS DEL FABRICANTE

	public void deleteFabricante(int codigo); // ELIMINA EL FABRICANTE

}
