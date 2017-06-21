package merchantsguide.intergalaxy;

import merchantsguide.intergalaxy.model.GalacticNumber;
import merchantsguide.intergalaxy.model.proposition.CommodityProposition;
import merchantsguide.intergalaxy.model.proposition.Proposition;
import merchantsguide.intergalaxy.model.proposition.PropositionProcessor;
import merchantsguide.intergalaxy.model.proposition.SimpleProposition;
import merchantsguide.intergalaxy.model.query.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MerchantsGuide implements PropositionProcessor, QueryProcessor {
    private Map<String, String> wordToSymbolDictionary = new HashMap<>();
    private Map<String, Integer> commodityToCreditsDictionary = new HashMap<>();

    public void addProposition(Proposition proposition) {
        proposition.accept(this);
    }


    public String query(Query query) {
        return query.execute(this).getResponseText();
    }

    @Override
    public void process(SimpleProposition proposition) {
        wordToSymbolDictionary.put(proposition.getWord(), proposition.getSymbol());
    }

    @Override
    public void process(CommodityProposition proposition) {
        String galacticSymbolicValue = Arrays.stream(proposition.getUnitNote().split(" ")).map(word -> wordToSymbolDictionary.get(word)).collect(Collectors.joining(""));
        commodityToCreditsDictionary.put(proposition.getCommodity(), proposition.getCredit() / new GalacticNumber(galacticSymbolicValue).getEarthNumber());
    }

    @Override
    public Response process(SimpleQuery query) {
        String galacticConversionNote = query.getGalacticConversionNote();
        String galacticSymbolicValue = Arrays.stream(galacticConversionNote.split(" ")).map(word -> wordToSymbolDictionary.get(word)).collect(Collectors.joining(""));
        return new Response(galacticConversionNote + " is " + new GalacticNumber(galacticSymbolicValue).getEarthNumber());
    }

    @Override
    public Response process(CommodityQuery query) {
        String galacticConversionNote = query.getGalacticConversionNote();
        String galacticSymbolicValue = Arrays.stream(galacticConversionNote.split(" ")).map(word -> wordToSymbolDictionary.get(word)).collect(Collectors.joining(""));
        return new Response(galacticConversionNote + " " + query.getCommodity() + " is " + (new GalacticNumber(galacticSymbolicValue).getEarthNumber() * commodityToCreditsDictionary.get(query.getCommodity())) + " Credits");
    }
}
