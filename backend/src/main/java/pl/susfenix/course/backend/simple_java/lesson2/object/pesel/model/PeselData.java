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

    public String getPrettyBirthDate() {
        int birthDay = this.birthDay.getDayOfMonth();
        int birthDay2 = birthDay % 10;

        String sufix = " of " + this.month + " " + this.year;

        if (birthDay2 == 1) {
            return birthDay + "st" + sufix;
        } else if (birthDay2 == 2) {
            return birthDay + "nd" + sufix;
        } else if (birthDay2 == 3) {
            return birthDay + "rd" + sufix;
        } else {
            return birthDay + "th" + sufix;
        }
    }

    public int calculateAgeYearly() {
        return LocalDate.now().getYear() - this.year;
    }

    public int calculateAge() {

        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonth().getValue();
        int currentDay = currentDate.getDayOfMonth();

        int additionalMinus = 0;
        if (currentMonth - this.month < 0) {
            additionalMinus = 1;
        } else if (currentMonth == this.month && currentDay - this.day < 0) {
            additionalMinus = 1;
        }
        return calculateAgeYearly() - additionalMinus;
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