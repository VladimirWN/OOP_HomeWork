package service;

import data.Student;
import data.StudyGroup;
import data.Teacher;
import util.ReaderFromTxt;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupServiceImpl implements DataService {
    private StudyGroup studyGroup;


    public StudyGroupServiceImpl(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public StudyGroupServiceImpl() {
        this.studyGroup = new StudyGroup(false);
    }

    @Override
    public void readAndCreateGroup(String file) {
        ReaderFromTxt readerFromTxt = new ReaderFromTxt();
        String[] group = readerFromTxt.getGroup(file).split("\n");

        List<Student> studentList = new ArrayList<>();
        StudyGroup studyGroup = new StudyGroup();
        for (String item :
                group) {
            String[] current = item.split(" ");
            if (current[0].equals("Teacher")) {
                studyGroup.setTeacher(new Teacher(current[1], current[2], current[3], Integer.parseInt(current[4]), current[5]));
            } else if (current[0].equals("Student")) {
                studentList.add(new Student(current[1], current[2], current[3], Integer.parseInt(current[4])));
            }
        }
        studyGroup.setStudentList(studentList);
        this.studyGroup = studyGroup;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public void addStudentToList(Student student) {
        this.studyGroup.getStudentList().add(student);
    }

    public void removeStudentFromList(Student student) {
        for (Student result :
                this.studyGroup.getStudentList()) {
            if (result.getStudentID() == student.getStudentID()) {
                this.studyGroup.getStudentList().remove(student);
                break;
            }
        }
    }
}
