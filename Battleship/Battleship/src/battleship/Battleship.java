package battleship;

public class Battleship extends Ship {
    public Battleship() {
        this.length = 4;
    }

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    public String getShipType() {
        return "battleship";
    }

    @Override
    public String toString() {
        if(this.isSunk())
            return "x";
        else
            return "S";
    }
}