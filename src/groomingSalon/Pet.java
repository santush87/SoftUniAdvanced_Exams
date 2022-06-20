package groomingSalon;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        setAge(age);
        setOwner(owner);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setOwner(String owner) {
        if (!getName().equals(owner)){
            this.owner = owner;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d - (%s)", getName(), getAge(), getOwner());
    }
}
