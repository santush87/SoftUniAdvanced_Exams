package vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet() {
    }

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

    public String getOwner() {
        return owner;
    }

    public void setName(String name) {
        if (!getOwner().equals(name)){
            this.name = name;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setOwner(String owner) {
        if (!this.name.equals(owner)) {
            this.owner = owner;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", getName(), getAge(), getOwner());
    }
}
