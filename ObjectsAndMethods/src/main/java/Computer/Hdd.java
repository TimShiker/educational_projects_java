package Computer;

public class Hdd {

    private final double weight;
    private final int size;
    private final HddType hddType;


    public Hdd(double weight, int size, HddType hddType){
        this.weight = weight;
        this.size = size;
        this.hddType = hddType;
    }

    public Hdd withWeight(double weight){
        return new Hdd(weight, size, hddType);
    }

    public Hdd withSize(int size){
        return new Hdd(weight, size, hddType);
    }

    public Hdd withType(HddType hddType){
        return new Hdd(weight, size, hddType);
    }

    public double getWeight(){
        return weight;
    }

    public int getSize() {
        return size;
    }

    public HddType getType() {
        return hddType;
    }

    @Override
    public String toString() {
        return "\tHDD: \n" +
                "\t\tsize - " + size + " Gb; " +
                "type - " + hddType + "; " +
                "weight - " + weight + " g.";
    }

}
