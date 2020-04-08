package battleship;

public class EmptySea extends Ship {

    boolean isShot;

    public EmptySea() {
        this.length = 1;
        isShot = false;
    }

    @Override
    public int getLength(){
        return this.length;
    }

    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    @Override
    public boolean isSunk() {
        isShot = true;
        return false;
    }

    @Override
    public String toString() {
        if(isShot)
            return "-";
        else
            return ".";
    }
}
