package ayds.dictionary.foxtrot.controller.parsers;

public class ParsersImpl implements Parsers {
    private InputParser inputParser;
    private OutputParser outputParser;

    public ParsersImpl(InputParser inputParser,OutputParser outputParser){
        this.inputParser=inputParser;
        this.outputParser=outputParser;
    }

    @Override
    public InputParser getInputParser() {
        return inputParser;
    }

    @Override
    public OutputParser getOutputParser() {
        return outputParser;
    }
}
