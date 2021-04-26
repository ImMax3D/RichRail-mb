package nl.hu.pafr.richrail.train.domain;

public class Locomotive implements RollingComponent {
    private String name;
    private Integer weight;

    public Locomotive(String name, Integer weight) {
        this.name = name;
        this.weight = weight;

    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getWeight() {
        return this.weight;
    }
}
