import java.util.Date;

public class Usuarios {

    public String charge;
    public String document;
    public String name;
    public String lastname;
    public int age;
    public Date date;
    public String type;


    public Usuarios(String charge, String document, String name, String lastname, int age, Date date, String type) {
        this.charge = charge;
        this.document = document;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.date = date;
        this.type = type;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Usuarios{" +
                "charge='" + charge + '\'' +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}
