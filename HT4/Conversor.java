import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Conversor {

    public String conversor(ArrayList<String> infixTokens) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (String token : infixTokens) {
            
            if (operador(token)) {
                postfix.append(token).append(" ");
            }
            
            else if (token.equals("(")) {
                stack.push(token);
            }
           
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); 
            }

            else {
               
                while (!stack.isEmpty() && puesto(stack.peek()) >= puesto(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                
                stack.push(token);
            }
        }


        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

 
    private boolean operador(String token) {
        return token.matches("[0-9]+");
    }

 
    private int puesto(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

        public ArrayList<String> validateExpression(String expression)  {
        ArrayList<String>  separado = new ArrayList<String>(Arrays.asList(expression.split(" ")));
        for (String exp: separado){
            if(exp.matches("-?\\d+(\\.\\d+)?")){
                continue;
            } else if (exp.matches("[\\+\\-\\*\\/\\%]")){
                continue;
            }

            else if(exp.matches("[()]")){
                continue;
            }

            else{
                throw  new IllegalArgumentException("Error: " + exp + " no es un número ni un símbolo.");
            }
        }
        return separado;
    }
}