import java.util.*;

public class Question03
{
    public static void mergeIntervals(List<int[]> intervals)
    {
        int i = 0;
        while (i < intervals.size() - 1)
        {
            int[] currentInterval = intervals.get(i);
            int[] nextInterval = intervals.get(i + 1);

            if (currentInterval[1] >= nextInterval[0])
            {
                // Overlapping intervals found, merge them
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
                intervals.remove(i + 1);
            } else
            {
                i++;
            }
        }
    }

    public static void display(List<int[]> intervals)
    {
        String formattedIntervals = "[ ";
        for (int i = 0; i < intervals.size(); i++)
        {
            int[] interval = intervals.get(i);
            formattedIntervals += "[" + interval[0] + ", " + interval[1] + "] ";
        }
        formattedIntervals += "]";
        System.out.println(formattedIntervals);

        System.out.print("\n");
    }
    public static void main(String[] args)
    {
        System.out.print("\n");

        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{2, 3});
        intervals.add(new int[]{4, 10});
        intervals.add(new int[]{11, 15});
        intervals.add(new int[]{15, 18});
        System.out.print("Input intervals: ");
        display(intervals);
        mergeIntervals(intervals);
        System.out.print("Merged intervals: ");
        display(intervals);

        System.out.print("\n");

        List<int[]> intervals1 = new ArrayList<>();
        intervals1.add(new int[]{1, 3});
        intervals1.add(new int[]{2, 6});
        intervals1.add(new int[]{8, 10});
        intervals1.add(new int[]{15, 18});
        System.out.print("Input intervals: ");
        display(intervals1);
        mergeIntervals(intervals1);
        System.out.print("Merged intervals: ");
        display(intervals1);

        List<int[]> intervals3 = new ArrayList<>(0);
        System.out.print("Input intervals: ");
        display(intervals3);
        mergeIntervals(intervals3);
        System.out.print("Merged intervals: ");
        display(intervals3);
    }
}

