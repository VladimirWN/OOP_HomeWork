package service;

import data.StudyGroup;

import java.util.logging.Logger;

public class Controller {
    static Logger logger = Logger.getAnonymousLogger();

    public void controllerStart() {
        StudyGroupService studyGroupService = new StudyGroupService();

        logger.info("Всего групп: " + StudyGroup.getNumber());
        logger.info("Создана группа:" + studyGroupService.readAndCreateGroup("studyGroup1.txt").toString());
        logger.info("Создана группа:" + studyGroupService.readAndCreateGroup("studyGroup2.txt").toString());
        logger.info("Всего групп: " + StudyGroup.getNumber());
    }
}
