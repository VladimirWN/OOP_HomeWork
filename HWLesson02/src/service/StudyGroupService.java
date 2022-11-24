package service;

import data.*;
import util.ReaderFromTxt;
import java.util.ArrayList;
import java.util.List;

public class StudyGroupService implements DataService {

    @Override
    public StudyGroup readAndCreateGroup(String file) {
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
        return studyGroup;
    }
}
