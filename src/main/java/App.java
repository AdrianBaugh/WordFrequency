public class App {
    public static void main(String[] args) {

        String filepath = "src/main/resources/An Occurrence at Owl Creek Bridge.txt";
        WordFrequencies wordFrequencies = new WordFrequencies(filepath);

        wordFrequencies.countWords();

        wordFrequencies.printWordStats();

    }
}
