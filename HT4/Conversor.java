import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Conversor {
    Queue<String> lista;
    StackVector<String> stack;

    public Conversor(){
        this.lista= new LinkedList<String>();;
        this.stack= new StackVector<String>();
    }

    
    public int puesto(String ch){
        if(ch.matches("\\+") || ch.matches("\\-")){
            return 1;

        }
        else if(ch.matches("\\*") || ch.matches("/")){
            return 2;
        }
        else{
            return 0;
        }

    }

    public String convertir( ArrayList<String> separado){
        stack.push("#");
        String postfix="";
        for(String caracter: separado){
            if(caracter.matches("\\d")){
                lista.offer(caracter);
            }
            else if(caracter.matches( "\\(")){
                stack.push(caracter);
            }
            
            else if(caracter.matches("\\)")){
                while (!stack.isEmpty() && !stack.peek().matches("\\(")) {
                    postfix= postfix +" "+stack.pop();
                    
                }
                stack.pop();
            }

            else{
                if(puesto(caracter)> puesto(stack.peek())){
                    stack.push(caracter);
                }
                else{
                    while(stack.peek()!="#" && puesto(caracter) <= puesto(stack.peek())){
                        postfix+=stack.peek();
                        stack.pop();
                    }
        
                }
                stack.push(caracter);
            }
            
        }

        while(stack.peek()!="#"){
            postfix+=stack.peek();
            stack.pop();
        }
        return postfix;

    }

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
}
