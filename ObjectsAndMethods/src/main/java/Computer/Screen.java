package Computer;

public class Screen {
    private final double weight;
    private final double diagonal;
    private final ScreenType screenType;

    public Screen(double weight, double diagonal, ScreenType screenType){
        this.weight = weight;
        this.diagonal = diagonal;
        this.screenType = screenType;
    }

    public Screen withWeight(double weight){
        return new Screen(weight, diagonal, screenType);
    }

    public Screen withDiagonal(double diagonal){
        return new Screen(weight, diagonal, screenType);
    }

    public Screen withType(ScreenType screenType){
        return new Screen(weight, diagonal, screenType);
    }

    public double getWeight() {
        return weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public ScreenType getTypeOfScreen() {
        return screenType;
    }

    @Override
    public String toString() {
        return "\tScreen: \n" +
                "\t\ttype - " + screenType + "; " +
                "diagonal - " + diagonal + " inches; " +
                "weight - " + weight + " g.";
    }
}
