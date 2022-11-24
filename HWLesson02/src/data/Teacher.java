package data;

public class Teacher extends User {
    private int teacherID;
    private String discipline;

    public Teacher(String surname, String name, String birthday, int teacherID, String discipline) {
        super(surname, name, birthday);
        this.teacherID = teacherID;
        this.discipline = discipline;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return String.format("ID учителя %d: Фамилия имя %s %s, Д.Р.: %s,  дисциплина - %s.", this.getTeacherID(),
                this.getSurname(), this.getName(), this.getBirthday(), this.getDiscipline());
    }
}
