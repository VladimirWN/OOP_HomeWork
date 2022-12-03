package model.service;

import config.Config;
import model.data.Employee;
import model.data.Prior;
import model.data.Task;
import model.data.User;
import util.WriterReaderCSVImpl;
import view.View;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskService<T extends User> {
    private View view;
    private List<Task<? extends User>> currentTasks;

    public TaskService(View view, String path) {
        this.view = view;
        currentTasks = new ArrayList<>();

        WriterReaderCSVImpl wr = new WriterReaderCSVImpl();
        String[] temp = wr.read(path).split("\n");
        if (temp.length != 1) {
            for (String item :
                    temp) {
                String[] param = item.split("\t");
                int taskID = Integer.parseInt(param[0]);
                Prior prior = switch (param[6]) {
                    case "MED" -> Prior.MED;
                    case "HIGH" -> Prior.HIGH;
                    default -> Prior.LOW;
                };
                currentTasks.add(new Task<>(taskID, prior, param[1], param[2], new Employee(param[3],
                        param[4], param[5])));
                if (Task.getNumberOfID() < taskID) {
                    Task.setNumberOfID(taskID);
                }
            }
        }
    }

    public void createNewTask(String finishDate, T user, Prior prior) {
        StringBuilder sb = new StringBuilder();
        String temp = String.valueOf(LocalDateTime.now());
        sb.append(temp.subSequence(0, 10)).append(" ").append(temp.subSequence(11, 16));
        Task<T> task = new Task<>(Task.newID(), prior, sb.toString(), finishDate, user);
        this.currentTasks.add(task);
        view.set("Новая задача." + task);

        WriterReaderCSVImpl wr = new WriterReaderCSVImpl();
        wr.updateDB(Config.path, this.currentTasks);
    }

    public boolean removeTask(int id) {
        WriterReaderCSVImpl wr = new WriterReaderCSVImpl();
        for (Task<? extends User> task :
                this.currentTasks) {
            if (task.getTaskID() == id) {
                this.currentTasks.remove(task);
                wr.updateDB(Config.path, this.currentTasks);
                return true;
            }
        }
        return false;
    }

    public List<Task<? extends User>> getCurrentTasks() {
        return currentTasks;
    }
}
