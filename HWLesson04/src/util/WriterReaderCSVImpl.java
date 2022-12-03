package util;

import model.data.Employee;
import model.data.Task;
import model.data.User;

import java.io.*;
import java.util.List;


public class WriterReaderCSVImpl implements WriterReader {


    @Override
    public void updateDB(String path, List<Task<? extends User>> data) {
        File file = new File(path);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (Task<? extends User> item :
                    data) {
                StringBuilder sb = new StringBuilder();
                Employee currEmployee = (Employee) item.getUser();
                sb.append(item.getTaskID()).append("\t")
                        .append(item.getStartDateTIme()).append("\t")
                        .append(item.getFinishDate()).append("\t")
                        .append(currEmployee.getFirstName()).append("\t")
                        .append(currEmployee.getLastName()).append("\t")
                        .append(currEmployee.getJobTitle()).append("\t")
                        .append(item.getPrior()).append("\n");
                printWriter.write(sb.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine()).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
