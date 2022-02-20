package Computer;

public class Main {

    public static void main(String[] args) {

        // first computer add with constructor
        Cpu cpu = new Cpu(4.5, 4, CpuVendor.AMD, 12);
        Hdd hdd = new Hdd(450, 512, HddType.SSD);
        Ram ram = new Ram(70, 1024, RamType.DDR3);
        Keyboard keyboard = new Keyboard(250, true, KeyboardType.MULTIFUNCTIONAL);
        Screen screen = new Screen(500, 28.4, ScreenType.IPS);

        Computer computerFirst = new Computer(cpu, ram, hdd, screen,
                                                keyboard, ComputerVendor.ACER, "First Computer");

        System.out.println(computerFirst);

        // second computer add with setters and constructor

        Cpu cpuSecond = new Cpu(2.2, 8, CpuVendor.INTEL, 20);
        Hdd hddSecond = new Hdd(643, 1024, HddType.SSD);
        Ram ramSecond = new Ram(90, 2048, RamType.DDR4);
        Keyboard keyboardSecond = new Keyboard(200, false, KeyboardType.LAPTOP_SIZE);
        Screen screenSecond = new Screen(600, 32, ScreenType.TN);

        Computer computerSecond = new Computer(ComputerVendor.HP, "Second computer");
        computerSecond.setCpu(cpuSecond);
        computerSecond.setKeyboard(keyboardSecond);
        computerSecond.setScreen(screenSecond);
        computerSecond.setHdd(hddSecond);
        computerSecond.setRam(ramSecond);

        System.out.println("\n" + computerSecond);

        // third computer
        Cpu cpuThird = new Cpu(1.3, 1, CpuVendor.INTEL, 45);
        Hdd hddThird = new Hdd(1000, 256, HddType.HDD);
        Ram ramThird = new Ram(90, 512, RamType.DDR);
        Keyboard keyboardThird = new Keyboard(200, false, KeyboardType.HANDHELD);
        Screen screenThird = new Screen(368, 16, ScreenType.TN);

        Computer computerThird = new Computer(cpuThird, ramThird, hddThird, screenThird,
                                            keyboardThird, ComputerVendor.ASUS, "Third Computer");


        // out total weight each of computer
        System.out.println("\nTotal weight of first computer = " + computerFirst.getTotalWeight());
        System.out.println("Total weight of second computer = " + computerSecond.getTotalWeight());
        System.out.println("Total weight of third computer = " + computerThird.getTotalWeight());







    }
}
