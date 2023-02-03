import java.util.ArrayList;
import java.util.Random;


class CarDealership {
    private int cash;
    private ArrayList<Car> inventory;
    private ArrayList<Car> carsForSale;

    private Random rand;


    public CarDealership() {
        cash = 100000;
        inventory = new ArrayList<Car>();
        carsForSale = new ArrayList<Car>();
        rand = new Random();
        generateCarsForSale();
    }

    public void generateCarsForSale() {
        // losowa liczba samochodow
        int numOfCars = rand.nextInt(11) + 5;
        for (int i = 0; i < numOfCars; i++) {
            // losowa cena samochodow
            int value = rand.nextInt(45001) + 5000;
            // marka
            String brand = generateRandomBrand();
            // przebieg
            int mileage = rand.nextInt(300001);
            // kolor
            String color = generateRandomColor();

            String segment = generateRandomSegment();
            boolean[] repairsNeeded = generateRandomRepairs();
            carsForSale.add(new Car(value, brand, mileage, color, segment, repairsNeeded));
        }
    }

    public String generateRandomBrand() {
        String[] brands = {"Ford", "BMW", "Toyota", "Nissan"};
        return brands[rand.nextInt(brands.length)];
    }

    public String generateRandomColor() {
        String[] colors = {"Czarny", "Biały", "Srebrny", "Czerwony"};
        return colors[rand.nextInt(colors.length)];
    }

    public String generateRandomSegment() {
        String[] segments = {"premium", "standard", "budget"};
        return segments[rand.nextInt(segments.length)];
    }

    public boolean[] generateRandomRepairs() {
        boolean[] repairs = new boolean[5];
        for (int i = 0; i < repairs.length; i++) {
            repairs[i] = rand.nextBoolean();
        }
        return repairs;
    }

    public void buyCar(int index) {
        if (index < 0 || index >= carsForSale.size()) {
            System.out.println("Zły numer.");
        } else {
            Car car = carsForSale.get(index);
            if (car.getValue() > cash) {
                System.out.println("Nie masz hajsu na tą bryke");
            } else {
                cash -= car.getValue();
                inventory.add(car);
                carsForSale.remove(index);
                System.out.println("Kupiłeś za " + car.getValue() + "$.");
                generateCarsForSale();
            }
        }
    }

    public void sellCar(int index) {
        if (index < 0 || index >= inventory.size()) {
            System.out.println("Zły numer.");
        } else {
            Car car = inventory.get(index);
            cash += car.getValue();
            carsForSale.add(car);
            inventory.remove(index);
            System.out.println("Sprzedałeś autko za " + car.getValue() + "$.");
        }
    }

    public void showCarsForSale() {
        if (carsForSale.isEmpty()) {
            System.out.println("Brak samochodów.");
        } else {
            System.out.println("Samochody na sprzedaż:");
            for (int i = 0; i < carsForSale.size(); i++) {
                System.out.println((i + 1) + ". " + carsForSale.get(i));
            }
        }
    }

    public void showCarsOwned() {
        if (inventory.isEmpty()) {
            System.out.println("Nie masz żadnego auta.");
        } else {
            System.out.println("Posiadane bryczki:");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
        }
    }

    public int getCash() {
        return cash;
    }

}

