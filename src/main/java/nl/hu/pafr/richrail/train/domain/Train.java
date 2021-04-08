package nl.hu.pafr.richrail.train.domain;

import java.util.ArrayList;
import java.util.List;

public class Train implements RollingComponent {
    private String name;
    private List<RollingComponent> components = new ArrayList<>();

    public Train(String name) {
        this.name = name;
    }

    public Train(String name, List<RollingComponent> components) {
        this.name = name;
        this.components = components;
    }

    public void add(RollingComponent component) {
        this.components.add(component);
    }

    public void remove(int index) {
        this.components.remove(index);
    }

    public Integer calculateWeight() {
        int weight = 0;

        for (RollingComponent component : this.components) {
            weight = weight + component.calculateWeight();
        }

        return weight;
    }

    public String getName() {
        return this.name;
    }
}
