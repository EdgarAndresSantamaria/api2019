package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

import org.json.*;

import ventanasAPI.Carta;
import ventanasAPI.PicoteaV;

import org.apache.commons.io.FileUtils;

public class Picotea {
	
	private static Picotea instance = null;
	private String decripcion;
	private ArrayList<Establecimiento> bares;
	private ArrayList<Pedido> pedidos;
	private int id;
	
	/**
	 * TODO
	 */
	private Picotea() {
		id=0;
		bares = cargarEstablecimientos();
		pedidos = new ArrayList<Pedido> ();
		decripcion = "Picotea es una App para reservar productos en tus establecimientos de siempre !";
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verPicotea() {
		if(LoginRegistro.getInstance().verLogin().isEmpty()) {
			// mostrar datos vista antes de registro/login
			JSONObject picotea = new JSONObject();
			picotea.put("descripcion", decripcion);
			picotea.put("userLoged", false);
			return picotea;
		}else {
			// mostrar datos una vez registro/login
			JSONObject picotea = new JSONObject();
			picotea.put("usuario", LoginRegistro.getInstance().verLogin().getString("usuario"));
			picotea.put("userLoged", true);
			return picotea;	
		}
	}
	
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verPedidos() {
		JSONArray arrayPedido = new JSONArray();
		for(Pedido p : pedidos) {
			arrayPedido.put(p.verPedido());
		}
		JSONObject pedidos = new JSONObject();
		pedidos.put("pedidos", arrayPedido);
		return pedidos;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public JSONObject verEstablecimientos(String categoria, String barrio) {
		JSONArray arrayEstablecimientos = new JSONArray();
		for(Establecimiento e : bares) {
			if(e.match(categoria,barrio)) {
				arrayEstablecimientos.put(e.getNombre());
			}
		}
		JSONObject establecimientos = new JSONObject();
		establecimientos.put("establecimientos", arrayEstablecimientos);
		return establecimientos;
	}
	
	/**
	 * TODO
	 */
	public void entrarEstablecimiento(String nombre_bar) {		
		Boolean enc=false;
		Iterator<Establecimiento> it = bares.iterator();
		Establecimiento result= null;
		while(it.hasNext() && !enc) {
			Establecimiento next = it.next();
			if(next.is(nombre_bar)) {
				enc=true;
				result=next;
			}
		}
		result.mostrarEstablecimiento();
	}


	/**
	 * TODO
	 */
	public void mostrarEstablecimientos(String categoria, String barrio) {		
		System.out.println(verEstablecimientos(categoria,barrio).toString(4));
		// TODO integrate GUI lista de busquedas
	}

	/**
	 * TODO
	 */
	public void mostrarPedidos() {		
		System.out.println(verPedidos().toString(4));
		// TODO integrate GUI pedidos
	}
	
	/**
	 * TODO
	 */
	public void mostrarPicotea() {		
		System.out.println(verPicotea().toString(4));
		// TODO integrate GUI Picotea
	}
	
	/**
	 * SandBox testing zone..
	 */
	public void simulador() {
		
		/**
		 * Prueba entrar en establecimiento (Ibarreko_Bar1)
		 */
		// Picotea.getInstance().entrarEstablecimiento("Ibarreko_Bar1");	
		/**
		 * Prueba busqueda (bar,Ibarrekolanda) + display
		 */
		//Picotea.getInstance().mostrarEstablecimientos("bar","Ibarrekolanda");		
		/**
		 * Prueba busqueda (bar,Deusto) + display
		 */
		//Picotea.getInstance().mostrarEstablecimientos("bar","Deusto");	
		/**
		 * Prueba busqueda (ermita,Ibarrekolanda) + display
		 */
		//Picotea.getInstance().mostrarEstablecimientos("ermita","Ibarrekolanda");	
		/**
		 * prueba registro y display de pedidos
		 */
		
		/**
		Resumen.getInstance().setBar("Deusto_Bar");
		bares.get(1).anadirCarritoItem("café & té", "café");
		bares.get(1).anadirCarritoItem("café & té", "té rojo");
		bares.get(1).anadirCarritoOferta("3x2 marianito");
		Resumen.getInstance().finalizarPedido();
		Resumen.getInstance().setBar("Ibarreko_Bar");
		bares.get(0).anadirCarritoItem("comida", "snacks");
		bares.get(0).anadirCarritoItem("bebida", "cerveza");
		bares.get(0).anadirCarritoOferta("3x2 en snacks");
		Resumen.getInstance().finalizarPedido();
		mostrarPedidos();
		*/
		
		/**
		 * Prueba login/registro
		 */
		/**
		LoginRegistro.getInstance().registrar("edgar", "a", "234-234-234");
		LoginRegistro.getInstance().registrar("admin", "admin", "234-234-234");
		System.out.println(LoginRegistro.getInstance().existeUsuario("edgar"));
		System.out.println(LoginRegistro.getInstance().existeUsuario("paco"));
		System.out.println(LoginRegistro.getInstance().entrar("edgar","j"));
		System.out.println(LoginRegistro.getInstance().verLogin().toString(4));
		System.out.println(LoginRegistro.getInstance().entrar("edgar","a"));
		 */
		
		/**
		 * mostrar carta
		 */
		//Carta tmp = new Carta(bares.get(0));
		// Carta tmp = new Carta(bares.get(1));
		//Carta tmp = new Carta(bares.get(2));
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
		File file = new File("establecimientos.JSON");
		String content=null;
		try {
			content = FileUtils.readFileToString(file, "utf-8");
		} catch (IOException e) {
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
	 */
	public void mostrarContatcto() {		
		goToURL("https://edgarandresblog.wordpress.com/2019/03/29/contacto/");
		// TODO integrate GUI Picotea
	}
	
	/**
	 * TODO
	 */
	public void mostrarTerminos() {		
		goToURL("https://edgarandresblog.wordpress.com/2019/03/29/picotea-politica-de-privacidad/");
		// TODO integrate GUI Picotea
	}
	 
	/**
	 * TODO
	 * @param URL   
	 */
	private void goToURL(String URL) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					Logger.getLogger(Picotea.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	/**
	 * TODO
	 * @param args
	 */
	public static void main(String[]args) {
		PicoteaV frame = new PicoteaV();
		frame.setVisible(true);
	}
}
