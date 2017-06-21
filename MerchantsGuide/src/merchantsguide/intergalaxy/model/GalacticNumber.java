package merchantsguide.intergalaxy.model;

import merchantsguide.intergalaxy.exception.InvalidGalacticNumberException;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GalacticNumber {
    private String galacticNumber;
    private int earthNumber;
   /* "D", "L", and "V" can never be repeated.
      "I" can be subtracted from "V" and "X" only.
      "X" can be subtracted from "L" and "C" only.
      "C" can be subtracted from "D" and "M" only.*/

    private final String galacticNumberPattern = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public GalacticNumber(String galacticNumber) {
        Pattern isProposition = Pattern.compile(galacticNumberPattern);
        Matcher matcher = isProposition.matcher(galacticNumber);

        if (matcher.matches()) {
            this.galacticNumber = galacticNumber;
            Stack<GalacticLiteral> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < galacticNumber.length(); i++) {
                String charAtIndex = "" + galacticNumber.charAt(i);
                GalacticLiteral galacticLiteral = GalacticLiteral.valueOf(charAtIndex);
                if (stack.isEmpty()) {
                    stack.push(galacticLiteral);
                } else {
                    GalacticLiteral precedingValue = stack.peek();
                    if (precedingValue.compareTo(galacticLiteral) < 0) {
                        stack.pop();
                        result = result + (galacticLiteral.getValue() - precedingValue.getValue());
                    } else {
                        result = result + stack.pop().getValue();
                        stack.push(galacticLiteral);
                    }
                }
            }
            if (!stack.isEmpty()) {
                int value = stack.pop().getValue();
                result = result + value;
            }


            earthNumber = result;
        } else {
            throw new InvalidGalacticNumberException(galacticNumber);
        }


    }


    public String getGalacticNumber() {
        return galacticNumber;
    }

    public int getEarthNumber() {
        return earthNumber;
    }
}
