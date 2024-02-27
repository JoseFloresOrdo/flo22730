import java.util.ArrayList;
import java.util.Arrays;

public class CalculadoraPostFix implements ICalculadoraPostfix{
    
    IStack<String> pilaInterna;

    public CalculadoraPostFix(IStack<String> pilaInterna){
        this.pilaInterna=pilaInterna;
    }

    
    /** 
     * @param expression
     * @return ArrayList<String>
     * 
     * Valida el valor de la expresión
     */
    @Override
    public ArrayList<String> validateExpression(String expression)  {
        ArrayList<String>  separado = new ArrayList<String>(Arrays.asList(expression.split(" ")));
        for (String exp: separado){
            if(exp.matches("-?\\d+(\\.\\d+)?")){
                continue;
            } else if (exp.matches("[\\+\\-\\*\\/\\%]")){
                continue;
            }
            else{
                throw  new IllegalArgumentException("Error: " + exp + " no es un número ni un símbolo.");
            }
        }
        return separado;
    }

    
    /** 
     * @param expression
     * @return int
     * @throws Exception
     * Realiza las operaciones
     */
    @Override
    public int resolve(ArrayList<String> expression) throws Exception {
    for (String exp : expression) {
        if (exp.matches("-?\\d+(\\.\\d+)?")) {
            pilaInterna.push(exp);
        } else if (exp.matches("[\\+]")) {
            int suma = Integer.parseInt(pilaInterna.pop()) + Integer.parseInt(pilaInterna.pop());
            pilaInterna.push(String.valueOf(suma));
        } else if (exp.matches("[\\-]")) {
            int segundoNumero = Integer.parseInt(pilaInterna.pop());
            int primeroNumero = Integer.parseInt(pilaInterna.pop());
            int menos = primeroNumero - segundoNumero;
            pilaInterna.push(String.valueOf(menos));
        } else if (exp.matches("[\\*]")) {
            int mult = Integer.parseInt(pilaInterna.pop()) * Integer.parseInt(pilaInterna.pop());
            pilaInterna.push(String.valueOf(mult));
        } else if (exp.matches("[\\/]")) {
            int segundoNumero = Integer.parseInt(pilaInterna.pop());
            int primeroNumero = Integer.parseInt(pilaInterna.pop());
            int division = primeroNumero / segundoNumero;
            pilaInterna.push(String.valueOf(division));
        } else if (exp.matches("[\\%]")) {
            int segundoNumero = Integer.parseInt(pilaInterna.pop());
            int primeroNumero = Integer.parseInt(pilaInterna.pop());
            int residuo = primeroNumero % segundoNumero;
            pilaInterna.push(String.valueOf(residuo));
        } else {
            throw new IllegalArgumentException("Error: " + exp + " no es un número ni un símbolo.");
        }
    }
    return Integer.parseInt(pilaInterna.pop());
}



}