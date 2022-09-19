import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
@XmlType(propOrder = {
        "exam_Result",
        "exam_Date",
        "exam_Teachers",
        "exam_Grade",
        "exam_Credits_Registered",
        "exam_Credits_Obtained"
})
public class Exam {
    private String exam_Result;
    private String exam_Date;
    private String exam_Teachers;
    private double exam_Grade;
    private int exam_Credits_Registered;
    private int exam_Credits_Obtained;

    public Exam(){}

    public Exam(String exam_Result, String exam_Date, String exam_Teachers, double exam_Grade,
                int exam_Credits_Registered, int exam_Credits_Obtained) {
        this.exam_Result = exam_Result;
        this.exam_Date = exam_Date;
        this.exam_Teachers = exam_Teachers;
        this.exam_Grade = exam_Grade;
        this.exam_Credits_Registered = exam_Credits_Registered;
        this.exam_Credits_Obtained = exam_Credits_Obtained;
    }

    public static Exam addInfoAboutExam(String[] args) {
        try
        {
            String exam_Result = args[12];
            String exam_date = isDate(args[15]);
            String exam_teachers = args[16];
            double exam_Grade = Double.parseDouble(args[23].replace(',','.'));
            int exam_Credits_Registered = Integer.parseInt(args[26]);
            int exam_Credits_Obtained = Integer.parseInt(args[27]);
            return new Exam(exam_Result,exam_date,exam_teachers,
                    exam_Grade,exam_Credits_Registered,exam_Credits_Obtained);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Exam >> NumberFormatException: " + nfe.getMessage());
        }
        return null;
    }

    private static String isDate(String str) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        String strDate;
        try {
            date = dateFormatter.parse(str);
            strDate = dateFormatter.format(date);;
            return strDate;
        } catch (ParseException e) {
            System.out.println("Exam >> DateParseException: " + e.getMessage());
        }
        return null;
    }

    @XmlElement(name = "result")
    public String getExam_Result() {
        return exam_Result;
    }

    public void setExam_Result(String exam_Result) {
        this.exam_Result = exam_Result;
    }
    @XmlElement(name = "date")
    public String getExam_Date() {
        return exam_Date;
    }

    public void setExam_Date(String exam_Date) {
        this.exam_Date = exam_Date;
    }
    @XmlElement(name = "teacher")
    public String getExam_Teachers() {
        return exam_Teachers;
    }

    public void setExam_Teachers(String exam_Teachers) {
        this.exam_Teachers = exam_Teachers;
    }
    @XmlElement(name = "grade")
    public double getExam_Grade() {
        return exam_Grade;
    }

    public void setExam_Grade(double exam_Grade) {
        this.exam_Grade = exam_Grade;
    }
    @XmlElement(name = "credits_reg")
    public int getExam_Credits_Registered() {
        return exam_Credits_Registered;
    }

    public void setExam_Credits_Registered(int exam_Credits_Registered) {
        this.exam_Credits_Registered = exam_Credits_Registered;
    }
    @XmlElement(name = "credits_obt")
    public int getExam_Credits_Obtained() {
        return exam_Credits_Obtained;
    }

    public void setExam_Credits_Obtained(int exam_Credits_Obtained) {
        this.exam_Credits_Obtained = exam_Credits_Obtained;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_Result='" + exam_Result + '\'' +
                ", exam_Date='" + exam_Date + '\'' +
                ", exam_Teachers='" + exam_Teachers + '\'' +
                ", exam_Grade=" + exam_Grade +
                ", exam_Credits_Registered=" + exam_Credits_Registered +
                ", exam_Credits_Obtained=" + exam_Credits_Obtained +
                '}';
    }
}
