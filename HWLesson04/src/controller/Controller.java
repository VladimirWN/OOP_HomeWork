package controller;

import config.Config;
import model.data.Employee;
import model.data.Prior;
import model.data.Task;
import model.data.User;
import model.service.EmployeeServiceImpl;
import model.service.TaskService;
import view.ConsoleViewImpl;
import view.View;

import java.util.Arrays;
import java.util.List;

public class Controller {
    View view;

    public Controller() {
        this.view = new ConsoleViewImpl();
    }

    public void start() {
        TaskService<User> taskService = new TaskService<>(view, Config.path);
        while (true) {
            view.set("1 - текущие задачи; 2 - новая задача; 3 - удалить задачу");
            String key = view.get();
            switch (key) {
                case "1":
                    view.set("Всего задач: " + taskService.getCurrentTasks().size());
                    view.set(taskService.getCurrentTasks().toString());
                    break;
                case "2":
                    newTask(taskService);
                    break;
                case "3":
                    view.set(taskService.getCurrentTasks().toString());
                    view.set("Введите номер № задачи для ее удаления: ");
                    taskService.removeTask(Integer.parseInt(view.get()));
                    break;
            }
        }
    }

    public void newTask(TaskService<User> taskService) {
        view.set("Введите дату завершения задачи: ");
        String date = view.get();
        view.set("Имя пользователя, Фамилию и должность через пробел:");
        String[] s = view.getLine().split(" ");
        User user = new EmployeeServiceImpl(view).createUser(s);
        if (user == null) {
            view.set("Отмена создания.");
            return;
        }
        String temp;
        do {
            view.set("Назначьте приоритет задачи: 1 - LOW, 2 - MED, 3 - HIGH");
            temp = view.get();
        } while (!Arrays.asList("1", "2", "3").contains(temp));
        Prior prior = switch (temp) {
            case "1" -> Prior.LOW;
            case "2" -> Prior.MED;
            default -> Prior.HIGH;
        };
        taskService.createNewTask(date, user, prior);
    }
}
