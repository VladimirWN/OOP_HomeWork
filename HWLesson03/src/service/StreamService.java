package service;

import data.Stream;
import util.StreamComparator;

import java.util.List;

public class StreamService {

    public void sortStreamList(List<Stream> streamList) {
        streamList.sort(new StreamComparator());
    }
}
