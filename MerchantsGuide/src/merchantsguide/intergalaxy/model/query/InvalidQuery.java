package merchantsguide.intergalaxy.model.query;

/**
 * Created by chhota-bhim on 20/6/17.
 */
public class InvalidQuery implements Query {
    private static final String templateText = "I have no idea what you are talking about";
    private final String queryText;

    public InvalidQuery(String queryText) {
        this.queryText = queryText;
    }

    @Override
    public Response execute(QueryProcessor processor) {
        return new Response(templateText);
    }
}
