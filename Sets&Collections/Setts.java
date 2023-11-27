import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Test {
    public static <T> Set<T> customUnion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        for (T item : set2) {
            union.add(item);
        }
        return union;
    }

    public static <T> Set<T> customIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>();
        for (T item : set1) {
            if (set2.contains(item)) {
                intersection.add(item);
            }
        }
        return intersection;
    }

    public static <T> Set<T> customDifference(Set<T> set1, Set<T> set2) {
        Set<T> difference = new HashSet<>(set1);
        for (T item : set2) {
            difference.remove(item);
        }
        return difference;
    }

    public static <T> boolean customIsSubset(Set<T> set1, Set<T> set2) {
        for (T item : set1) {
            if (!set2.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        String set1Filename = "set1.txt";
        String set2Filename = "set2.txt";

        // Read data for set1 from file
        try {
            Scanner fileScanner1 = new Scanner(new File(set1Filename));
            String set1Input = fileScanner1.nextLine();
            String[] set1Values = set1Input.split(",");
            for (String value : set1Values) {
                set1.add(Integer.parseInt(value.trim()));
            }
            fileScanner1.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + set1Filename);
            System.exit(1);
        }

        // Read data for set2 from file
        try {
            Scanner fileScanner2 = new Scanner(new File(set2Filename));
            String set2Input = fileScanner2.nextLine();
            String[] set2Values = set2Input.split(",");
            for (String value : set2Values) {
                set2.add(Integer.parseInt(value.trim()));
            }
            fileScanner2.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + set2Filename);
            System.exit(1);
        }


        // Test custom union
        Set<Integer> unionResultAB = customUnion(set1, set2);
        System.out.println("A Union B: " + unionResultAB);
        Set<Integer> unionResultBA = customUnion(set2, set1);
        System.out.println("B Union A: " + unionResultBA);

        // Test custom intersection
        Set<Integer> intersectionResultAB = customIntersection(set1, set2);
        System.out.println("A intersection B: " + intersectionResultAB);
        Set<Integer> intersectionResultBA = customIntersection(set2, set1);
        System.out.println("B intersection A: " + intersectionResultBA);

        // Test custom difference
        Set<Integer> differenceResultAB = customDifference(set1, set2);
        System.out.println("A Difference B: " + differenceResultAB);
        Set<Integer> differenceResultBA = customDifference(set2, set1);
        System.out.println("B Difference A: " + differenceResultBA);

        // Test custom subset
        boolean isSubsetResultAB = customIsSubset(set1, set2);
        System.out.println("A subset B: " + isSubsetResultAB);
        boolean isSubsetResultBA = customIsSubset(set2, set1);
        System.out.println("B subset A: " + isSubsetResultBA);
    }
}

