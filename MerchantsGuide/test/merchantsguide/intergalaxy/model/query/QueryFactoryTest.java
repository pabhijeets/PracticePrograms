package merchantsguide.intergalaxy.model.query;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueryFactoryTest {
    @Test
    public void testSimpleQuery(){

        Query query = QueryFactory.getQuery("how much is pish tegj glob glob ?");
        assertTrue(query instanceof SimpleQuery);
        assertEquals("pish tegj glob glob",((SimpleQuery) query).getGalacticConversionNote());
    }
    @Test
    public void testCommodityQuery(){

        Query query = QueryFactory.getQuery("how many Credits is glob prok Silver ?");
        assertTrue(query instanceof CommodityQuery);
        assertEquals("glob prok",((CommodityQuery) query).getGalacticConversionNote());
        assertEquals("Silver",((CommodityQuery) query).getCommodity());

    }
    @Test
    public void testInvalidQuery(){

        Query query = QueryFactory.getQuery("I have no idea what you are talking about");
        assertTrue(query instanceof InvalidQuery);
    }
}
