public abstract class PatternDetector {

    static final String genCodeLetters ="GTAC";
    public abstract int detect(String buffer);
    public abstract String labelString();
    public String additionalInfo()
    {
        return "";
    };
    private boolean validCode(String buffer){
        for (int i=0;i<buffer.length();i++){
            char c = buffer.charAt(i);
            if (genCodeLetters.indexOf(c)== -1)
                return false;
        }
        return true;
    }

    /**
     * Given any string, see if it is in buffer
     * @param buffer the string we're looking in
     * @param seq the string we're looking for
     * @return the index of seq, or -1 if not found
     */
    protected int findSimpleSequence(String buffer, String seq){
        return (buffer.indexOf(seq));

    }
}
