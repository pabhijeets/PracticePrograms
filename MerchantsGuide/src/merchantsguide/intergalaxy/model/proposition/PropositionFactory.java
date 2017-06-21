package merchantsguide.intergalaxy.model.proposition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropositionFactory {
    private static String isPropositionPattern = "(\\w+)\\s+is\\s+(\\w)";
    private static String commodityPropositionPattern = "((\\w+\\s)+)+is\\s+(\\d+)\\s+Credits";

    public static Proposition getProposition(String proposition){
        Pattern isProposition = Pattern.compile(isPropositionPattern);
        Matcher matcher = isProposition.matcher(proposition);
        if (matcher.matches()) {
            String word = matcher.group(1);
            String symbol = matcher.group(2);
            return new SimpleProposition(word,symbol);
        }

        Pattern commodityProposition = Pattern.compile(commodityPropositionPattern);
        matcher = commodityProposition.matcher(proposition);
        if (matcher.matches()) {
            String commodityString = matcher.group(1).trim();
            String commodity = matcher.group(2).trim();
            int earthValue = Integer.parseInt(matcher.group(3).trim());
            String units = commodityString.replace(commodity,"").trim();
            return new CommodityProposition(commodity,units, earthValue);
        }
        return null;
    }
}
