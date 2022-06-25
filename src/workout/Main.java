package workout;

public class Main {
    public static void main(String[] args) {

        Workout workout = new Workout("strength", 10);
        Exercise exercise = new Exercise("Bench Press", "chest", 30);
        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
        Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);
        Exercise fourthExercise = new Exercise("Squats", "legs", 60);
        Exercise fifthExercise = new Exercise("Deadlift", "legs", 55);

        workout.addExercise(exercise);
        workout.addExercise(secondExercise);
        workout.addExercise(thirdExercise);
        workout.addExercise(fourthExercise);
        workout.addExercise(fifthExercise);

        System.out.println(workout.getExerciseCount());
        System.out.println();
        System.out.println(workout.getStatistics());
        System.out.println();

        System.out.println(workout.getExercise("Squats1", "legs"));




    }
}
