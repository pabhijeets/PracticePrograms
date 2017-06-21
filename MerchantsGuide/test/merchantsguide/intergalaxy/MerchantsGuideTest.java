package merchantsguide.intergalaxy;

import merchantsguide.intergalaxy.model.proposition.PropositionFactory;
import merchantsguide.intergalaxy.model.query.QueryFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MerchantsGuideTest {

    private MerchantsGuide guide;

    @Before
    public void setup() {
        guide = new MerchantsGuide();
        guide.addProposition(PropositionFactory.getProposition("glob is I"));
        guide.addProposition(PropositionFactory.getProposition("prok is V"));
        guide.addProposition(PropositionFactory.getProposition("pish is X"));
        guide.addProposition(PropositionFactory.getProposition("tegj is L"));
        guide.addProposition(PropositionFactory.getProposition("glob glob Silver is 34 Credits"));
        guide.addProposition(PropositionFactory.getProposition("prok Gold is 57800 Credits"));
        guide.addProposition(PropositionFactory.getProposition("pish tegj glob Dirt is 5780 Credits"));
    }

    @Test
    public void testHowMuchQuery() {
        String expected = "pish tegj glob glob is 42";
        String actual = guide.query(QueryFactory.getQuery("how much is pish tegj glob glob ?"));
        assertEquals(expected,actual);
    }

    @Test
    public void testHowManyCreditsQuery() {
        String expected = "glob prok Silver is 68 Credits";
        String actual = guide.query(QueryFactory.getQuery("how many Credits is glob prok Silver ?"));
        assertEquals(expected,actual);
    }

    @Test
    public void testInvalidQuery() {
        String expected = "I have no idea what you are talking about";
        String actual = guide.query(QueryFactory.getQuery("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
        assertEquals(expected,actual);
    }

}
