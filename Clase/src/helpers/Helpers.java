package helpers;

import java.util.Map;

public class Helpers {
	
	/*
	 * map.put(); 
	 * map.size(); 
	 * map.get();
	 * map.isEmpty();
	 * map.remove();
	 * map.containsKey(); boolean
	 * map.containsValue(); boolean
	 * map.clear();
	 */

	public static String generaCheckbox(String nombre, Map<String, String> etiquetas, String seleccionado) {
		String res = "";
		for( String k: etiquetas.keySet() ) {
			String checked = (etiquetas.get(k) == seleccionado ? "checked=\"checked\"" : "");
			res += "<input type=\"checkbox\" name=\""+nombre+"[]\" value=\""+etiquetas.get(k)+"\" id=\"id-"+etiquetas.get(k)+"\" "+checked+" /><label for=\"id-"+etiquetas.get(k)+"\">"+etiquetas.get(k)+"</label><br />";
		}
		return res;
	}
	
	public static String generaRadio(String nombre, Map<String, String> array, String seleccionado) {
		String res = "";
		for( String k: array.keySet() ) {
			String checked = (array.get(k) == seleccionado ? "checked=\"checked\"" : "");
			res += "<input type=\"radio\" name=\""+nombre+"[]\" value=\""+array.get(k)+"\" id=\"id-"+array.get(k)+"\" "+checked+" /><label for=\"id-"+array.get(k)+"\">"+k+"</label><br />";
		}
		return res;
	}
	
	public static String generaSelect(String nombre, Map<String, String> array, String seleccionado) {
		//boolean flag = hashmap.containsValue("Singh");
		String res = "<select name=\""+nombre+"\">";
		for( String k: array.keySet() ) {
			String checked = (array.get(k) == seleccionado ? "selected=\"selected\"" : "");
			res += "<option value=\""+array.get(k)+"\"  "+checked+" />"+k+"</option>";
		}
		res += "</select>";
		return res;
	}
	
}
