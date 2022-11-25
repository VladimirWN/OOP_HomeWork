package util;

import data.Stream;

import java.util.Comparator;


public class StreamComparator implements Comparator<Stream> {

    @Override
    public int compare(Stream o1, Stream o2) {
        int i = o1.getStudyGroupList().size(), j = o2.getStudyGroupList().size();

        if (i > j)
            return 1;
        else if (i < j)
            return -1;
        else
            return 0;
    }
}
