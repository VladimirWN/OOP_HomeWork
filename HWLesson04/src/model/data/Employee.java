package model.data;

public class Employee extends User {
    private String jobTitle;

    public Employee(String firstName, String lastName, String jobTitle) {
        super(firstName, lastName);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return String.format("Employee %s %s, %s.\n", super.getFirstName(), super.getLastName(), this.getJobTitle());
    }
}
