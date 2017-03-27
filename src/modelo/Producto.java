package modelo;

/**
 * @author enautirakasle 24 mar. 2017
 */

public class Producto {
	// TODO crear atributos getters setters y constructor
	int existencias;
	int id;
	String nombre;
	double precio;
	String proveedor;

	public Producto() {

	}

	public Producto(int existencias, int id, String nombre, double precio, String proveedor) {
		super();
		this.existencias = existencias;
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.proveedor = proveedor;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

}