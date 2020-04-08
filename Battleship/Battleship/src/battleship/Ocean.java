package battleship;

import java.util.Random;

public class Ocean {
    //Instance variables
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    //Getters
    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public Ship[][] getShipArray() {
        return ships;
    }

    /**
     * End the game
     */
    public boolean isGameOver() {
        return this.getShipsSunk() == 10;
    }

    /**
     * Constructor
     */
    public Ocean() {
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ships[i][j] = new EmptySea();
            }
        }
        shipsSunk = 0;
    }

    /**
     * Generate ships on the field
     */
    public void placeAllShipsRandomly() {
        Random random = new Random();
        Ship[] shipstoplace = new Ship[] {new Battleship(), new Cruiser(), new Cruiser(), new Destroyer(), new Destroyer(), new Destroyer(),  new Submarine(), new Submarine(), new Submarine(), new Submarine() };
        for (int i = 0; i < 10; i++) {
            int bowRow, bowColumn;
            boolean horizontal;
            do {
                bowColumn = random.nextInt(9);
                bowRow = random.nextInt(9);
                horizontal = random.nextBoolean();
            } while (!shipstoplace[i].okToPlaceShipAt(bowRow, bowColumn, horizontal, this));
            shipstoplace[i].placeShipAt(bowRow, bowColumn, horizontal,this);
        }
    }

    /**
     * Check if the cell is occupied
     */
    public boolean isOccupied(int row, int column) {
        if(ships[row][column] instanceof EmptySea){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Shot in the cell
     */
    public boolean shootAt(int row, int column) {
        shotsFired++;
        if (ships[row][column].isSunk() || !(this.isOccupied(row, column))) {
            return false;
        }
        else {
            ships[row][column].shootAt(row, column);
            if(ships[row][column].isSunk()){
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
    }

    /**
     * Print the field on the screen
     */
    public void print() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                if (ships[i][j].isShot(i, j) || ships[i][j] instanceof EmptySea) {
                    System.out.print(ships[i][j].toString() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}