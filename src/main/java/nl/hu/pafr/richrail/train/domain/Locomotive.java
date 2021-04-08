package nl.hu.pafr.richrail.train.domain;

public class Locomotive implements RollingComponent {
    private Integer weight;

    public Locomotive(Integer weight) {
        this.weight = weight;
    }

    @Override
    public Integer calculateWeight() {
        return this.weight;
    }
}
