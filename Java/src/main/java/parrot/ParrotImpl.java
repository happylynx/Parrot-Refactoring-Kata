package parrot;

public class ParrotImpl implements Parrot {

    public static final double LOAD_FACTOR = 9.0;
    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public ParrotImpl(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> BASE_SPEED_KMH;
            case AFRICAN -> Math.max(0, BASE_SPEED_KMH - LOAD_FACTOR * numberOfCoconuts);
            case NORWEGIAN_BLUE -> isNailed ? 0 : Math.min(24.0, voltage * BASE_SPEED_KMH);
        };
    }

}
