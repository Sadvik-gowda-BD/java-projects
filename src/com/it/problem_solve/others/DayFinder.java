package com.it.problem_solve.others;

public class DayFinder {


    public static void main(String[] args) {
        int num = 0;
        String day = "MONDAY";

        Day currentDay = Day.valueOf(day);

        int modDay = (num + currentDay.getNum()) % 7;

        int dayNum = modDay == 0 ? 7 : modDay;

        System.out.println("Day = " + Day.getDayByNum(dayNum));

    }


}


enum Day {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5),
    SATURDAY(6), SUNDAY(7);

    final int dayNum;

    Day(int dayNum) {
        this.dayNum = dayNum;
    }

    public int getNum() {
        return this.dayNum;
    }

    public static Day getDayByNum(int num) {
        for (Day day : Day.values()) {
            if (day.dayNum == num) {
                return day;
            }
        }
        return null;
    }

}
