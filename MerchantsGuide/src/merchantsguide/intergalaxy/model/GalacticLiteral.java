package merchantsguide.intergalaxy.model;

public enum GalacticLiteral {
    I(1),V(5),X(10),L(50),C(100),D(500),M(1000);

    private final int value;

    GalacticLiteral(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
