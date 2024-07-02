//Schedule.java
/*
Purpose:

it allows us to...
add a workout type in the file
check if the schedule has enough entries



it inherits the FileHandler functions, but I call it with "FileHandler." to be more specific
 */

import java.util.HashMap;
import java.util.Map;

public class Schedule extends FileHandler {


    public static void addType(String day, String type, String fileName) {
        FileHandler.addRecord(fileName, day, type, "null", 0);
    }


    public static boolean checkSchedule(String fileName) {


        String[] data1 = FileHandler.ReadCol(1, fileName, ",");
        Map<String, Integer> valueCounts = new HashMap<>();


        for (String data : data1) {
            if (data != null && !data.isEmpty() && !"null".equals(data)) {
                valueCounts.put(data, valueCounts.getOrDefault(data, 0) + 1);
            }
        }

        int totalCount = 0;
        for (int count : valueCounts.values()) {
            totalCount += count;
        }


        return totalCount >= 3 && totalCount <= 6;
    }

}