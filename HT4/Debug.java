import java.util.ArrayList;

public class Debug {
    public static void main(String[] args) {
        Conversor conversor= new Conversor();
         ArrayList<String> infix= conversor.validateExpression("2 + 1");
         String postfix= conversor.convertir(infix);
    }
}
