package models;


public class Coordinates {
    private Float x; //Поле не может быть null
    private Float y; //Значение поля должно быть больше -550, Поле не может быть null
    private final float yMin = -550;

    public Coordinates(){

    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public boolean setY(Float y) {
        if (y > yMin){
            this.y = y;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x.toString() + "; " + y.toString() + ")";
    }
}

