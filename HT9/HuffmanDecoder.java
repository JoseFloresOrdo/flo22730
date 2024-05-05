import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class HuffmanNode implements Serializable {
    int data;
    char c;
    HuffmanNode left, right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
    }
}

public class HuffmanDecoder {
    public static HuffmanNode readTreeFromFile(String fileName) {
        HuffmanNode root = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            root = (HuffmanNode) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return root;
    }

    public static String decodeMessage(String encoded, HuffmanNode root) {
        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;
        for (int i = 0; i < encoded.length(); i++) {
            if (encoded.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decoded.append(current.c);
                current = root;
            }
        }
        return decoded.toString();
    }

    public static String readEncodedMessage(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String treeFileName = "Code.tree"; // Nombre del archivo del árbol
        HuffmanNode root = readTreeFromFile(treeFileName);

        String encodedFileName = "encod.huff"; // Nombre del archivo codificado
        String encodedMessage = readEncodedMessage(encodedFileName);

        String decodedMessage = decodeMessage(encodedMessage, root);

        // Imprimir el mensaje decodificado
        System.out.println("Mensaje decodificado:");
        System.out.println(decodedMessage);
    }
}
