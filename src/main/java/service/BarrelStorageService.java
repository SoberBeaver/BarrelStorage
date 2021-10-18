package service;

import entity.Barrel;

import java.util.HashMap;
import java.util.Set;

public class BarrelStorageService {
    private final HashMap<String, Barrel> barrels = new HashMap<String, Barrel>();

    public void addBarrel(Barrel barrel) {
        try {
            if (barrels.containsKey(barrel.getLabel())) {
                System.out.println("Положить бочку в погреб не удалось. Бочка с этикеткой \"" + barrel.getLabel() + "\" уже есть в погребе!");
            } else {
                barrels.put(barrel.getLabel(), barrel);
            }
        } catch (NullPointerException e) {
            System.err.println("Вы пытаетесь положить бочку, которая равна null");
            e.printStackTrace();
        }
    }

    public Barrel getBarrelByLabel(String label) {
        Barrel barrel = null;
        if (barrels.containsKey(label)) {
            barrel = barrels.get(label);
            barrels.remove(label);
        } else {
            System.out.println("Бочки с этикеткой \"" + label + "\" нет в погребе");
        }
        return barrel;
    }

    public void clearBarrelStorage() {
        barrels.clear();
        System.out.println("Погреб полностью опустошён!");
    }

    public void showAllLabels() {
        if (barrels.isEmpty()) {
            System.out.println("Погреб пуст!");
        } else {
            Set<String> labelsSet = barrels.keySet();
            System.out.println("Список бочек, имеющихся в погребе: ");
            int count = 1;
            for (String label : labelsSet) {
                System.out.println(count++ + ". " + label);
            }
        }
    }

    @Override
    public String toString() {
        return "BarrelStorageService{" +
                "Total barrels=" + barrels.size() +
                " ; barrels=" + barrels +
                '}';
    }
}
