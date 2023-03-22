package org.example.thread;

/**
 * This represents a thread usage object.
 *
 * @author Dilshan.Fardil
 * @created 2019-03-11
 */
public class ThreadUsage implements Comparable<ThreadUsage>
{
    int columnPID;
    int columnTID;
    double columnCPU;
    String columnTIME;
    int columnNLWP;
    int columnC;

    public ThreadUsage(int columnPID, int columnTID, double columnCPU, String columnTIME, int columnNLWP, int columnC) {
        this.columnPID = columnPID;
        this.columnTID = columnTID;
        this.columnCPU = columnCPU;
        this.columnTIME = columnTIME;
        this.columnNLWP = columnNLWP;
        this.columnC = columnC;
    }

    public int getColumnPID() {
        return columnPID;
    }

    public int getColumnTID() {
        return columnTID;
    }

    public double getColumnCPU() {
        return columnCPU;
    }

    public String getColumnTIME() {
        return columnTIME;
    }

    public int getColumnNLWP() {
        return columnNLWP;
    }

    public int getColumnC() {
        return columnC;
    }

    @Override
    public String toString() {
        return "ThreadUsage{" +
                "columnPID='" + columnPID + '\'' +
                ", columnTID='" + columnTID + '\'' +
                ", columnCPU='" + columnCPU + '\'' +
                ", columnTIME='" + columnTIME + '\'' +
                ", columnNLWP='" + columnNLWP + '\'' +
                ", columnC='" + columnC + '\'' +
                '}';
    }


    @Override
    public int compareTo(ThreadUsage o)
    {
        return Double.compare(this.getColumnCPU(), o.getColumnCPU());
    }
}
