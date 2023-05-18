
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class wordFrequencies {
    String filepath = "/Users/abaugh/workspace/2Unit/WordFrequency/src/main/resources/An Occurrence at Owl Creek Bridge.txt";


    public void countWords(String filepath){

        try {
            Path file = Paths.get(filepath);
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            List<String> lines = Files.readAllLines(file);
            List<String> words = new ArrayList<>();

            for (String line : lines) {
//                w = w.toLowerCase();
                String[] currLineWords = line.split(" ");
                words.addAll(Arrays.asList(currLineWords));
            }
            for (String w : words) {

                if (!map.containsKey(w)) {
                    map.put(w, 1);
                } else {
                    map.put(w, map.get(w) + 1);
                }
            }
            int total = 0;
            for (String w : map.keySet()) {
                int count = map.get(w);
//                //need a better way of finding top 10 other than guessing 75
//                if (count > 75 && !w.equals("")) {
//                    System.out.println(w + " : "  + count);
//                }
                total += count;
            }
            //print top 10 and other attributes
            topTenWords(map);
            System.out.println("total word count: " + total + " different words = " + map.keySet().size());

        } catch (IOException e){
            e.printStackTrace();
        }
    }


        public  void  topTenWords(Map<String, Integer> map) {

            // Create a list of map entries
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

            // Sort the list based on the integer values in descending order
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry1.getValue());
                }
            });

            // Get the top 10 entries (or less if the map has fewer than 10 entries)
            // 11 because you have to ignore ""
            List<Map.Entry<String, Integer>> top10 = entryList.subList(0, Math.min(entryList.size(), 11));

            // Print the top 10 entries
            System.out.println("Top 10 words with the highest word count:");
            for (Map.Entry<String, Integer> entry : top10) {
                if (entry.getKey().equals("")){
                    continue;
                }
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    @Test
    public void tester(){
        String filename = this.filepath;
        double start = System.currentTimeMillis();
        countWords(filename);

        double end = System.currentTimeMillis();
        double time = (end-start)/1000;
        System.out.println("Time to count = "+time+"s");
//        start = System.currentTimeMillis();
//        end = System.currentTimeMillis();
//        time = (end-start)/1000;
//        System.out.println("time = "+time);
    }

}
