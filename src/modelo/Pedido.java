package modelo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Pedido {
	private int id;
	private ArrayList<Item> productos;
	private ArrayList<Oferta> ofertas;
	private String nombre_bar;
	
	/**
	 * TODO
	 * @param productos
	 * @param ofertas
	 * @param nombre_bar
	 */
	public Pedido(ArrayList<Item> productos,ArrayList<Oferta> ofertas,String nombre_bar) {
		this.id=Picotea.getInstance().generateId();
		this.nombre_bar=nombre_bar;
		this.ofertas=ofertas;
		this.productos=productos;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verPedido() {
		JSONObject pedido = new JSONObject();
		pedido.put("nombre", nombre_bar);
		pedido.put("id", id);
		
		JSONArray arrayProductos = new JSONArray();
		for(Item i:productos) {
			arrayProductos.put(i.verItem());
		}
		
		JSONArray arrayOfertas = new JSONArray();
		for(Oferta o:ofertas) {
			arrayOfertas.put(o.verOferta());
		}
	
		pedido.put("productos", arrayProductos);
		pedido.put("ofertas", arrayOfertas);
		return pedido;
	}
	

}
