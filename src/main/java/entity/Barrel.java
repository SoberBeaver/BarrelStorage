package entity;

public class Barrel {

    private final String label;
    private Alcohol alcohol;
    private final double size;
    private double currentFilling;


    public Barrel(String label, Alcohol alcohol) {
        this(label, alcohol, 20, 20);
    }

    public Barrel(String label, Alcohol alcohol, double size, double currentFilling) {
        this.label = label;
        this.alcohol = alcohol;
        this.size = size;
        this.currentFilling = currentFilling;
    }

    public String getLabel() {
        return label;
    }

    public Alcohol getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Alcohol alcohol) {
        this.alcohol = alcohol;
    }

    public double getSize() {
        return size;
    }

    public double getCurrentFilling() {
        return currentFilling;
    }

    public void setCurrentFilling(double currentFilling) {
        this.currentFilling = currentFilling;
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "label='" + label + '\'' +
                ", alcohol=" + alcohol +
                ", size=" + size +
                ", currentFilling=" + currentFilling +
                '}';
    }
}
