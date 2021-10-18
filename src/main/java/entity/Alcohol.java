package entity;

public abstract class Alcohol {
    protected final double alcoholByVolume;

    protected Alcohol(double alcoholByVolume) {
        this.alcoholByVolume = alcoholByVolume;
    }

    public double getAlcoholByVolume() {
        return alcoholByVolume;
    }

    @Override
    public String toString() {
        String[] alcoholClass = this.getClass().toString().split("\\.");
        return String.format("%s{" + "alcoholByVolume=%.2f}",
                alcoholClass[alcoholClass.length - 1],
                alcoholByVolume);
    }
}
