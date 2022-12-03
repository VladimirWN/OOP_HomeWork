package util;

import model.data.Task;
import model.data.User;

import java.util.List;

public interface WriterReader {
    public void updateDB(String path, List<Task<? extends User>> data);

    public String read(String path);
}
