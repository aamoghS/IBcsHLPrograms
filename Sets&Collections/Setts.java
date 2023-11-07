import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Setts {
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

        try (BufferedReader reader1 = new BufferedReader(new FileReader("set1.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("set2.txt"))) {
       String line;
       while ((line = reader1.readLine()) != null) {
           String[] set1Values = line.split(",");
           for (String value : set1Values) {
               set1.add(Integer.parseInt(value.trim()));
           }
       }
       while ((line = reader2.readLine()) != null) {
           String[] set2Values = line.split(",");
           for (String value : set2Values) {
               set2.add(Integer.parseInt(value.trim()));
           }
       }
   } catch (IOException e) {
       e.printStackTrace();
   }

       
        Set<Integer> unionResultAB = customUnion(set1, set2);
        System.out.println("A Union B: " + unionResultAB);
        Set<Integer> unionResultBA = customUnion(set2, set1);
        System.out.println("B Union A: " + unionResultBA);

     
        Set<Integer> intersectionResultAB = customIntersection(set1, set2);
        System.out.println("A intersection B: " + intersectionResultAB);
        Set<Integer> intersectionResultBA = customIntersection(set2, set1);
        System.out.println("B intersection A: " + intersectionResultBA);

        
        Set<Integer> differenceResultAB = customDifference(set1, set2);
        System.out.println("A Difference B: " + differenceResultAB);
        Set<Integer> differenceResultBA = customDifference(set2, set1);
        System.out.println("B Difference A: " + differenceResultBA);

        boolean isSubsetResultAB = customIsSubset(set1, set2);
        System.out.println("A subset B: " + isSubsetResultAB);
        boolean isSubsetResultBA = customIsSubset(set2, set1);
        System.out.println("B subset A: " + isSubsetResultBA);
    }
}
