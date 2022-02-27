package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IFabricanteDAO;
import mainApp.dto.Fabricante;

@Service
public class FabricanteServiceImpl implements IFabricanteService {

	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL DAO. UN COPIAR Y PEGAR
	IFabricanteDAO iFabricanteDAO;

	// PONEMOS EN CONJUNTO LA CLASE CON EL DAO
	// IMPLEMENTAMOS IFabricantesDAO Y DESARROLLAMOS SUS METODOS

	// LISTAMOS TODOS LOS FABRICANTES
	public List<Fabricante> listaFabricante() {
		return iFabricanteDAO.findAll();
	}

	// AÑADIMOS UN FABRICANTE
	public Fabricante addFabricante(Fabricante fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	// LISTAMOS FABRICANTE POR codigo
	public Fabricante getFabricanteById(int codigo) {
		return iFabricanteDAO.findById(codigo).get();
	}

	// LISTAMOS FABRICANTES POR NOMBRE
	public List<Fabricante> listarFabricanteNombre(String nombre) {
		return iFabricanteDAO.findByNombre(nombre);
	}

	// ACTUALIZAMOS UN FABRICANTE
	public Fabricante actualizarFabricante(Fabricante fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	// BORRAMOS UN FABRICANTE
	public void deleteFabricante(int codigo) {
		iFabricanteDAO.deleteById(codigo);
	}
	
}
