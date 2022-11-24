package data;

import java.util.List;

public class StudyGroup {
    static int number = 0;
    private Teacher teacher;
    private List<Student> studentList;
    private int groupNumber;

    public StudyGroup(Teacher teacher, List<Student> studentList) {
        this.teacher = teacher;
        this.studentList = studentList;
        number++;
        this.groupNumber = number;
    }

    public StudyGroup() {
        this.groupNumber = ++number;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudentToList(Student student) {
        this.studentList.add(student);
    }

    public void removeStudentFromList(Student student) {
        for (Student result :
                this.studentList) {
            if (result.getStudentID() == student.getStudentID()) {
                this.studentList.remove(student);
                break;
            }
        }
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        StudyGroup.number = number;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return String.format("Группа №%d: %s %s", this.groupNumber, this.teacher.toString(), this.studentList);
    }
}
