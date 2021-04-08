package nl.hu.pafr.richrail.train.domain;

public class Cart implements RollingComponent {
    private Integer maxLoad;

    public Cart(Integer maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public Integer calculateWeight() {
        return this.maxLoad;
    }
}
