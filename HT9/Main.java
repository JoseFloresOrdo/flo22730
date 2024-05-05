import java.util.HashMap;

public class Main {
    
    public static void main(String[] args){

        HuffmanTree Arbol = new HuffmanTree();
        String File = "Texto.txt";
        String test = Arbol.readFromFile(File);
        
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : test.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        HuffmanNode root = Arbol.buildTree(freq);
        HashMap<Character, String> Codes = new HashMap<>();
        Arbol.generateCodes(root, "", Codes);

        String encoded = Arbol.encodeString(test, Codes);
        Arbol.writeEncodedStringToFile(encoded, "encod.huff");
        Arbol.writeCodesToFile(Codes, "Code.tree");








    }

}
