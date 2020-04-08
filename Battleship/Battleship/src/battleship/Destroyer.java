package battleship;

public class Destroyer extends Ship {
    public Destroyer() {
        this.length = 2;
    }

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }

    @Override
    public String toString() {
        if(this.isSunk())
            return "x";
        else
            return "S";
    }
}