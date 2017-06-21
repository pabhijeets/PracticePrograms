package merchantsguide.intergalaxy.model.proposition;

public class CommodityProposition implements Proposition {
    private String commodity;
    private String unitNote;
    private int credit;

    public CommodityProposition(String commodity,String unitNote, int credit) {
        this.commodity = commodity;
        this.unitNote = unitNote;
        this.credit = credit;
    }

    public String getCommodity() {
        return commodity;
    }

    public String getUnitNote() {
        return unitNote;
    }

    public int getCredit() {
        return credit;
    }

    public void accept(PropositionProcessor processor) {
        processor.process(this);
    }
}
