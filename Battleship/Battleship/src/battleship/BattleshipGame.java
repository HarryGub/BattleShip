package battleship;

import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        do {
            Ocean ocean = new Ocean();
            ocean.placeAllShipsRandomly();
            ocean.print();
            do {
                System.out.println("Ships sunk: " + ocean.getShipsSunk());
                System.out.println("Shots: " + ocean.getShotsFired() + "; Hits: " + ocean.getHitCount());
                System.out.println("Shooting coordinates:");
                try {
                    System.out.print("  Row: ");
                    s = scanner.nextLine();
                    int x = Integer.valueOf(s);
                    System.out.print("  Column: ");
                    s = scanner.nextLine();
                    int y = Integer.valueOf(s);
                    if (x < 0 || x > 9 || y < 0 || y > 9) {
                        System.out.println("Invalid value!");
                        continue;
                    }
                    if (ocean.shootAt(x, y)) {
                        System.out.println("hit!");
                    } else {
                        System.out.println("miss");
                    }
                    if (ocean.getShipArray()[x][y].isSunk()) {
                        System.out.println(ocean.getShipArray()[x][y].getShipType() + " was sunk");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid value!");
                    continue;
                }
                ocean.print();
            } while (!ocean.isGameOver());
            System.out.println("Game over!");
            System.out.println("Total shots: " + ocean.getShotsFired() + "; Total hits: " + ocean.getHitCount());
            System.out.println("Do you want to play again?\n(Enter Y(Yes) to play again or any other botton to exit)");
            s = scanner.nextLine();
            if(!(s.equals("Y"))){
                break;
            }
        }while(true);
    }
}