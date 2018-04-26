package ayds.dictionary.foxtrot.model.parsers;

import ayds.dictionary.foxtrot.view.OutputParser;

public interface Parsers {
    public InputParser getInputParser();
    public OutputParser getOutputParser();
}
