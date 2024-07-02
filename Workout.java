//Workout.java
/*
Purpose:

allows us to...
adds the workout to the username.csv
let us sees the workout
checks if the workout matches with user input


it inherits the FileHandler functions, but I call it with "FileHandler." to be more specific
 */

 public class Workout extends FileHandler{
    
    
    //adds the workout to the username.csv
    public static void addWorkout(String day, String workout, String fileName) {

        FileHandler.writeToRow(fileName,day,workout);

    }


     public static String showWorkout(String workoutName) {
         String[] data = FileHandler.ReadCol(0, workoutName, ",");
         if (data != null && data.length > 0) {
             return String.join(" \n", data); // Join all workouts with a newline character
         }
         return null; // or return ""; based on your requirement
     }




     //checks if the workout matches with user input
    public static boolean checkWorkout(String workoutName, String workoutChoice) {
        String[] data = FileHandler.ReadCol(0, workoutName, ",");

        for (String datum : data) {
            if (datum.equals(workoutChoice)) {
                return true;
            }
        }

        return false;
    }


}
