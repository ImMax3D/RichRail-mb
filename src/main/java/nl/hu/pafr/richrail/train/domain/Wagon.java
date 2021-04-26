package nl.hu.pafr.richrail.train.domain;

public class Wagon implements RollingComponent {
    private String name;
    private final Integer capacity;

    public Wagon(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getWeight() {
        return this.capacity * 100;
    }
}
