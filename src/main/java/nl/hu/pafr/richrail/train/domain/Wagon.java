package nl.hu.pafr.richrail.train.domain;

public class Wagon implements RollingComponent {
    private Integer capacity;

    @Override
    public Integer calculateWeight() {
        return this.capacity * 100;
    }
}
