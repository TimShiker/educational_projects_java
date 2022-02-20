package Computer;

public class Computer {

    private Cpu cpu;
    private Ram ram;
    private Hdd hdd;
    private Screen screen;
    private Keyboard keyboard;

    private final ComputerVendor computerVendor;
    private final String name;

    public Computer(ComputerVendor computerVendor, String name) {
        this.computerVendor = computerVendor;
        this.name = name;
    }

    public Computer(Cpu cpu, Ram ram, Hdd hdd, Screen screen, Keyboard keyboard,
                    ComputerVendor computerVendor, String name) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.screen = screen;
        this.keyboard = keyboard;
        this.computerVendor = computerVendor;
        this.name = name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double getTotalWeight() {
        return cpu.getWeight() + ram.getWeight() + hdd.getWeight() + screen.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Computer " + "\"" + name + "\"; vendor - " + "\"" + computerVendor + "\"" + ": \n" +
                cpu + "\n" +
                hdd + "\n" +
                ram + "\n" +
                keyboard + "\n" +
                screen;
    }



}
