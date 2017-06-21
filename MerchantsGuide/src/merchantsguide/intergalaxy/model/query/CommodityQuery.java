package merchantsguide.intergalaxy.model.query;

/**
 * Created by chhota-bhim on 20/6/17.
 */
public class CommodityQuery implements Query {
    private String commodity;
    private String galacticConversionNote;

    public CommodityQuery(String commodity, String galacticConversionNote) {
        this.commodity = commodity;
        this.galacticConversionNote = galacticConversionNote;
    }

    public String getCommodity() {
        return commodity;
    }

    public String getGalacticConversionNote() {
        return galacticConversionNote;
    }

    @Override
    public Response execute(QueryProcessor processor) {
       return processor.process(this);
    }
}
