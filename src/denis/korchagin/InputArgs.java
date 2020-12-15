package denis.korchagin;

public class InputArgs {
    private String inputFile;
    private String outputFile;

    public InputArgs (String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public String getInputFile() {
        return this.inputFile;
    }

    public String getOutputFile() {
        return this.outputFile;
    }
}
