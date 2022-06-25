package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private final String type;
    private final int exerciseCount;
    private final List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return this.exercises.remove(exercise);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (this.exercises.isEmpty()) {
            return null;
        } else {
            Exercise exercise = new Exercise();
            for (Exercise currExercise : this.exercises) {
                if (currExercise.getBurnedCalories() > exercise.getBurnedCalories()) {
                    exercise = currExercise;
                }
            }
            return exercise;
        }
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("Workout type: ").append(this.type).append(System.lineSeparator());
        for (int i = 0; i < this.exercises.size(); i++) {
            builder.append(this.exercises.get(i));
            if (i < this.exercises.size() - 1) {
                builder.append(System.lineSeparator());
            }
        }

        return builder.toString();
    }
}
