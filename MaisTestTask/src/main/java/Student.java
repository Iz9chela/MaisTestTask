import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder = {
        "student_Id",
        "name",
        "surname",
        "study"
})
public class Student {

    private String student_Id;

    private String name;

    private String surname;

    private Study study;

    public Student(){}


    public Student(String student_Id, String name, String surname) {
        this.student_Id = student_Id;
        this.name = name;
        this.surname = surname;
    }

    public static Student addNewStudent(String[] args) {
        String student_Id = args[0];
        String name = args[1];
        String surname = args[2];
        return new Student(student_Id, name, surname);
    }

    @XmlElement(name = "id")
    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement(name = "study")
    public Study getStudy() {
        return study;
    }
    public void setStudy(Study study) {
        this.study = study;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_Id=" + student_Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", study='" + study  +
                '}';
    }

}
