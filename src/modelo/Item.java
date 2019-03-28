package modelo;

import org.json.JSONObject;

public class Item {
	
	private String nombre;
	private Float precio;
	
	/**
	 * TODO
	 * @param nombre
	 * @param Precio
	 */
	public Item (String nombre,Float precio) {
		this.nombre=nombre;
		this.precio=precio;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verItem() {
		JSONObject item = new JSONObject();
		item.put("name", nombre);
		item.put("precio", precio);
		return item;
	}
	
	/**
	 * TODO
	 * @param nombre
	 * @return
	 */
	public Boolean is (String nombre) {
		return this.nombre.equals(nombre);
	}

}
