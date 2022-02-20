package Computer;

public class Ram {

    private final RamType ramType;
    private final int size;
    private final double weight;

    public Ram(double weight, int size, RamType ramType){
        this.weight = weight;
        this.size = size;
        this.ramType = ramType;
    }

    public Ram withWeight(double weight){
        return new Ram(weight, size, ramType);
    }

    public Ram withSize(int size){
        return new Ram(weight, size, ramType);
    }

    public Ram withTypeOfRam(RamType ramType){
        return new Ram(weight, size, ramType);
    }

    public RamType getType() {
        return ramType;
    }

    public int getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\tRAM:\n" +
                "\t\ttype - " + ramType + "; " +
                "size - " + size + " Mb; " +
                "weight - " + weight + " g.";
    }

}
