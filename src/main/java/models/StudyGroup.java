package models;

import managers.utils.GeneratorID;
import models.utils.FormaterZonedDataTime;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class StudyGroup implements Comparable<StudyGroup>{
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле не может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup() {
        this.id = GeneratorID.newId();
        this.creationDate = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return
                "\n" + ANSI_YELLOW + "ID: " + ANSI_GREEN + Long.valueOf(id).toString() + "\n" +
                        ANSI_YELLOW + "Название: " + ANSI_GREEN + name + "\n" +
                        ANSI_YELLOW + "Координаты: " + ANSI_GREEN + coordinates.toString() + "\n" +
                        ANSI_YELLOW + "Дата создания: " + ANSI_GREEN + FormaterZonedDataTime.Formating(creationDate) + "\n" +
                        ANSI_YELLOW + "Количество студентов: " + ANSI_GREEN + Long.valueOf(studentsCount).toString() + "\n" +
                        ANSI_YELLOW + "Форма обучения: " + ANSI_GREEN + formOfEducation.toString() + "\n" +
                        ANSI_YELLOW + "Семестр: " + ANSI_GREEN + semesterEnum.toString() + "\n" +
                        ANSI_YELLOW + "Админ группы: " + groupAdmin.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyGroup that = (StudyGroup) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(studentsCount, that.studentsCount) && formOfEducation == that.formOfEducation && semesterEnum == that.semesterEnum && Objects.equals(groupAdmin, that.groupAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, studentsCount, formOfEducation, semesterEnum, groupAdmin);
    }

    @Override
    public int compareTo(StudyGroup o) {
        return Integer.compare(studentsCount, o.getStudentsCount());
    }
}

