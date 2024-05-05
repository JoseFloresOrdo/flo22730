import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {

    public HuffmanNode buildTree(HashMap<Character, Integer> freq) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        
        for (char c : freq.keySet()) {
            pq.add(new HuffmanNode(freq.get(c), c));
        }
        
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            
            HuffmanNode parent = new HuffmanNode(left.data + right.data, '-');
            parent.left = left;
            parent.right = right;
            
            pq.add(parent);
        }
        
        return pq.poll();
    }

    public void generateCodes(HuffmanNode root, String code, HashMap<Character, String> codes) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            codes.put(root.c, code);
            return;
        }
        
        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }

    public String encodeString(String input, HashMap<Character, String> codes) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append(codes.get(c));
        }
        return encoded.toString();
    }

    public void writeCodesToFile(HashMap<Character, String> codes, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(codes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeEncodedStringToFile(String encoded, String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Convertir la cadena de bits a bytes
            byte[] bytes = convertBitStringToBytes(encoded);
            dos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para convertir la cadena de bits en bytes
    private byte[] convertBitStringToBytes(String bits) {
        int length = bits.length();
        byte[] bytes = new byte[(length + 7) / 8]; // redondear al próximo byte
        for (int i = 0; i < length; i++) {
            if (bits.charAt(i) == '1') {
                bytes[i / 8] |= 1 << (7 - i % 8);
            }
        }
        return bytes;
    }

    public String readFromFile(String fileName) {
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
}