public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");

        studentDAO.save(student);

        List<Student> students = studentDAO.getAllStudents();
        for (Student s : students) {
            System.out.println("Student: " + s.getFirstName() + " " + s.getLastName());
        }

        ((ConfigurableApplicationContext) context).close();
    }
}