package pl.susfenix.course.backend.simple_java.lesson2.object.pesel.model;

import java.time.LocalDate;
import java.util.Objects;

public class PeselData extends Object {
    public LocalDate birthDay;
    private final int year;
    private final int century;
    private final int month;
    private final int day;
    private final String gender;


    public PeselData(LocalDate birthDay,
                     int year,
                     int century,
                     int month,
                     int day,
                     String gender) {
        this.birthDay = birthDay;
        this.year = year;
        this.century = century;
        this.month = month;
        this.day = day;
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getYear() {
        return year;
    }

    public int getCentury() {
        return century;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeselData peselData = (PeselData) o;
        return year == peselData.year &&
                century == peselData.century &&
                month == peselData.month &&
                day == peselData.day &&
                birthDay.equals(peselData.birthDay) &&
                gender.equals(peselData.gender);
    }

    @Override
    public int hashCode() {
       return Objects.hash(birthDay, year, century, month, day, gender);

    }


    @Override
    public String toString() {
        return "PeselData{" +
                "birthDay=" + birthDay +
                ", year=" + year +
                ", century=" + century +
                ", month=" + month +
                ", day=" + day +
                ", gender='" + gender + '\'' +
                '}';
    }

   /* public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        PeselData data = new PeselData(currentDate,
                5,
                4,
                11,
                30,
                "Man"
        );
        System.out.println(data);
        PeselData data2 = new PeselData(currentDate,
                6,
                4,
                11,
                30,
                "Man"
        );
        System.out.println(data.hashCode());
        System.out.println(data2.hashCode());
    }*/
}