package merchantsguide.intergalaxy.model;

import merchantsguide.intergalaxy.exception.InvalidGalacticNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GalacticNumberTest {

    @Test
    public void testMMVI(){
        String galacticValue="MMVI";
        int expected = 2006;
        int earthNumber = new GalacticNumber(galacticValue).getEarthNumber();
        assertEquals(expected,earthNumber);
    }

    @Test
    public void testMCMXLIV(){
        String galacticValue="MCMXLIV";
        int expected = 1944;
        int earthNumber = new GalacticNumber(galacticValue).getEarthNumber();
        assertEquals(expected,earthNumber);
    }

    @Test
    public void testMCMIII(){
        String galacticValue="MCMIII";
        int expected = 1903;
        int earthNumber = new GalacticNumber(galacticValue).getEarthNumber();
        assertEquals(expected,earthNumber);
    }

    @Test(expected = InvalidGalacticNumberException.class)
    public void testMCMIIII(){
        String galacticValue="MCMIIII";
        new GalacticNumber(galacticValue).getEarthNumber();
    }


}
