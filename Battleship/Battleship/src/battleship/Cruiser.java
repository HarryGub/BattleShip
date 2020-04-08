package battleship;

public class Cruiser extends Ship {
    public Cruiser() {
        this.length = 3;
    }

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }

    @Override
    public String toString() {
        if(this.isSunk())
            return "x";
        else
            return "S";
    }
}