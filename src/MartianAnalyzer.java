public class MartianAnalyzer {


    public static void main(String[] args) {
        GenomeSeriesAnalyzer gsa = new GenomeSeriesAnalyzer("test.txt");
        gsa.addDetector(new GeniusDetector());
        gsa.addDetector(new RepeaterDetector('G',5));
        gsa.addDetector(new GastroDiseaseDetector());

        gsa.run();
    }

}
