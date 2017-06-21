package merchantsguide.intergalaxy.model.proposition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropositionFactoryTest {

    @Test
    public void testSimpleProposition(){

        Proposition proposition = PropositionFactory.getProposition("glob is I");
        assertTrue(proposition instanceof SimpleProposition);
        assertEquals("glob",((SimpleProposition) proposition).getWord());
        assertEquals("I",((SimpleProposition) proposition).getSymbol());
    }
    @Test
    public void testCommodityProposition(){

        Proposition proposition = PropositionFactory.getProposition("glob glob Silver is 34 Credits");
        assertTrue(proposition instanceof CommodityProposition);
        assertEquals("Silver",((CommodityProposition) proposition).getCommodity());
        assertEquals(34,((CommodityProposition) proposition).getCredit());
        assertEquals("glob glob",((CommodityProposition) proposition).getUnitNote());
    }

}
