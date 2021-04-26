package nl.hu.pafr.richrail.train.domain;

public class Cart implements RollingComponent {
    private String name;
    private Integer maxLoad;

    public Cart(String name, Integer maxLoad) {
        this.name = name;
        this.maxLoad = maxLoad;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getWeight() {
        return this.maxLoad;
    }
}
