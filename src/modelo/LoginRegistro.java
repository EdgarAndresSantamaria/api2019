package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginRegistro {
	private String usuario;
	private String password;
	private String telefono;
	private JSONObject bd;
	private static LoginRegistro instance = null;
	
	/**
	 * TODO
	 */
	private LoginRegistro() {
		// cargar fichero de usuarios
		String resourceName = "./resources/usuarios.JSON";
		File file = new File(resourceName);
		String content=null;
		try {
			content = FileUtils.readFileToString(file, "utf-8");
		} catch (IOException e) {
			// gestionar errores
			e.printStackTrace();
		}
		// establecer el objeto BD
        bd = new JSONObject(content);
	}
	
	/**
	 * TODO
	 * @return
	 */
	public static LoginRegistro getInstance() {
		//inicializar
		if (instance == null) {
			instance = new LoginRegistro();
		}
		return instance;
	}
	
	/**
	 * TODO
	 * @param usuario
	 * @return
	 */
	public Boolean existeUsuario(String usuario) {
		try {
			// comprobar si existe un usuario
			JSONArray datos = bd.getJSONArray(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}	
	}
	
	/**
	 * TODO
	 * @param usuario
	 * @param password
	 * @param telefono
	 */
	public void registrar(String usuario, String password, String telefono) {
		// escribir un nuevo usuario en la bd
		JSONArray datos =new JSONArray();
		datos.put(password);
		datos.put(telefono);
		bd.put(usuario, datos);
		try {
			// hacer persistente el registro
			FileWriter file = new FileWriter("./resources/usuarios.JSON");
			file.write(bd.toString(4));
			file.flush();
			file.close();

		} catch (IOException e) {
			//manejar errores
		}
	}
	
	/**
	 * TODO
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Boolean entrar(String usuario, String password) {
		try {
			// entrar en la app
			JSONArray datos = bd.getJSONArray(usuario);
			if(datos.getString(0).equals(password)) {
				this.usuario = usuario;
				this.password = password;
				telefono = datos.getString(1);
				return true;
			}else {
				return false;
			}	
		}catch(Exception e) {
			return false;
		}	
	}
	
	/**
	 * 
	 * @return
	 */
	public JSONObject verLogin() {
		JSONObject login = new JSONObject();
		login.put("usuario", usuario);
		login.put("password", password);
		login.put("telefono", telefono);
		return login;
	}
	
	/**
	 * 
	 */
	public void mostrarLoginRegistro() {
		System.out.println(verLogin().toString(4));
		
		
		/**
		 * TODO integration
		 */
	}
}
