/*
 * Autores: Allen Estuardo Ramírez De Paz, 22326.
 * José Javier Flores Ordoñez, 22730
 * Catedrático: Moisés Alonso
 * Auxiliar: Joaquín Puente
 * 
 * 
 */
import java.util.ArrayList;

public interface ICalculadoraPostfix{
	ArrayList<String> validateExpression(String expression) throws Exception;
	
	int resolve(ArrayList<String> expression) throws Exception;
}