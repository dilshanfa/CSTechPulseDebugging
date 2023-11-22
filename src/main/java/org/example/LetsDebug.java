package org.example;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;






/**
 * <div style="font-size: 300%;"> [CS TechPulse] - Advanced Debugging With Intellij IDEA </div>
 * <div style="font-size: 300%;"></div>
 * <div style="font-size: 300%;"></div>
 *
 * <div style="font-size: 150%;">By Dilshan Fardil</div>
 * <div style="font-size: 150%;">2023/11/24</div>
 */
public class LetsDebug {











    /**
     * <img src="/Users/dilshanfardil/Downloads/debugging-tactics.jpeg" width="2500"><br>
     */
    int slide1;









    /**
     * <div style="font-size: 300%;"> So why we debug ?? </div>
     * <div style="font-size: 300%;"></div>
     * <ul>
     * <li><div style="font-size: 180%;">Find and fix bug !!</div></li>
     * <div style="font-size: 100%;"></div>
     * <li><div style="font-size: 180%;">Code Analysis</div></li>
     * <ul>
     *     <li><div style="font-size: 150%;">What parts of the codes are execute</div></li>
     *     <li><div style="font-size: 150%;">Getting familiar with new code</div></li>
     *     <li><div style="font-size: 150%;">Understand the flow</div></li>
     * </ul>
     * <div style="font-size: 100%;"></div>
     * <li><div style="font-size: 180%;">Change the behaviour of the code</div></li>
     * <ul>
     *     <li><div style="font-size: 150%;">Reproduce a complicated setup</div></li>
     *     <li><div style="font-size: 150%;">Change the methods variable and simply anything on the fly</div></li>
     * </ul>
     * <div style="font-size: 100%;"></div>
     * <li><div style="font-size: 180%;">Add more logging on the fly</div></li>
     * <div style="font-size: 100%;"></div>
     * <li><div style="font-size: 180%;">Analyze memory issues</div></li>
     * <div style="font-size: 100%;"></div>
     * <li><div style="font-size: 180%;">Set a breakpoint bomb !!</div></li>
     * </li>
     */
    int slide2;














    /**
     * <div style="font-size: 300%;"> Debugger Essentials </div>
     * <div style="font-size: 300%;"></div>
     * <div style="font-size: 150%;">@see {org.example.thread.UsageAnalyzer}</div>
     */
    int slide3;
























    /**
     * <div style="font-size: 300%;"> Breakpoints Dialog </div>
     * <div style="font-size: 100%;"></div>
     * <ul>
     *  <li><div style="font-size: 120%;">Group By</div></li>
     *  <li><div style="font-size: 120%;">Custom Group</div></li>
     *  <li><div style="font-size: 120%;">Enable and Disable all at once</div></li>
     *  <li><div style="font-size: 120%;">Add descriptions</div></li>
     * </ul>
     * <div style="font-size: 180%;">@see wso2-synapse</div>
     *
     */
    int slide4;














    /**
     * <div style="font-size: 300%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li><div style="font-size: 120%;">No Suspend ?</div></li>
     *  <li><div style="font-size: 120%;">Evaluate Log</div></li>
     *  <li><div style="font-size: 120%;">Breakpoint hit</div></li>
     *  <li><div style="font-size: 120%;">Stacktrace Dump</div></li>
     *  <li><div style="font-size: 120%;">Shift + Click</div></li>
     *  <li><div style="font-size: 120%;">Change the value (as an eg - instance to null)</div></li>
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
     * <div style="font-size: 300%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li><div style="font-size: 120%;">Dependent Breakpoint</div></li>
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
     * <div style="font-size: 300%;"> Breakpoint Settings </div>
     *
     * <ul>
     *  <li><div style="font-size: 120%;">Suspended Thread Vs All</div></li>
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
     * <div style="font-size: 300%;"> Breakpoint Types </div>
     * <ul>
     * <li><div style="font-size: 120%;">Method BR</div></li>
     * <li><div style="font-size: 120%;">Interfaces</div></li>
     * <li><div style="font-size: 120%;">Wild Card Method</div></li>
     * </ul>
     *
     */
   public static class MethodBreakPoint
    {
        public static void main(String[] args)
        {
            MethodBreakPoint.BaseInterface baseInterface = SomeWhere.getObject();
            System.out.println(baseInterface.read());
            System.out.println(baseInterface.write());
        }

        public interface BaseInterface{
            String read();
            String write();
        }
    }







    /**
     * <div style="font-size: 300%;"> Breakpoint Types </div>
     * <ul>
     * <li><div style="font-size: 120%;">Field BP</div></li>
     * </ul>
     */
    public static class FieldBreakPoint
    {
        int var = new Random().nextInt(100);

        public static void main(String[] args)
        {
            FieldBreakPoint field = new FieldBreakPoint();
            SomeWhere.doSomething(field);
            if(field.var > 3)
            {
                System.out.println("Grater Than 3....!");
            }
            else
            {
                System.out.println("Less Than 3....!");
            }
        }

        void foobar()
        {
            var = 1;
        }

        void foo()
        {
            var = 2;
        }

        void bar()
        {
            var = 3;
        }

        void qux()
        {
            var = 4;
        }

        void waldo()
        {
            var = 5;
        }

        void fred()
        {
            var = 6;
        }

    }








    /**
     * <div style="font-size: 300%;"> Advanced Stepping </div>
     * <ul>
     * <li><div style="font-size: 120%;">Drop Frame</div></li>
     * <li><div style="font-size: 120%;">Force Return</div></li>
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
     * <div style="font-size: 300%;"> Renderers </div>
     * <ul>
     * <li><div style="font-size: 120%;">Mute</div></li>
     * <li><div style="font-size: 120%;">Settings</div></li>
     * <li><div style="font-size: 120%;">Switch</div></li>
     * <li><div style="font-size: 120%;">Debugging Stream</div></li>
     * </ul>
     *
     * <div style="font-size: 120%;">see UsageAnalyser</div>
     */
    int slide10;













    /**
     * <div style="font-size: 300%;"> Analysing Tools </div>
     */
    int slide11;













    /**
     * <div style="font-size: 300%;"> Remote Debug </div>
     * <ul>
     * <li><div style="font-size: 120%;">Remote configuration</div></li>
     * <li><div style="font-size: 120%;">Force Return</div></li>
     * </ul>
     *
     */
    public static class Endless
    {
        public static void main(String[] args) throws IOException {
            while(true)
            {
                int read = System.in.read();
                System.out.println(read);

                if(filter(read)){
                    process(read);
                }

            }
        }

        private static void process(int read) {
            if(Math.max(read,100) %2 ==0)
            {
                System.out.println("1");
            }
        }

        private static boolean filter(int read) {
            return read != '\n' && read != 'a';
        }

    }










    /**
     * <div style="font-size: 300%;"> Thank You </div>
     * <div style="font-size: 120%;"></div>
     * <div style="font-size: 120%;">Now you can debug much better !!!</div>
     */
    int anyQuestions;
















    public static class SomeWhere implements MethodBreakPoint.BaseInterface
    {
        public static MethodBreakPoint.BaseInterface getObject() {
            return new SomeWhere();
        }

        public static void doSomething(FieldBreakPoint field)
        {
            switch (field.var%6){
                case 1:
                    field.foobar();
                    break;
                case 2:
                    field.foo();
                    break;
                case 3:
                    field.bar();
                    break;
                case 4:
                    field.qux();
                    break;
                case 5:
                    field.fred();
                    break;
                default:
                    field.waldo();
                    break;
            }
        }

        @Override
        public String read()
        {
            return "Reading......!";
        }
        @Override
        public String write()
        {
            return "Writing......!";
        }
    }
}
