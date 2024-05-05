import java.util.PriorityQueue;
import java.util.HashMap;

public class HuffmanNode implements Comparable<HuffmanNode> {
    int data;
    char c;
    HuffmanNode left, right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
    }

    public int compareTo(HuffmanNode node) {
        return this.data - node.data;
    }
}