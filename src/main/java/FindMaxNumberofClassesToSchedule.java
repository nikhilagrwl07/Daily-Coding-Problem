package main.java;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxNumberofClassesToSchedule {
    public static void main(String[] args) {

        Pair<Integer, Integer> classSchedule1 = new Pair<>(30, 75);
        Pair<Integer, Integer> classSchedule2 = new Pair<>(0, 50);
        Pair<Integer, Integer> classSchedule3 = new Pair<>(60, 150);

        List<Pair<Integer, Integer>> schedules = new ArrayList<>(3);
        schedules.add(classSchedule1);
        schedules.add(classSchedule2);
        schedules.add(classSchedule3);

        int minimumNumberOfClassroomsRequired = minNumberOfClassRoomRequired(schedules);
        System.out.println(minimumNumberOfClassroomsRequired);

    }

    //Time Complexity - O(nlogn)
    //Space Complexity - O(n)
    private static int minNumberOfClassRoomRequired(List<Pair<Integer, Integer>> schedules) {

        int[] startTime = new int[schedules.size()];
        int[] endTime = new int[schedules.size()];
        int currentIndex = 0;

        for (Pair<Integer, Integer> p : schedules) {
            startTime[currentIndex] = p.getKey();
            endTime[currentIndex] = p.getValue();
            currentIndex++;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int overallClassMax = Integer.MIN_VALUE;
        int maxClassRequired = 0;
        int startClassIndex = 0;
        int endClassIndex = 0;

        while(startClassIndex< startTime.length) {

            if (startTime[startClassIndex] < endTime[endClassIndex]) {

                maxClassRequired++;
                startClassIndex++;
                if (overallClassMax < maxClassRequired)
                    overallClassMax = maxClassRequired;

            } else {
                maxClassRequired--;
                endClassIndex++;
            }
        }
        return overallClassMax;
    }

}


