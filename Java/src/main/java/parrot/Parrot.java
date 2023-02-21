package parrot;

public class Parrot {

    public static final double BASE_SPEED_KMH = 12.0;
    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    /**
     * in km/h
     */
    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> getBaseSpeedKmh();
            case AFRICAN -> Math.max(0, getBaseSpeedKmh() - getLoadFactor() * numberOfCoconuts);
            case NORWEGIAN_BLUE -> (isNailed) ? 0 : getBaseSpeed(voltage);
        };
    }

    private static double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeedKmh());
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private static double getBaseSpeedKmh() {
        return BASE_SPEED_KMH;
    }

}
