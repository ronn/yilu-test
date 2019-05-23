import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class YiluService {

    public static Optional<String> getFirstNonRepeatedChar(String str){
        return str.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .findFirst();
    }

    public static Boolean isRotation(String a, String b){
        List<String> secWord = getListFrom(b);
        Collections.reverse(secWord);

        return getListFrom(a).equals(secWord);
    }

    private static List<String> getListFrom(String str) {
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}