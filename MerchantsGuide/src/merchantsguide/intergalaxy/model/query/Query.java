package merchantsguide.intergalaxy.model.query;


/**
 * Created by chhota-bhim on 20/6/17.
 */
public interface Query {
    Response execute(QueryProcessor processor);
}
