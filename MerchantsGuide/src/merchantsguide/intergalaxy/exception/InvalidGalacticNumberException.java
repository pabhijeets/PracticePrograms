package merchantsguide.intergalaxy.exception;

public class InvalidGalacticNumberException extends RuntimeException {
    private static final String template="Invalid Galactic Number %s";
    public InvalidGalacticNumberException(String number){
        super(String.format(template,number));
    }
}
