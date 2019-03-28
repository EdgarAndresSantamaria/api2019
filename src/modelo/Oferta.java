package modelo;

import java.util.ArrayList;

import org.json.JSONObject;

public class Oferta extends Categoria {
	
	private Float precio;

	/**
	 * TODO
	 * @param nombre
	 * @param productos
	 * @param precio
	 */
	public Oferta(String nombre, ArrayList<Item> productos, Float precio) {
		super(nombre, productos);
		this.precio = precio;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verOferta() {
		JSONObject oferta = new JSONObject();
		oferta.put("informacion", super.mostrarCategoria());
		oferta.put("precio", precio);
		return oferta;
	}

}
