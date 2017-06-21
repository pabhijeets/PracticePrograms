package merchantsguide.intergalaxy.model.query;

/**
 * Created by chhota-bhim on 20/6/17.
 */
public class SimpleQuery implements Query {
    private final String galacticConversionNote;

    public SimpleQuery(String galacticConversionNote) {
        this.galacticConversionNote = galacticConversionNote;
    }

    public String getGalacticConversionNote() {
        return galacticConversionNote;
    }

    @Override
    public Response execute(QueryProcessor processor) {
       return processor.process(this);
    }
}
