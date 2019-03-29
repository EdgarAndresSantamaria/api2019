package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class Categoria {
	
	private String nombre;
	private ArrayList<Item> productos;
	
	/**
	 * TODO
	 * @param nombre
	 * @param productos
	 */
	public Categoria(String nombre,ArrayList<Item> productos ) {
		this.nombre=nombre;
		this.productos=productos;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verCategoria() {
		JSONObject categoria = new JSONObject();
		categoria.put("nombre", nombre);
		JSONArray arr = new JSONArray();
		for(Item i:productos) {
			JSONObject item = i.verItem();
			arr.put(item);
		}
		// eliminar ultima coma TODO
		categoria.put("items", arr);
		return categoria;
	}
	
	/**
	 * TODO
	 * @param nombre
	 * @return
	 */
	public Item searchItem(String nombre) {
		Boolean enc=false;
		Iterator<Item> it = productos.iterator();
		Item result= null;
		while(it.hasNext() && !enc) {
			Item next = it.next();
			if(next.is(nombre)) {
				enc=true;
				result=next;
			}
		}
		return result;	
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
