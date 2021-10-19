package entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Barrel {

    private final String label;
    private final Alcohol alcohol;
    private final double size;
    private double currentFilling;

}
