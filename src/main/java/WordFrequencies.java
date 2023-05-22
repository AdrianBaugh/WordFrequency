import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordFrequencies {
    //test file in resources directory
    private String filepath;
    private Map<String, Integer> wordCountMap = new HashMap<>();;

    public WordFrequencies(String filepath){
        this.filepath = filepath;
    }

//maybe change to where this count words method takes in the file instead of the constructor
    public Map<String, Integer> countWords(){
        List<String> words = readWords();
        //count the words
        for (String w : words) {
            wordCountMap.put(w, wordCountMap.getOrDefault(w,0) + 1);
        }
         return wordCountMap;
    }

    public void printWordStats() {

        topTenWords(wordCountMap);

        int total = 0;
        for (String w : wordCountMap.keySet()) {
            int count = wordCountMap.get(w);

            total += count;
        }
        System.out.println("total word count: " + total + " different words = " + wordCountMap.keySet().size());
    }
        public  void  topTenWords(Map<String, Integer> map) {

            // Create a list of map 'entry pairs'
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

            // Sort the list based on the integer values in descending order
//            entryList.sort(Map.Entry.comparingByValue());
//            Collections.sort(entryList, Collections.reverseOrder());
            Collections.sort(entryList, new countComparator());

            // Get the top 10 entries (or less if the map has fewer than 10 entries)
            // 11 because you have to ignore ""
            //could do size minus 11 and size minus 1 and not use the comparator above this will effectively get the last 11 values then you could reverse order and then print them the same below
            List<Map.Entry<String, Integer>> top10 = entryList.subList(0, 11);

            // Print the top 10 entries
            System.out.println("Top 10 most common words: ");
            for (Map.Entry<String, Integer> entry : top10) {
                if (entry.getKey().equals("")){
                    continue;
                }
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        //reader
        public List<String> readWords() {

            try {
                Path file = Paths.get(this.filepath);

                List<String> lines = Files.readAllLines(file);
                List<String> words = new ArrayList<>();

                //break the line down and add all the words to the list of words without punctuation
                for (String line : lines) {
                    line = line.toLowerCase();
                    String lineWithNoPunctuation = line.replaceAll("[^\\w\\s]|", "");

                    words.addAll(Arrays.asList(lineWithNoPunctuation.split("\\s+")));
                }
                return words;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return Collections.emptyList();
        }
}
