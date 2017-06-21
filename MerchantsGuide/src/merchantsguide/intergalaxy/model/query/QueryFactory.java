package merchantsguide.intergalaxy.model.query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chhota-bhim on 20/6/17.
 */
public class QueryFactory {
    private static String howMuchQueryPattern = "how much is ((\\w+\\s)+)\\?";
    private static String howManyCreditsQueryPattern = "how many Credits is ((\\w+\\s)+)\\?";

    public static Query getQuery(String query){
        Pattern howMuchQuery = Pattern.compile(howMuchQueryPattern);
        Matcher matcher = howMuchQuery.matcher(query);
        if (matcher.matches()) {
            String galacticConversionNote = matcher.group(1).trim();
            return new SimpleQuery(galacticConversionNote);
        }

        Pattern howManyCreditsQuery = Pattern.compile(howManyCreditsQueryPattern);
        matcher = howManyCreditsQuery.matcher(query);
        if (matcher.matches()) {
            String commodity = matcher.group(2).trim();
            String galacticConversionNote = matcher.group(1).replace(commodity,"").trim();
            return new CommodityQuery(commodity,galacticConversionNote);
        }
        return new InvalidQuery(query);
    }
}
