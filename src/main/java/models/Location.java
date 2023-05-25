package models;

public class Location {
    private Double x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private long z;
    private String name; //Поле не может быть null

    public Double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setZ(long z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + x.toString() + "; " + y.toString() + "; " + Long.valueOf(z) + ")";
    }
}
