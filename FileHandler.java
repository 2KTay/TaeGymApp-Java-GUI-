//FileHandler.java
/*
Purpose:

the biggest of all the files

it has 4 inheritors(Exercise, User, Schedule, and Workout)
FileHandler can handle all the functions such as...
creating a file
reading a column
replacing something within that column (so getting rid of the nulls)
appends on a row
prints the entirely of a file
shows information from that exercise




 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    // Creates a file with username and password or checks if username already exists

    @SuppressWarnings("resource")
    public static boolean createFile(String fileName, String username, String password, String first, String second, String message) {
        try {
            File f = new File(fileName);
            FileWriter myWriter = new FileWriter(fileName, true);
            Scanner scanner = new Scanner(f);

            if (f.length() == 0) {
                myWriter.write(first + "," + second + "\n");
                myWriter.write(username + "," + password + "\n");
            } else {
                boolean usernameExists = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length >= 2 && parts[0].equals(username)) {
                        usernameExists = true;
                        break;
                    }
                }
                if (usernameExists) {

                    return false;
                } else {
                    myWriter.write(username + "," + password + "\n");
                }
            }
            myWriter.close();
            return true;
        } catch (IOException e) {

            return false;
        }
    }

    // Creates a file with specified days of the week
    public static void createFile(String fileName, String[] daysOfWeek) {
        try {
            File f = new File(fileName);
            FileWriter myWriter = new FileWriter(fileName, true);

            if (f.length() == 0) {
                myWriter.write(daysOfWeek[0] + "," + daysOfWeek[1] + "," + daysOfWeek[2] + "," +
                        daysOfWeek[3] + "," + daysOfWeek[4] + "," + daysOfWeek[5] + "," + daysOfWeek[6] + "," + "\n");
                myWriter.close();
            }
        } catch (IOException e) {

        }
    }

    // Reads a specific column from a CSV file
    public static String[] ReadCol(int col, String filepath, String delimiter) {
        String data[];
        String currentLine;
        ArrayList<String> colData = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(filepath);
            try (BufferedReader br = new BufferedReader(fr)) {
                while ((currentLine = br.readLine()) != null) {
                    data = currentLine.split(delimiter);
                    colData.add(data[col]);
                }
            }
        } catch (IOException e) {

            return null;
        }
        return colData.toArray(new String[0]);
    }

    // Adds a record to a specific column in a CSV file
    public static void addRecord(String fileName, String nameToFind, String recordToAdd, String replaceWith, int columnNumber) {
        try {
            File inputFile = new File(fileName);

            ArrayList<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            for (String line : lines) {
                String[] columns = line.split(",");
                if (columns.length > columnNumber && columns[columnNumber].trim().equals(nameToFind)) {
                    line = line.replace(replaceWith, recordToAdd);
                }
                writer.write(line + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Appends data to a specific row in a CSV file
    public static void writeToRow(String csvFilePath, String findString, String appendString) {
        String line;
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                if (line.contains(findString)) {
                    line += appendString;
                }
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write(fileContent.toString());
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Prints the contents of a file
    public static String printFileContents(String filePath) {
        StringBuilder fileContents = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return fileContents.toString();
    }


    // Shows information for a specific exercise from a CSV file
    public static String showExerInfo(String exerciseName, String fileChoiceCSV, String delimiter, int exerciseColumnIndex) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileChoiceCSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(delimiter);
                if (parts.length > exerciseColumnIndex && parts[exerciseColumnIndex].trim().equalsIgnoreCase(exerciseName.trim())) {

                    return ("Exercise: " + parts[exerciseColumnIndex] + "\n" + "Info: " + parts[exerciseColumnIndex + 1]);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    // Clears data for a specific row in a CSV file
    public static void clearWeekDay(String csvFilePath, String findString) {
        String line;
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().startsWith(findString.toLowerCase() + ",")) {
                    line = findString + ",null,";
                }
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write(fileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

