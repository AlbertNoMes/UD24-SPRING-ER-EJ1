package mainApp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fabricantes") // NOMBRE DE LA TABLA EN LA BD
public class Fabricante {

	// ATRIBUTOS DE CLASE
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;

	@OneToMany
	@JoinColumn(name = "codigo") // NOMBRE DE LA CLAVE QUE SERA FORANEA EN LA OTRA ENTIDAD
	private List<Articulo> articulo;

	// CONSTRUCTOR POR DEFECTO
	public Fabricante() {
		super();
	}

	// CONSTRUCTOR CON TODO
	public Fabricante(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
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

	// METODO TO STRING
	// PARA MOSTRAR LOS DATOS Y NO LA UBICACION
	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
