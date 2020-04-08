package battleship;

public class Ship {
    //Instance variables
    protected int bowRow;
    protected int bowColumn;
    protected int length;
    protected boolean horizontal;
    protected boolean [] hit = new boolean[4];

    public int getLength()
    {
        return 0;
    }

    //Getters
    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    //Setters
    public void setBowRow(int row) {
        bowRow = row;
    }

    public void setBowColumn(int column) {
        bowColumn = column;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public String getShipType() {
        return "ship";
    }

    /**
    * Check if it is ok to place a ship on the field
    */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        Ship[][] field = ocean.getShipArray();
        int copyR = row, copyC = column;
        for (int i = 0; i < this.getLength(); i++) {
            if(horizontal) {
                copyC = column + i;
            } else {
                copyR = row + i;
            }
            if (copyR < 0 || copyR > 9 || copyC < 0 || copyC > 9) {
                return false;
            }
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (copyR + x < 0 || copyR + x > 9 || copyC + y < 0 || copyC + y > 9) {
                        continue;
                    } else {
                        if (!(field[copyR + x][copyC + y] instanceof EmptySea)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Place a ship on the field
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);
        this.setBowColumn(column);
        this.setHorizontal(horizontal);
        Ship[][] field = ocean.getShipArray();
        for (int i = 0; i < this.getLength(); i++) {
            if (horizontal) {
                field[row][column + i] = this;
            } else {
                field[row + i][column] = this;
            }
        }
    }

    /**
     * Shooting the ship
     */
    public boolean shootAt(int row, int column) {
        if (this.isSunk()) {
            return false;
        } else {
            if (this.isHorizontal()) {
                for (int i = 0; i < this.getLength(); i++)
                    if (this.getBowColumn() + i == column) {
                        hit[i] = true;
                        return true;
                    }
            } else {
                for (int i = 0; i < this.getLength(); i++) {
                    if (this.getBowRow() + i == row) {
                        hit[i] = true;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Check if the ship is sunk
     */
    public boolean isSunk() {
        for (int i = 0; i < this.getLength(); i++) {
            if (hit[i] == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the ship is shot
     */
    public boolean isShot(int row, int column) {
        try {
            if(this.isHorizontal()){
                return hit[column - this.getBowColumn()];
            }else{
                return hit[row - this.getBowRow()];
            }
        } catch(Exception e) {
            return false;
        }
    }
}