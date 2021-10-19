package entity;

import lombok.Data;

@Data
public abstract class Alcohol {
    protected final double alcoholByVolume;

    @Override
    public String toString() {
        String[] alcoholClass = this.getClass().toString().split("\\.");
        return String.format("%s{" + "alcoholByVolume=%.2f}",
                alcoholClass[alcoholClass.length - 1],
                alcoholByVolume);
    }
}
