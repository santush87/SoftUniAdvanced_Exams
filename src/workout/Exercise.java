package workout;

public class Exercise {
    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise() {
    }

    public Exercise(String name, String muscle, int burnedCalories) {
        this.name = name;
        setMuscle(muscle);
        setBurnedCalories(burnedCalories);
    }

    public String getName() {
        return name;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    public void setMuscle(String muscle) {
        if (!getName().equals(muscle)) {
            this.muscle = muscle;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setBurnedCalories(int burnedCalories) {
        if (burnedCalories >= 0) {
            this.burnedCalories = burnedCalories;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %d", getName(), getMuscle(), getBurnedCalories());
    }
}
