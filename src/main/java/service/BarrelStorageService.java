package service;

import entity.Barrel;
import exception.DuplicateLabelException;
import exception.EmptyStorageException;

import java.util.HashMap;
import java.util.Set;

public class BarrelStorageService {
    private final HashMap<String, Barrel> barrels = new HashMap<String, Barrel>();

    public void addBarrel(Barrel barrel) throws DuplicateLabelException {
        String label = null;
        try {
            label = barrel.getLabel();
        } catch (NullPointerException e) {
            System.err.println("Вы пытаетесь положить бочку, которая равна null");
            e.printStackTrace();
            return;
        }

        if (barrels.containsKey(label)) {
            throw new DuplicateLabelException("Положить бочку в погреб не удалось. Бочка с этикеткой \"" + barrel.getLabel() + "\" уже есть в погребе!");
        } else {
            barrels.put(label, barrel);
        }
    }

    public Barrel getBarrelByLabel(String label) {
        Barrel barrel = null;

        if (barrels.isEmpty()) {
            throw new EmptyStorageException("Погреб пуст!");
        }

        if (barrels.containsKey(label)) {
            barrel = barrels.remove(label);
        } else {
            System.out.println("Бочки с этикеткой \"" + label + "\" нет в погребе");
        }
        return barrel;
    }

    public void clearBarrelStorage() {
        barrels.clear();
        System.out.println("Погреб полностью опустошён!");
    }

    public void showAllLabels() throws EmptyStorageException {
        if (barrels.isEmpty()) {
            throw new EmptyStorageException("Погреб пуст!");
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
