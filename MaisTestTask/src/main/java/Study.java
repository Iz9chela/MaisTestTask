import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {
        "study_Id",
        "field_Code",
        "field",
        "course"
})
public class Study {

    private String study_Id;

    private int field_Code;

    private String field;

    private Course course;



    //Total_grade end
    public Study() {
    }
    public Study(String study_Id, int field_Code, String field) {
        this.study_Id = study_Id;
        this.field_Code = field_Code;
        this.field = field;
    }

    public static Study addInfoAboutStudy(String[] args) {
        try
        {
            String study_Id = args[3];
            int field_Code = Integer.parseInt(args[4]);
            String field = args[5];

            return new Study(study_Id,field_Code,field);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Study >> NumberFormatException: " + nfe.getMessage());
        }
        return null;
    }

    @XmlElement(name = "id")
    public String getStudy_Id() {
        return study_Id;
    }

    public void setStudy_Id(String study_Id) {
        this.study_Id = study_Id;
    }

    @XmlElement(name = "field_code")
    public int getField_Code() {
        return field_Code;
    }

    public void setField_Code(int field_Code) {
        this.field_Code = field_Code;
    }

    @XmlElement(name = "field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @XmlElement(name = "course")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Study{" +
                "study_Id='" + study_Id + '\'' +
                ", field_Code=" + field_Code +
                ", field='" + field + '\'' +
                ", course=" + course +
                '}';
    }


}
