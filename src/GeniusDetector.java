public class GeniusDetector extends PatternDetector{
    private int idx = -1;
    @Override
    public int detect(String buffer) {
        // Find exact pattern in analyzer.buffer
        this.idx = buffer.indexOf("GAGA");
        return this.idx;
    }

    @Override
    public String labelString() {
        return "Genius is";
    }

    @Override
    public String additionalInfo() {
        return "GAGA is detected at pos " + this.idx;
    }
}
