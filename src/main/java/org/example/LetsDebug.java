package org.example;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <h1> [Sirius Kuppi] - Advance Debugging Session </h1>
 * <h2>Dilshan Fardil</h3>
 * <h4>2023/03/23</h4>
 */
public class LetsDebug {















    /**
     * <div style="font-size: 160%;"> So why we debug ?? </div>
     * <ul>
     * <li>Find and fix the bug or to create a nice internal issue</li>
     * <li>Code Analysis</li>
     * <ul>
     *     <li>What parts of the codes are execute</li>
     *     <li>Getting familiar with new code</li>
     *     <li>Understand the flow</li>
     * </ul>
     * <li>Change the behaviour of the code</li>
     * <ul>
     *     <li>Reproduce a complicated setup</li>
     *     <li>Change the methods variable and simply anything on the fly</li>
     * </ul>
     * </li>
     */
    int slide1;











    /**
     * <div style="font-size: 160%;"> Let's Cover the basics first </div>
     * @see org.example.thread.UsageAnalyzer
     */
    int slide2;















    /**
     * <div style="font-size: 160%;"> Breakpoints Dialog </div>
     *
     * <ul>
     *  <li>Group By</li>
     *  <li>Custom Group</li>
     *  <li>Enable and Disable all at once</li>
     *  <li>Add descriptions</li>
     * </ul>
     * @see @api-mgt-module
     */
    int slide3;








    /**
     * <div style="font-size: 160%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li>No Suspend ?</li>
     *  <li>Evaluate Log</li>
     *  <li>Breakpoint hit</li>
     *  <li>Stacktrace Dump</li>
     *  <li>Shift + Click</li>
     *  <li>Change the value (as an eg - instance to null)</li>
     * </ul>
     */
    public static class Cache
    {
        private static Cache instance = new Cache();

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                System.out.println(getInstance(i));
            }
        }
        private static Cache getInstance(int i)
        {
            if(instance == null){
                instance = new Cache();
            }
            return instance;
        }

    }






    /**
     * <div style="font-size: 160%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li>Dependent Breakpoint</li>
     * </ul>
     */
    public static class Workout
    {

        public static void main(String[] args)
        {
            warmUp();

            workout();
        }

        private static void warmUp(){
            for (int i = 0; i < 10; i++) {
                count();
            }
        }

        private static void workout(){
            for (int i = 0; i < 10; i++) {
                count();
            }
        }

        private static void count()
        {
            int count = 10;
        }

    }





    /**
     * <div style="font-size: 160%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li>Suspended Thread Vs All</li>
     * </ul>
     */
    public static class ConcurrencyTest
    {
        @Test
        public void main() throws InterruptedException{
            assertSame(1, work().size());
        }

        static List<Integer> work() throws InterruptedException{
            final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
            Thread thread = new Thread(() -> addIfAbsent(list,20));
            thread.start();
            addIfAbsent(list, 20);
            thread.join();
            System.out.println("Elements : " + list);
            return list;
        }

        private static void addIfAbsent(List<Integer> list, int x)
        {
                if (!list.contains(x)) {
                    list.add(x);
                }

        }
    }






    /**
     * <div style="font-size: 160%;"> Breakpoint Types </div>
     * <ul>
     * <li>Method BR</li>
     * <li>Interfaces</li>
     * <li>Class BR Wild Cards</li>
     * <li>Exception BR</li>
     * </ul>
     *
     */
    public static void main(String[] args)
    {
        System.out.println("See Verify HostName Scenario");
    }



    /**
     * <div style="font-size: 160%;"> Advanced Stepping </div>
     * <ul>
     * <li>Drop Frame</li>
     * <li>Force Return</li>
     * </ul>
     *
     */
    public static class AdvancedStepping
    {
        public static void main(String[] args) {

            for (int i = 0; i < 10; i++) {
                System.out.println(multiply(add(10)));
            }

        }

        private static int multiply(int number)
        {
            for (int i = 1; i < 4; i++) {
                number*=i;
            }
            return number;
        }

        private static int add(int number)
        {
            for (int i = 0; i < 4; i++) {
                number+=i;
            }
            return number;
        }

    }


    /**
     * <h1> Thank You </h1>
     * <h3>Now you can debug much better !!!</h3>
     */
    int anyQuestions;

}
