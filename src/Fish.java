import org.w3c.dom.ls.LSOutput;

public class Fish {
    int age;
    String color;
    int size;
    boolean alive;

    public Fish(int age, String color, int size, boolean alive) {
        this.age = age;
        this.color = color;
        this.size = size;
        this.alive = alive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
