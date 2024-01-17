import java.util.Arrays;

public class HashTable1 {
    private int size;
    private int[] table;
    private int collisions;

    public HashTable1(int size) {
        this.size = size;
        this.table = new int[size];
        this.collisions = 0;
        Arrays.fill(this.table, 0);
    }

    private int hashFunction(int key) {
        // Simple hash function, you may replace it with a more sophisticated one
        return key % this.size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        while (this.table[index] != 0) {
            this.collisions++;
            index = (index + 1) % this.size;
        }
        this.table[index] = key;
    }

    public void display() {
        System.out.println("Index\tContents");
        for (int i = 0; i < this.size; i++) {
            System.out.println(i + "\t" + this.table[i]);
        }
        System.out.println("Total Collisions: " + this.collisions);
    }

    public static void main(String[] args) {
        int numItems = Integer.parseInt(System.console().readLine("Enter the number of items: "));
        
        testLoadFactor(numItems, 0.33f);
        testLoadFactor(numItems, 0.5f);
        testLoadFactor(numItems, 0.75f);
        testLoadFactor(numItems, 1.0f);
    }

    private static void testLoadFactor(int numItems, float loadFactor) {
        int tableSize = (int) (numItems / loadFactor);
        HashTable1 hashTable = new HashTable1(tableSize);

        for (int i = 0; i < numItems; i++) {
            int key = generateKey();  // Replace with your key generation logic
            hashTable.insert(key);
        }

        System.out.println("Load Factor: " + loadFactor);
        hashTable.display();
        System.out.println();
    }

    private static int generateKey() {
        // Replace this with your key generation logic
        return (int) (Math.random() * 100) + 1;
    }
}
