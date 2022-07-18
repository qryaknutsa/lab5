package Commands;

import Person.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class Creation
 */
public class Creation {
    private Scanner in = new Scanner(System.in);

    /**
     * Creating person
     *
     * @param id
     * @return
     */
    static ZonedDateTime zonedBirthday;
    static boolean vis;

    public Person create(String id) {
        Person person = new Person();
        if (id == "free") {
            person.setId(PersonCollections.getFreeId());
        } else {
            person.setId(Integer.parseInt(id));
        }
        this.setName(person);
        Coordinates coordinates = new Coordinates();
        this.setCoordinatesX(coordinates);
        this.setCoordinatesY(coordinates);
        person.setCoordinates(coordinates);
        person.setCreationDate(LocalDate.now());
        this.setHeight(person);
        Birthday b = new Birthday();
        this.setBirthdayYear(b);
        this.setBirthdayMonth(b);
        this.setBirthdayDay(b);
        person.setBirthday(zonedBirthday);
        this.setWeight(person);
        this.setCountry(person);
        Location location = new Location();
        this.setLocationX(location);
        this.setLocationY(location);
        this.setLocationZ(location);
        this.setLocationName(location);
        person.setLocation(location);

        return person;
    }

    /**
     * @param person
     */
    public void setName(Person person) {
        System.out.print("Введите имя человека: ");
        String name = in.nextLine();
        if (name.trim().length() == 0 | name.equals(null)) {
            System.out.println("Вы не ввели имя человека. Попробуйте ещё раз.");
            this.setName(person);
        }
        if (name.length() > Integer.MAX_VALUE) {
            System.out.println("Вы ввели длинное. Попробуйте ещё раз.");
            this.setName(person);
        } else {
            person.setName(name);
        }
    }

    /**
     * set coordinate x for coordinate for person
     *
     * @param cx
     */
    public void setCoordinatesX(Coordinates cx) {
        System.out.print("Введите координату х: ");
        String x = in.nextLine();
        if (x.trim().length() == 0 | x.equals(null)) {
            System.out.println("Вы не ввели значение х. Попробуйте ещё раз.");
            this.setCoordinatesX(cx);
        } else {
            try {
                int xx = Integer.parseInt(x);
                if (Math.abs(xx) > Integer.MAX_VALUE) {
                    System.out.println("Вы ввели некорректное значение для x. Попробуйте ещё раз.");
                    this.setCoordinatesX(cx);
                } else {
                    cx.setX(xx);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для x. Попробуйте ещё раз.");
                this.setCoordinatesX(cx);
            }
        }
    }

    /**
     * set coordinate y for coordinate for person
     *
     * @param cy
     */
    public void setCoordinatesY(Coordinates cy) {
        System.out.print("Введите координату y: ");
        String y = in.nextLine();
        if (y.trim().length() == 0 | y.equals(null)) {
            System.out.println("Вы не ввели значение y. Попробуйте ещё раз.");
            this.setCoordinatesY(cy);
        } else {
            try {
                Long yy = Long.parseLong(y);
                if (Math.abs(yy) > Long.MAX_VALUE) {
                    System.out.println("Вы ввели неправильное значение y. Попробуйте ещё раз.");
                    this.setCoordinatesY(cy);
                } else if (yy < -860) {
                    System.out.println("Вы ввели неправильное значение y. Координата y должна быть больше -860. Попробуйте ещё раз.");
                    this.setCoordinatesY(cy);
                } else {
                    cy.setY(yy);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для y. Попробуйте ещё раз.");
                this.setCoordinatesY(cy);
            }
        }
    }

    /**
     * Set height to person
     *
     * @param person
     */
    public void setHeight(Person person) {
        System.out.print("Введите значение роста в метрах: ");
        String h = in.nextLine();
        try {
            if (h.trim().length() == 0 | h.equals("")) {
                person.setHeight(null);
            } else {
                float hh = Float.parseFloat(h);
                if (hh <= 0) {
                    System.out.println("Вы ввели некорректное значение для роста, значение не может быть ниже нуля. Попробуйте ещё раз.");
                    this.setHeight(person);
                } else {
                    person.setHeight(hh);
                }
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение для роста. Попробуйте ещё раз.");
            this.setHeight(person);
        }
    }


    /**
     * Set weight to person
     *
     * @param person
     */
    public void setWeight(Person person) {
        System.out.print("Введите значение веса в килограммах: ");
        String w = in.nextLine();
        if (w.trim().length() == 0 | w.equals(null)) {
            System.out.println("Вы не ввели значение веса. Попробуйте ещё раз.");
            this.setWeight(person);
        }
        try {
            float ww = Float.parseFloat(w);
            if (ww <= 0) {
                System.out.println("Вы ввели некорректное значение для веса, значение не может быть ниже нуля. Попробуйте ещё раз.");
                this.setWeight(person);
            } else {
                person.setWeight(ww);
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение для веса. Попробуйте ещё раз.");
            this.setWeight(person);
        }
    }

    /**
     * Set country to person
     *
     * @param person
     */
    public void setCountry(Person person) {
        System.out.print("Выберите национальность человека (RUSSIA, FRANCE, NORTH KOREA), регистр не важен: ");
        String country = in.nextLine().toUpperCase();
        if (country.trim().length() == 0 | country.equals(null)) {
            System.out.println("Вы не выбрали страну. Попробуйте ещё раз.");
            this.setCountry(person);
        } else {
            try {
                person.setCountry(Country.valueOf(country));
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для национальности человека. Попробуйте ещё раз.");
                this.setCountry(person);
            }
        }
    }

    /**
     * set coordinate x for location for person
     *
     * @param locationX
     */
    public void setLocationX(Location locationX) {
        System.out.print("Введите координату х для обозначения локации: ");
        String x = in.nextLine();
        if (x.trim().length() == 0 | x.equals(null)) {
            System.out.println("Вы не ввели координату х. Попробуйте ещё раз.");
            this.setLocationX(locationX);
        } else {
            try {
                long xx = Long.parseLong(x);
                if (Math.abs(xx) > Long.MAX_VALUE) {
                    System.out.println("Вы ввели слишком большое значение х. Попробуйте ещё раз.");
                    this.setLocationX(locationX);
                } else {
                    locationX.setX(xx);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение х. Попробуйте ещё раз.");
                this.setLocationX(locationX);
            }
        }
    }

    /**
     * set coordinate y for location for person
     *
     * @param locationY
     */
    public void setLocationY(Location locationY) {
        System.out.print("Введите координату y для обозначения локации: ");
        String y = in.nextLine();
        if (y.trim().length() == 0 | y.equals(null)) {
            System.out.println("Вы не ввели координату y. Попробуйте ещё раз.");
            this.setLocationY(locationY);
        } else {
            try {
                Float yy = Float.parseFloat(y);
                if (Math.abs(yy) > Float.MAX_VALUE) {
                    System.out.println("Вы ввели слишком большое значение y. Попробуйте ещё раз.");
                    this.setLocationY(locationY);
                } else {
                    locationY.setY(yy);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение y. Попробуйте ещё раз.");
                this.setLocationY(locationY);
            }
        }
    }

    /**
     * set coordinate z for location for person
     *
     * @param locationZ
     */
    public void setLocationZ(Location locationZ) {
        System.out.print("Введите координату z для обозначения локации: ");
        String z = in.nextLine();
        if (z.trim().length() == 0 | z.equals(null)) {
            System.out.println("Вы не ввели координату z. Попробуйте ещё раз.");
            this.setLocationZ(locationZ);
        } else {
            try {
                Double zz = Double.parseDouble(z);
                if (Math.abs(zz) > Double.MAX_VALUE) {
                    System.out.println("Вы ввели слишком большое значение z. Попробуйте ещё раз.");
                    this.setLocationZ(locationZ);
                } else {
                    locationZ.setZ(zz);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение z. Попробуйте ещё раз.");
                this.setLocationZ(locationZ);
            }
        }
    }

    /**
     * set name for location for person
     *
     * @param locationName
     */
    public void setLocationName(Location locationName) {
        System.out.print("Введите имя локации: ");
        String name = in.nextLine();
        //if (name.trim().length() == 0 | name.equals("")) {
        if (name.trim().equals("")) {
            locationName.setName("null");
        } else {
            if (name.length() > Integer.MAX_VALUE) {
                System.out.println("Вы ввели слишком длинное имя локации. Попробуйте ещё раз.");
                this.setLocationName(locationName);
            } else {
                locationName.setName(name);
            }
        }
    }

    /**
     * set year for birthday for person
     *
     * @param birthday
     */
    public void setBirthdayYear(Birthday birthday) {
        System.out.print("Введите год рождения человека: ");
        String year = in.nextLine();
        if (year.trim().length() == 0 | year.equals(null)) {
            System.out.println("Вы не ввели год рождения. Попробуйте ещё раз.");
            this.setBirthdayYear(birthday);
        }
        try {
            int yyear = Integer.parseInt(year);
            if (yyear < 0 | yyear > LocalDate.now().getYear()) {
                System.out.println("Вы ввели некорректное значение года. Попробуйте ещё раз.");
                this.setBirthdayYear(birthday);
            } else {
                if (!((yyear % 4 == 0 & yyear % 100 != 0) || yyear % 400 == 0)) vis = false;
                else vis = true;
                birthday.setByear(yyear);
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значения года рождения. Попробуйте ещё раз.");
            this.setBirthdayYear(birthday);
        }
    }

    void incorrectMonth(Birthday birthday) {
        System.out.println("Вы не ввели месяц рождения. Попробуйте ещё раз.");
        this.setBirthdayMonth(birthday);
    }

    void correctMonth(Birthday birthday, int mmonth) {
        if (birthday.getByear() == LocalDate.now().getYear()) {
            if (mmonth > LocalDate.now().getMonthValue()) {
                System.out.println("Вы ввели некорректное значение месяца. Попробуйте ещё раз.");
                this.setBirthdayMonth(birthday);
            }
        }
        birthday.setBmonth(mmonth);
    }

    /**
     * set month for birthday for person
     *
     * @param birthday
     */

    public void setBirthdayMonth(Birthday birthday) {
        System.out.print("Введите месяц рождения человека: ");
        String month = in.nextLine();
        if (month.trim().length() == 0 | month.equals(null)) incorrectMonth(birthday);
        else {
            try {
                int mmonth = Integer.parseInt(month);
                if (mmonth <= 0 | mmonth >= 13) incorrectMonth(birthday);
                else correctMonth(birthday, mmonth);
            } catch (Exception e) {
                incorrectMonth(birthday);
            }
        }
    }

    /**
     * set day for birthday for person
     *
     * @param birthday
     */

    void incorrectDate(Birthday birthday) {
        System.out.println("Вы ввели некорректное значение даты. Попробуйте ещё раз.");
        this.setBirthdayDay(birthday);
    }

    void coorectDate(Birthday birthday, int dday) {
        if (birthday.getByear() == LocalDate.now().getYear()) {
            if (birthday.getBmonth() == LocalDate.now().getMonthValue()) {
                if (dday > LocalDate.now().getDayOfMonth()) {
                    incorrectDate(birthday);
                }
            }
        }
        birthday.setBday(dday);
        zonedBirthday = ZonedDateTime.of(birthday.getByear(), birthday.getBmonth(), dday, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
    }


    public void setBirthdayDay(Birthday birthday) {
        System.out.print("Введите число рождения человека: ");
        String day = in.nextLine();
        int month = birthday.getBmonth();
        //System.out.println("month was" + month);
        if (day.trim().length() == 0 | day.equals(null)) {
            System.out.println("Вы не ввели месяц рождения. Попробуйте ещё раз.");
            this.setBirthdayDay(birthday);

        } else {
            try {
                int dday = Integer.parseInt(day);
                if (dday <= 0 | dday > 31) incorrectDate(birthday);
                if (month == 2) {
                    if (!vis) {
                        if (dday > 28) incorrectDate(birthday);
                        if (dday <= 28) coorectDate(birthday, dday);
                    } else {
                        if (dday > 29) incorrectDate(birthday);
                        if (dday <= 29) coorectDate(birthday, dday);
                    }

                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (dday > 30) incorrectDate(birthday);
                    if (dday <= 30) coorectDate(birthday, dday);
                } else {
                    //System.out.println(month);
                    if (dday > 31) incorrectDate(birthday);
                    if (dday <= 31) coorectDate(birthday, dday);
                }


            } catch (DateTimeException e) {
                e.printStackTrace();
                incorrectDate(birthday);
            }
        }
    }
}
