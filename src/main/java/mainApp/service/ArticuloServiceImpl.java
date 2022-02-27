package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IArticuloDAO;
import mainApp.dto.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService {

	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL DAO. UN COPIAR Y PEGAR
	IArticuloDAO iArticuloDAO;

	// PONEMOS EN CONJUNTO LA CLASE CON EL DAO
	// IMPLEMENTAMOS IArticulosService Y DESARROLLAMOS SUS METODOS

	// LISTAMOS TODOS LOS ARTICULOS
	public List<Articulo> listaArticulos() {
		return iArticuloDAO.findAll();
	}

	// AÑADIMOS UN ARTICULO
	public Articulo addArticulo(Articulo articulo) {
		return iArticuloDAO.save(articulo);
	}

	// LISTAMOS ARTICULOS POR codigo
	public Articulo getArticuloById(int codigo) {
		return iArticuloDAO.findById(codigo).get();
	}

	// LISTAMOS ARTICULOS POR nombre
	public List<Articulo> listarArticuloNombre(String nombre) {
		return iArticuloDAO.findByNombre(nombre);
	}

	// ACTUALIZAMOS UN ARTICULO
	public Articulo actualizarArticulo(Articulo articulo) {
		return iArticuloDAO.save(articulo);
	}

	// BORRAMOS UN ARTICULO
	public void deleteArticulo(int codigo) {
		iArticuloDAO.deleteById(codigo);
	}

}
