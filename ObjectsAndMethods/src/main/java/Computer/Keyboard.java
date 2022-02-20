package Computer;

public class Keyboard {
    private final double weight;
    private final boolean isBacklight;
    private final KeyboardType keyboardType;

    public Keyboard(double weight, boolean isBacklight, KeyboardType keyboardType) {
        this.weight = weight;
        this.isBacklight = isBacklight;
        this.keyboardType = keyboardType;
    }

    public Keyboard withWeight(double weight) {
        return new Keyboard(weight, isBacklight, keyboardType);
    }

    public Keyboard withIsBacklight(boolean isBacklight) {
        return new Keyboard(weight, isBacklight, keyboardType);
    }

    public Keyboard withType(KeyboardType keyboardType) {
        return new Keyboard(weight, isBacklight, keyboardType);
    }

    public double getWeight() {
        return weight;
    }

    public boolean isBacklight() {
        return isBacklight;
    }

    public KeyboardType getType() {
        return keyboardType;
    }

    @Override
    public String toString() {
        return "\tKeyboard: \n" +
                "\t\ttype - " + keyboardType + "; " +
                "backlight - " + isBacklight + "; " +
                "weight - " + weight + " g.";
    }
}
