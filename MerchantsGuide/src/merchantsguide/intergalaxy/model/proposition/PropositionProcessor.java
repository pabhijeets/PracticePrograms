package merchantsguide.intergalaxy.model.proposition;

public interface PropositionProcessor {
    void process(SimpleProposition proposition);
    void process(CommodityProposition proposition);
}
