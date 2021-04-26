package nl.hu.pafr.richrail.train.domain;

import java.util.ArrayList;
import java.util.List;

public class Train implements RollingComponent {
    private String name;
    private List<RollingComponent> components = new ArrayList<>();

    public Train(String name) {
        this.name = name;
//        this.components.add(new Locomotive("TrekTrek", 100));
//        this.components.add(new Cart("DraagDraag", 50));
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


    public Integer getWeight() {
        int weight = 0;

        for (RollingComponent component : this.components) {
            weight = weight + component.getWeight();
        }

        return weight;
    }

    public String getName() {
        return this.name;
    }

    public List<RollingComponent> getComponents() {
        return components;
    }
}
