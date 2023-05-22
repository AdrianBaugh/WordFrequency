import java.util.Comparator;
import java.util.Map;

public class countComparator implements Comparator<Map.Entry<String, Integer>>{

    //is in descending order  pair2 value compared to pair1 value
    @Override
    public int compare(Map.Entry<String, Integer> pair1, Map.Entry<String, Integer> pair2) {
        return pair2.getValue().compareTo(pair1.getValue());
    }
}
