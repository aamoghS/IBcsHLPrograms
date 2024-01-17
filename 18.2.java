import java.util.Arrays;

public class HashTable2 {
    private int size;
    private int[] table;
    private int collisions;
    private int comparisons;

    public HashTable2(int size) {
        this.size = size;
        this.table = new int[size];
        this.collisions = 0;
        this.comparisons = 0;
        Arrays.fill(this.table, 0);
    }

    private int hashFunction(int key) {
        return key % this.size;
    }

    public void insertLinearProbe(int key) {
        int index = hashFunction(key);
        while (this.table[index] != 0) {
            this.collisions++;
            this.comparisons++;
            index = (index + 1) % this.size;
        }
        this.table[index] = key;
        this.comparisons++; 
    }

    public void display() {
        System.out.println("Index\tContents");
        for (int i = 0; i < this.size; i++) {
            System.out.println(i + "\t" + this.table[i]);
        }
        System.out.println("Total Collisions: " + this.collisions);
        System.out.println("Total Comparisons: " + this.comparisons);
    }

    public static void main(String[] args) {
        int numItems = Integer.parseInt(System.console().readLine("Enter the number of items: "));
        float[] loadFactors = {0.33f, 0.5f, 0.75f, 1.0f};

        for (float loadFactor : loadFactors) {
            int tableSize = (int) (numItems / loadFactor);
            HashTable2 hashTable = new HashTable2(tableSize);

            for (int i = 0; i < numItems; i++) {
                int key = generateKey();
                hashTable.insertLinearProbe(key);
            }

            System.out.println("\nResults for Load Factor: " + loadFactor);
            hashTable.display();
        }
    }

    private static int generateKey() {
        return (int) (Math.random() * 100) + 1;
    }
}
