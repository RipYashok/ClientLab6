package commands;

import commands.utils.CommandType;
import managers.utils.HashTable;
import models.FormOfEducation;
import models.StudyGroup;

import java.util.ArrayList;
import java.util.Enumeration;

public class RemoveAllByOfEducation extends Command{

    private FormOfEducation education;

    public FormOfEducation getEducation() {
        return education;
    }

    public void setEducation(FormOfEducation education) {
        this.education = education;
    }

    public RemoveAllByOfEducation(){
        setTitle("remove_all_by_form_of_education");
        setDescription("remove_all_by_form_of_education formOfEducation - удаляет из коллекции все элементы, значение поля formOfEducation которого эквивалентно заданному"
                + "\n" + "Записывайте форму обучения слудуюущим образом:" + "\n" + "Дистанционное - DISTANCE_EDUCATION"
                + "\n" + "Полный учебный день - FULL_TIME_EDUCATION" + "\n" + "Вечернее обучение - EVENING_CLASSES");
        setType(CommandType.REMOVEALLBYOFEDUCATION);
    }

    public void execute(HashTable collection, FormOfEducation form){
        Enumeration<StudyGroup> groups = collection.elements();
        Enumeration<String> keys = collection.keys();
        ArrayList<StudyGroup> allGroups = new ArrayList<>();
        ArrayList<String> allKeys = new ArrayList<>();
        while (groups.hasMoreElements() == true){
            StudyGroup group = groups.nextElement();
            allGroups.add(group);
            String key = keys.nextElement();;
            allKeys.add(key);
            if (group.getFormOfEducation().equals(form)){
                collection.remove(allKeys.get(allGroups.indexOf(group)));
            }
        }
    }
}
