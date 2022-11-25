package data;

public class Student extends User {
    private int studentID;

    public Student(String surname, String name, String birthday, int studentID) {
        super(surname, name, birthday);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return String.format("ID студента %d: Фамилия имя %s %s, д.р.: %s.", this.studentID, this.getSurname(), this.getName(),
                this.getBirthday());
    }
}
