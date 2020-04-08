package battleship;

public class Submarine extends Ship {

    public Submarine() {
        this.length = 1;
    }

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    public String getShipType() {
        return "submarine";
    }

    @Override
    public String toString() {
        if(this.isSunk())
            return "x";
        else
            return "S";
    }
}