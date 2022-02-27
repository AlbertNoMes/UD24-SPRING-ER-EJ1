package mainApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulos") // NOMBRE DE LA TABLA EN LA BD
public class Articulo {

	// ATRIBUTOS DE CLASE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private int precio;

	@ManyToOne
	@JoinColumn(name = "fabricante") // NOMBRE DE LA CLAVE FORANEA
	private Fabricante fabricante; // TRAEMOS UN OBJETO fabricante

	// CONSTRUCTOR POR DEFECTO
	public Articulo() {
		super();
	}

	// CONSTRUCTOR CON TODO
	public Articulo(int codigo, String nombre, int precio, Fabricante fabricante) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.fabricante = fabricante;
	}

	// GETTERS & SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	// METODO TOSTRING
	// PARA MOSTRAR LOS DATOS Y NO LA UBICACION
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante
				+ "]";
	}

}
