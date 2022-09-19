import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {
        "code",
        "name",
        "type",
        "semester",
        "ayear",
        "year_of_study",
        "exam"
})
public class Course {
    private String code;
    private String name;
    private String type;
    private String semester;
    private String ayear;
    private int year_of_study;

    private Exam exam;


    public Course(){}

    public Course(String code, String name, String type, String semester, String ayear, int year_of_study) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.semester = semester;
        this.ayear = ayear;
        this.year_of_study = year_of_study;
    }

    public static Course addInfoAboutCourse(String[] args) {
        try
        {
            int course_Year_Of_Study = Integer.parseInt(args[6]);
            String course_Semester = args[7];
            String course_Academic_Year = args[8];
            String course_Code = args[9];
            String course_Name = args[10];
            String course_Type = args[11];
            return new Course(course_Code,course_Name,course_Type,
                    course_Semester,course_Academic_Year,course_Year_Of_Study);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Course >> NumberFormatException: " + nfe.getMessage());
        }
        return null;
    }

    @XmlElement(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlElement(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    @XmlElement(name = "ayear")
    public String getAyear() {
        return ayear;
    }

    public void setAyear(String ayear) {
        this.ayear = ayear;
    }
    @XmlElement(name = "year_of_study")
    public int getYear_of_study() {
        return year_of_study;
    }

    public void setYear_of_study(int year_of_study) {
        this.year_of_study = year_of_study;
    }
    @XmlElement(name = "exam")
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", semester='" + semester + '\'' +
                ", ayear='" + ayear + '\'' +
                ", year_of_study=" + year_of_study +
                ", exam=" + exam +
                '}';
    }
}
