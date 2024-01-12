public class Student {
    private String studentName;
    private int studentId;

    public Student(int id, String name) {
        studentId = id;
        studentName = name;
    }

    public int getStudentId() {
        return this.studentId;
    }

}
