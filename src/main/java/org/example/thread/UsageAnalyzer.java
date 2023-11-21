package org.example.thread;

import java.io.*;
import java.util.*;




/**
 *
 * This class analyzes the thread usage and prints the top N threads with highest CPU usage.
 *
 * @author Dilshan.Fardil
 * @created 2019-03-11
 */
public class UsageAnalyzer
{


    /**
     *  <div style="font-size: 300%;"> Renderers </div>
     *  <ul>
     *  <li><div style="font-size: 120%;">Mute</div></li>
     *  <li><div style="font-size: 120%;">Settings</div></li>
     *  <li><div style="font-size: 120%;">Switch</div></li>
     *  </ul>
     */

    private static final String FILE_NAME = "./src/main/resources/thread_usage.txt";
    private static Map<String, ThreadUsage> threadUsageMap = new HashMap<>();


    public static void main(String[] args) throws IOException
    {
        List<String> threadUsageLines = readAsList(FILE_NAME);
        toMap(threadUsageLines);

        System.out.print("Top ");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int count = scan.nextInt();
            threadUsageMap
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingDouble(e -> e.getValue().getColumnCPU()))
                    .skip(threadUsageLines.size() - count)
                    .forEach((e) -> System.out.println("Thread ID - " + "0x" + Integer.toHexString(e.getValue().getColumnTID()) + " CPU Usage - " + e.getValue().getColumnCPU()));
        }
    }

    private static void toMap(List<String> threadUsageLines) {
        threadUsageLines.remove(0);

        for (String threadUsageLine : threadUsageLines)
        {
            ThreadUsage threadUsage = mapToThreadUsage(threadUsageLine);
            threadUsageMap.put(String.valueOf(threadUsage.getColumnTID()), threadUsage);
        }
    }

    private static List<String> readAsList(String file) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String str;

        List<String> list = new ArrayList<>();
        while ((str = in.readLine()) != null)
        {
            list.add(str);
        }
        return list;
    }


    private static ThreadUsage mapToThreadUsage(String line)
    {
        String[] columns = line.split("\\s+");
        return new ThreadUsage(
                Integer.parseInt(columns[1]),
                Integer.parseInt(columns[2]),
                Double.parseDouble(columns[3]),
                columns[4],
                Integer.parseInt(columns[5]),
                Integer.parseInt(columns[6])
        );
    }


}
