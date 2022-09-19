import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        List<Student> studentList = readFromFile("src/main/resources/input.csv");
        ZipOutputStream zos = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            zos = new ZipOutputStream(new FileOutputStream("ResultList.zip"));
            ZipEntry zipEntry = null;
            for (Student s : studentList) {
                Integer value = map.get(s.getStudent_Id());
                String filename;
                if (value == null) {
                    map.put(s.getStudent_Id(), 1);
                    filename = s.getStudent_Id();
                } else {
                    map.put(s.getStudent_Id(), value + 1);
                    filename = s.getStudent_Id() + '(' + value + ')';
                }
                String data = convertObjectToXML(s);
                zipEntry = new ZipEntry(filename + ".xml");
                zos.putNextEntry(zipEntry);
                zos.write(data.getBytes(), 0, data.getBytes().length);
                zos.flush();
            }
        } finally {
            if (zos != null) {
                zos.close();
            }
        }
    }

    private static List<Student> readFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        int counter = 0;
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                counter++;
                if (counter == 1) {
                    continue;
                }
                String[] attributes = line.split(";");
                Student student = Student.addNewStudent(attributes);
                Study study = Study.addInfoAboutStudy(attributes);
                Course course = Course.addInfoAboutCourse(attributes);
                Exam exam = Exam.addInfoAboutExam(attributes);

                course.setExam(exam);
                study.setCourse(course);
                student.setStudy(study);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private static String convertObjectToXML(Student student) throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();


        m.marshal(student, sw);
        //Show xml
//        System.out.println(sw.toString());
        return sw.toString();
        // Write to File
//        m.marshal(student, new File(student.getStudent_Id() + ".xml"));
    }
}