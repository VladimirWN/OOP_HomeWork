package model.data;

public class Task<T extends User> {
    private static int numberOfID;
    private int taskID;
    private Prior prior;
    private String startDateTIme;
    private String finishDate;
    private T user;

    public Task(int taskID, Prior prior, String startDateTIme, String finishDate, T user) {
        this.taskID = taskID;
        this.prior = prior;
        this.startDateTIme = startDateTIme;
        this.finishDate = finishDate;
        this.user = user;
    }

    public static int newID() {
        return ++numberOfID;
    }


    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public static int getNumberOfID() {
        return numberOfID;
    }

    public static void setNumberOfID(int numberOfID) {
        Task.numberOfID = numberOfID;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getStartDateTIme() {
        return startDateTIme;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public T getUser() {
        return user;
    }

    public Prior getPrior() {
        return prior;
    }

    public void setPrior(Prior prior) {
        this.prior = prior;
    }

    @Override
    public String toString() {
        return String.format("Задача №%d. Дата/время старта %s, дата финиша %s. Приоритет: %s.| Инициатор: %s",
                this.taskID, this.startDateTIme, this.finishDate, this.prior, this.user);
    }
}
