import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Samochody do kupienia");
            System.out.println("2. Posiadane samochody");
            System.out.println("3. Kup auto");
            System.out.println("4. Sprzedaj auto");
            System.out.println("5. Wyjście");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dealership.showCarsForSale();
                    break;
                case 2:
                    dealership.showCarsOwned();
                    break;
                case 3:
                    System.out.println("Podaj numer samochodu:");
                    int carIndex = scanner.nextInt();
                    dealership.buyCar(carIndex - 1);
                    break;
                case 4:
                    System.out.println("Podaj numer samochodu:");
                    int carIndex2 = scanner.nextInt();
                    dealership.sellCar(carIndex2 - 1);
                    break;
                case 5:
                    System.out.println("Bywaj");
                    return;
                default:
                    System.out.println("error error zły numer żeś zrobił.");
                    break;
            }
        }
    }

}