package Person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Class Person
 */
public class Person implements Comparable<Person>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime birthday; //Поле не может быть null
    private float weight; //Значение поля должно быть больше 0
    private Country country; //Поле не может быть null
    private Location location; //Поле не может быть null


    public Person(Person person) {
        this.id = person.id;
        this.name = person.name;
        this.coordinates = person.coordinates;
        this.creationDate = person.creationDate;
        this.height = person.height;
        this.birthday = person.birthday;
        this.weight = person.weight;
        this.country = person.country;
    }

    public Person() {
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Country getCountry() {return country;}

    public void setCountry(Country country) {this.country = country;}

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public void getInfo(){
        System.out.println("__________________________");
        System.out.println("Человек с id: "+getId()+"\nЧеловек с именем: "+getName()+"\nЕго координаты:\n\tx - "+coordinates.getX()+"\n\ty - "+coordinates.getY()+"\nДата создания: "+getCreationDate()+"\nРост человека в метрах: "+getHeight()+"\nДень рождения: "+getBirthday().getDayOfMonth()+"."+getBirthday().getMonthValue()+"."+getBirthday().getYear()+"\nВес в кг: "+getWeight()+"\nСтрана рождения - "+getCountry()+"\nЛокация:\n\tНазвание места - "+location.getName()+"\n\tx - "+location.getX()+"\n\ty - "+location.getY()+"\n\tz - "+location.getZ());
        System.out.println("__________________________");}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", birthday=" + birthday +
                ", weight=" + weight +
                ", country=" + country +
                ", location=" + location +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Float.compare(person.weight, weight) == 0 && Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(coordinates, person.coordinates) && Objects.equals(creationDate, person.creationDate) && Objects.equals(height, person.height) && Objects.equals(birthday, person.birthday) && country == person.country && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, birthday, weight, country, location);
    }

    @Override
    public int compareTo(Person o) {
        if(this.getName()==o.getName()){
            return 0;
        }if(this.getName().compareTo(o.getName())>0){
            return -1;
        }else{
            return 1;
        }
    }
}