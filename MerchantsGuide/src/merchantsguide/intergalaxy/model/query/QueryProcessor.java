package merchantsguide.intergalaxy.model.query;

/**
 * Created by chhota-bhim on 20/6/17.
 */
public interface QueryProcessor {
    Response process(SimpleQuery query);
    Response process(CommodityQuery query);
}
