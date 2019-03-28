package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.*;
import org.apache.commons.io.FileUtils;

public class Picotea {
	
	private static Picotea instance = null;
	private String decripcion;
	private ArrayList<Establecimiento> bares;
	private ArrayList<Pedido> pedidos;
	private int id = 0;
	
	/**
	 * TODO
	 */
	private Picotea() {
		bares = cargarEstablecimientos();
		decripcion = "Picotea es una App para reservar productos en tus establecimientos de siempre !";
	}
	
	public void generateJSON4Integrate() {
		/**
		for(Establecimiento e: bares) {
			e.mostrarCarta();
			e.mostrarEstablecimiento();
		}
		*/
		Resumen.getInstance().setBar("Deusto_Bar");
		bares.get(1).anadirCarritoItem("café & té", "café");
		bares.get(1).anadirCarritoItem("café & té", "té rojo");
		bares.get(1).anadirCarritoOferta("3x2 marianito");
		Resumen.getInstance().mostrarResumen();
	}
	
	/**
	 * TODO
	 * @return
	 */
	public static Picotea getInstance() {
		if (instance == null) {
			instance = new Picotea();
		}
		return instance;
	}

	
	/**
	 * TODO
	 * @param pedido
	 */
	public void registrarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	/**
	 * TODO
	 * @return
	 */
	public int generateId() {
		int result=id;
		id++;
		return result;
	}
	
	/**
	 * TODO
	 * @return
	 */
	private ArrayList<Establecimiento> cargarEstablecimientos(){
		String resourceName = "./resources/establecimientos.JSON";
		File file = new File(resourceName);
		String content=null;
		try {
			content = FileUtils.readFileToString(file, "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject obj = new JSONObject(content);
		// lista de establecimientos temporal
		ArrayList<Establecimiento> establecimientosTmp = new ArrayList<Establecimiento> ();
		JSONArray arr = obj.getJSONArray("establecimientos");
		for (int i = 0; i < arr.length(); i++)
		{
			// recuperar valores generales
		    String nombre_Bar = arr.getJSONObject(i).getString("nombre");
		    String descripcion = arr.getJSONObject(i).getString("descripcion");
		    String mail = arr.getJSONObject(i).getString("e-mail");
		    String tipo = arr.getJSONObject(i).getString("tipo");
		    String barrio = arr.getJSONObject(i).getString("barrio");
			// estructura de categorias
		    ArrayList<Categoria> categoriasTmp = new ArrayList<Categoria> ();
		    // recuperar carta
		    JSONArray carta = arr.getJSONObject(i).getJSONArray("carta");
			for (int j = 0; j < carta.length(); j++)
			{
				// estructura de productos
				ArrayList<Item> productosTmp = new ArrayList<Item>();
				// recuperar valores de categoria
				String nombreCat= carta.getJSONObject(j).getString("categoria");
				// recuperar productos
				JSONArray productos = carta.getJSONObject(j).getJSONArray("productos");
				for (int z = 0; z < productos.length(); z++)
				{
					String nombre = productos.getJSONObject(z).getString("nombre");
					Float precio = productos.getJSONObject(z).getFloat("precio");
					Item itemTmp = new Item(nombre,precio);
					// añadir nuevo item cargado
					productosTmp.add(itemTmp);
				}
				Categoria catTmp = new Categoria(nombreCat,productosTmp);
				// añadir nueva categoria cargada
				categoriasTmp.add(catTmp);
			}
			// estructura de oferta
		    ArrayList<Oferta> ofertasTmp = new ArrayList<Oferta> ();
			// recuperar ofertas
		    JSONArray ofertas = arr.getJSONObject(i).getJSONArray("ofertas");
			for (int x = 0; x < ofertas.length(); x++)
			{
				// estructura de productos
				ArrayList<Item> productosTmp = new ArrayList<Item>();
				// recuperar valores de categoria
				String nombreOferta= ofertas.getJSONObject(x).getString("categoria");
				Float precioOferta= ofertas.getJSONObject(x).getFloat("precio");
				// recuperar productos
				JSONArray productos = ofertas.getJSONObject(x).getJSONArray("productos");
				for (int y = 0; y < productos.length(); y++)
				{
					String nombre = productos.getJSONObject(y).getString("nombre");
					Float precio = productos.getJSONObject(y).getFloat("precio");
					Item itemTmp = new Item(nombre,precio);
					// añadir nuevo item cargado
					productosTmp.add(itemTmp);
				}
				Oferta ofertaTmp = new Oferta(nombreOferta,productosTmp, precioOferta);
				// añadir nueva categoria cargada
				ofertasTmp.add(ofertaTmp);
			}
			// objeto establecimiento tmp
			Establecimiento barTmp = new Establecimiento(nombre_Bar, descripcion, mail, tipo, barrio, categoriasTmp,ofertasTmp);
			establecimientosTmp.add(barTmp);
		   
		}
		return establecimientosTmp;
    }
	
	
	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[]args) {
		Picotea.getInstance().generateJSON4Integrate();
		
	}
}
