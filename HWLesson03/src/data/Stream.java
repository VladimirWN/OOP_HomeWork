package data;

import data.StudyGroup;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudyGroup> {

    private List<StudyGroup> studyGroupList;

    @Override
    public Iterator<StudyGroup> iterator() {
        Iterator<StudyGroup> iterator = new Iterator<StudyGroup>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < studyGroupList.size();
            }

            @Override
            public StudyGroup next() {
                return studyGroupList.get(index++);
            }
        };
        return iterator;
    }

    public Stream(List<StudyGroup> studyGroupList) {
        this.studyGroupList = studyGroupList;
    }

    public List<StudyGroup> getStudyGroupList() {
        return studyGroupList;
    }

    public void setStudyGroupList(List<StudyGroup> studyGroupList) {
        this.studyGroupList = studyGroupList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Группы в потоке: ");
        for (StudyGroup group :
                this.studyGroupList) {
            sb.append(group.getGroupNumber()).append(" ");
        }
        return sb.toString();
    }
}
