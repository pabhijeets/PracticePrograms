package merchantsguide.intergalaxy.model.proposition;

public class SimpleProposition implements Proposition{

    private String word;
    private String symbol;

    public SimpleProposition(String word, String symbol) {
        this.word = word;
        this.symbol = symbol;
    }

    public String getWord() {
        return word;
    }

    public String getSymbol() {
        return symbol;
    }

    public void accept(PropositionProcessor processor) {
        processor.process(this);
    }

}
