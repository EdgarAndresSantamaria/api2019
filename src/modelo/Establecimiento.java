package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import ventanasAPI.Bar;
import ventanasAPI.Bares;

public class Establecimiento {
	
	private String nombre_Bar;
	private String descripcion;
	private String mail;
	private String tipo;
	private String barrio;
	private ArrayList<Categoria> carta;
	private ArrayList<Oferta> ofertas;
	
	/**
	 * TODO
	 * @param nombre_Bar
	 * @param descripcion
	 * @param mail
	 * @param tipo
	 * @param barrio
	 * @param carta
	 * @param ofertas
	 */
	public Establecimiento(String nombre_Bar,String descripcion,String mail,String tipo,String barrio, ArrayList<Categoria> carta,ArrayList<Oferta> ofertas) {
		this.nombre_Bar = nombre_Bar;
		this.descripcion = descripcion;
		this.mail= mail;
		this.tipo = tipo;
		this.barrio = barrio;
		this.carta = carta;
		this.ofertas = ofertas;
		
	}
	
	/**
	 * TODO
	 */
	public void mostrarCarta() {
		System.out.println(verCarta().toString(4));
		 
		
		/**
		 * TODO integrate GUI carta
		 */
	}

	
	/**
	 * TODO
	 * @param nombre
	 * @return
	 */
	public Boolean is (String nombre) {
		return nombre_Bar.equals(nombre);
	}
	
	/**
	 * TODO
	 * @return
	 */
 	public Boolean match(String categoria,String barrio) {
		return tipo.equals(categoria) && this.barrio.equals(barrio);
	}
	
	/**
	 * TODO
	 * @return
	 */
	public String getNombre() {
		return nombre_Bar;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verEstablecimiento() {
		JSONObject establecimiento = new JSONObject();
		establecimiento.put("nombre", nombre_Bar);
		establecimiento.put("descripion", descripcion);
		establecimiento.put("mail", mail);
		establecimiento.put("tipo", tipo);
		establecimiento.put("barrio", barrio);
		
		JSONArray arrayOfer = new JSONArray();
		for(Oferta o : ofertas) {
			arrayOfer.put(o.verOferta());
		}
		
		establecimiento.put("ofertas", arrayOfer);
		return establecimiento;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verCarta() {
		// inicializar vista de la carta y pasarle el String JSON lista de categoria para que lo muestre 
		JSONArray arrayCat = new JSONArray();
		for(Categoria c : carta) {
			arrayCat.put(c.verCategoria());
		}
				
		JSONObject carta = new JSONObject();
		carta.put("carta", arrayCat);
		return carta;
	}
	
	/**
	 * TODO
	 */
	public void mostrarEstablecimiento() {
		new Bar(this);
	}
	
	/**
	 * TODO
	 * @param nombreCat
	 * @param nombreItem
	 */
	public void anadirCarritoItem(String nombreCat,String nombreItem) {
		Boolean enc=false;
		Iterator<Categoria> it = carta.iterator();
		Categoria catTofind= null;
		while(it.hasNext() && !enc) {
			Categoria next = it.next();
			if(next.is(nombreCat)) {
				enc=true;
				catTofind=next;
			}
		}
		// add an item to product selection
		Resumen.getInstance().anadirProducto(catTofind.searchItem(nombreItem));
	}
	
	/**
	 * TODO
	 * @param nombreCat
	 * @param nombreItem
	 */
	public void anadirCarritoOferta(String nombreOferta) {
		Boolean enc=false;
		Iterator<Oferta> it = ofertas.iterator();
		Oferta theOffer= null;
		while(it.hasNext() && !enc) {
			Oferta next = it.next();
			if(next.is(nombreOferta)) {
				enc=true;
				theOffer=next;
			}
		}
		// add an item to product selection
		Resumen.getInstance().anadirOferta(theOffer);
	}
				
}
