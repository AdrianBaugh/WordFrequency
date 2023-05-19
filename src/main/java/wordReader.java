//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.*;
//
//public class wordReader {
//
//
//    public static List<String> readWords(String filepath) {
//
//        try {
//            Path file = Paths.get(filepath);
//
//            List<String> lines = Files.readAllLines(file);
//            List<String> words = new ArrayList<>();
//
//            //break the line down and add all the words to the list of words without punctuation
//            for (String line : lines) {
//                line = line.toLowerCase();
//                String lineWithNoPunctuation = line.replaceAll("[^\\w\\s]|", "");
//
//                words.addAll(Arrays.asList(lineWithNoPunctuation.split("\\s+")));
//            }
//            return words;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return Collections.emptyList();
//    }
//}

