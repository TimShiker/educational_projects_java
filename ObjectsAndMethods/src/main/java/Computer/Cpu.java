package Computer;

public class Cpu {

    private final double frequency;
    private final int countOfCores;
    private final CpuVendor cpuVendor;
    private final double weight;

    public Cpu(double frequency, int countOfCores, CpuVendor cpuVendor, double weight) {
        this.frequency = frequency;
        this.countOfCores = countOfCores;
        this.cpuVendor = cpuVendor;
        this.weight = weight;
    }

    public Cpu withFrequency(double frequency){
        return new Cpu(frequency, countOfCores, cpuVendor, weight);
    }

    public Cpu withCountOfCores(int countOfCores){
        return new Cpu(frequency, countOfCores, cpuVendor, weight);
    }

    public Cpu withVendor(CpuVendor cpuVendor){
        return new Cpu(frequency, countOfCores, cpuVendor, weight);
    }

    public Cpu withWeight(double weight){
        return new Cpu(frequency, countOfCores, cpuVendor, weight);
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCountOfCores() {
        return countOfCores;
    }

    public CpuVendor getVendor() {
        return cpuVendor;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\tCPU: \n" +
                "\t\tfrequency - " + frequency + " GHz; " +
                "countOfCores - " + countOfCores + "; " +
                "vendor - " + cpuVendor + "; " +
                "weight - " + weight + " g.";
    }

}
