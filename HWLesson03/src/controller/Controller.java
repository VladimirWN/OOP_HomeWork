package controller;

import data.Stream;
import data.StudyGroup;
import service.StreamService;
import service.StudyGroupServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Controller {
    static Logger logger = Logger.getAnonymousLogger();

    public void controllerStart() {
        StudyGroupServiceImpl studyGroupService = new StudyGroupServiceImpl();
        logger.info("Всего групп: " + StudyGroup.getNumber());
        StudyGroup group1 = readAndCreateGroup("studyGroup1.txt", studyGroupService);
        StudyGroup group2 = readAndCreateGroup("studyGroup2.txt", studyGroupService);
        StudyGroup group3 = readAndCreateGroup("studyGroup3.txt", studyGroupService);
        StudyGroup group4 = readAndCreateGroup("studyGroup4.txt", studyGroupService);
        StudyGroup group5 = readAndCreateGroup("studyGroup5.txt", studyGroupService);
        logger.info("Всего групп: " + StudyGroup.getNumber());

        List<StudyGroup> groupList1 = new ArrayList<>(Arrays.asList(group1, group2, group3));
        List<StudyGroup> groupList2 = new ArrayList<>(Arrays.asList(group4, group5));

        Stream stream1 = new Stream(groupList1);
        for (StudyGroup group :
                stream1) {
            logger.info("TEST For each -> stream1: " + group.toString());
        }
        Stream stream2 = new Stream(groupList2);

        logger.info(String.format("В первом потоке %d групп, во втором - %d групп", stream1.getStudyGroupList().size(),
                stream2.getStudyGroupList().size()));

        List<Stream> streamList = new ArrayList<>(Arrays.asList(stream1, stream2));
        logger.info("Изначальный список потоков:\n" + streamList.get(0) + "\n" + streamList.get(1));
        StreamService streamService = new StreamService();
        streamService.sortStreamList(streamList);
        logger.info("Отсортированный список потоков:\n" + streamList.get(0) + "\n" + streamList.get(1));

    }

    public StudyGroup readAndCreateGroup(String file, StudyGroupServiceImpl studyGroupService) {
        studyGroupService.readAndCreateGroup(file);
        StudyGroup group = studyGroupService.getStudyGroup();
        logger.info("Создана группа:" + group.toString());
        return group;
    }
}
