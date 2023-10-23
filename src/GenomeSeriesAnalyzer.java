import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * GenomeSeriesAnalyzer provides basics for running multiple tests on genetic strings of DNA
 */
public class GenomeSeriesAnalyzer{

    protected ArrayList<PatternDetector> detectors = new ArrayList<PatternDetector>();
    private String buffer;
    public GenomeSeriesAnalyzer(String fileName){
        getInput(fileName);
    }
    /**
     * Reads given file into the data member buffer
     *
     * @param fileName name of file to parse
     */
    public void getInput(String fileName)  {
        try {
            Path filePath = Paths.get(fileName);
            byte[] allBytes = Files.readAllBytes(filePath);
            buffer = new String (allBytes);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void addDetector(PatternDetector detector) {
        detectors.add(detector);
    }
    public void run() {

        for (PatternDetector detector: detectors){
            int pos= detector.detect(buffer);
            if (pos!=-1){
                System.out.println(detector.labelString()+" detected at "+pos);
            } else {
                System.out.println(detector.labelString()+" not detected");
            }
            System.out.println(detector.additionalInfo());
        }
    }



    /**
     * test code for the methods
     * @param args
     */
    public static void main(String args[]){
        GenomeSeriesAnalyzer gSequencer= new GenomeSeriesAnalyzer("test.txt");
        //gSequencer.addDetector(new CATDetector());
        gSequencer.run();

    }

}
