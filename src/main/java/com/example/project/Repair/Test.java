package com.example.project.Repair;

public class Test {
    public static void main(String[] args) {
        RepairSchedule schedule = new RepairSchedule(3); 
        System.out.println(schedule.addRepair(0, 1));
        System.out.println(schedule.getSchedule().size());
    }
}