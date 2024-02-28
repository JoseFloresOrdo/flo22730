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

       
}