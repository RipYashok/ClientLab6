package commands;

import commands.utils.CommandType;
import models.*;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InsertNull extends Command {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public InsertNull() {
        setTitle("insert");
        setDescription("insert null {element} - добавляет новый элемент с заданным целочисленным ключом в коллекцию");
        setType(CommandType.INSERTNULL);

    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void ChooseGroupName(StudyGroup group, BufferedReader reader) throws IOException {
        System.out.print(ANSI_GREEN + "Введите название группы: ");
        String name = reader.readLine();
        while (StringUtils.isBlank(name)) {
            if (name == null) {
                System.out.print("\n");
            }
            System.out.println(ANSI_RED + "Не надо оставлять группу без названия");
            System.out.print(ANSI_GREEN + "Попробуйте ещё раз:");
            name = reader.readLine();
        }
        group.setName(name);
    }
    public void ChooseCoordinates(StudyGroup group, Coordinates coordinates) {
        group.setCoordinates(coordinates);
    }
    public void ChooseCoordinateX(Coordinates coordinates, BufferedReader reader) {
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату X: ");
                String x = reader.readLine();
                while (x == null || x.isEmpty()) {
                    if (x == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Координата X это число");
                    System.out.print(ANSI_GREEN + "Введите координату X: ");
                    x = reader.readLine();
                }
                coordinates.setX(Float.parseFloat(x));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата X это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseCoordinateY(Coordinates coordinates, BufferedReader reader) {
        System.out.println(ANSI_YELLOW + "Координата Y должна быть больше -550");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату Y: ");
                Float y = Float.parseFloat(reader.readLine());
                while (y == null || y < -550) {
                    if (y == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Вы вышли за пределы возможного");
                    System.out.print(ANSI_GREEN + "Введите координату Y: ");
                    y = Float.parseFloat(reader.readLine());
                }
                coordinates.setY(y);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата Y это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseStudentCount(StudyGroup group, BufferedReader reader) {
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какое количество человек в вашей группе?: ");
                Integer count = Integer.parseInt(reader.readLine());
                while (count == null || count < 0) {
                    if (count == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Недостаточное количество человек в группе!!!");
                    System.out.print(ANSI_GREEN + "Так сколько же человек в вашей группе?: ");
                    count = Integer.parseInt(reader.readLine());
                }
                group.setStudentsCount(count);
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Запишите количество цифрами пожалуйста");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ChooseFormOfEducation(StudyGroup group, BufferedReader reader) {
        System.out.println(ANSI_YELLOW + "Если у вас дистанционное обучение, введите 0");
        System.out.println(ANSI_YELLOW + "Если у вас полный учебный день, введите 1");
        System.out.println(ANSI_YELLOW + "Если у вас вечернее обучение, введите 2");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какая форма обучения у вашей группы?: ");
                String form = reader.readLine();
                while (StringUtils.isBlank(form) || !(form.equals("0") || form.equals("1") || form.equals("2"))){
                    if (form == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Пожалуйста следуйте инструкции выше");
                    System.out.print(ANSI_GREEN + "Какая форма обучения у вашей группы?: ");
                    form = reader.readLine();
                }
                if (form.equals("0")){
                    group.setFormOfEducation(FormOfEducation.DISTANCE_EDUCATION);
                    break;
                }
                else if (form.equals("1")) {
                    group.setFormOfEducation(FormOfEducation.FULL_TIME_EDUCATION);
                    break;
                } else if (form.equals("2")) {
                    group.setFormOfEducation(FormOfEducation.EVENING_CLASSES);
                    break;
                }
            } catch (IOException e) {
            }
        }
    }
    public void ChooseSemester(StudyGroup group, BufferedReader reader){
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите номер семестра: ");
                Integer sem = Integer.parseInt(reader.readLine());
                while (sem == null || (sem < 1) || (sem > 8)) {
                    if (sem == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Вы вышли за рамки возможного");
                    System.out.print(ANSI_GREEN + "Введите номер семестра ещё раз: ");
                    sem = Integer.parseInt(reader.readLine());
                }
                switch (sem){
                    case 1: group.setSemesterEnum(Semester.FIRST);
                    break;
                    case 2: group.setSemesterEnum(Semester.SECOND);
                    break;
                    case 3: group.setSemesterEnum(Semester.THIRD);
                    break;
                    case 4: group.setSemesterEnum(Semester.FOURTH);
                    break;
                    case 5: group.setSemesterEnum(Semester.FIVETH);
                    break;
                    case 6: group.setSemesterEnum(Semester.SIXTH);
                    break;
                    case 7: group.setSemesterEnum(Semester.SEVENTH);
                    break;
                    case 8: group.setSemesterEnum(Semester.EIGHTH);
                    break;
                }
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Запишите номер семестра числом");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ChooseAdmin(StudyGroup group, Person admin){
        group.setGroupAdmin(admin);
    }
    public void ChooseAdminName(Person admin, BufferedReader reader) throws IOException {
        System.out.print(ANSI_GREEN + "Введите имя админа: ");
        String name = reader.readLine();
        while (name == null || name.isEmpty()) {
            if (name == null){
                System.out.print("\n");
            }
            System.out.println(ANSI_RED + "Не надо оставлять группу без админа");
            System.out.println(ANSI_GREEN + "Попробуйте ещё раз: ");
            name = reader.readLine();
        }
        admin.setName(name);
    }
    public void ChooseAdminPasswordID(Person admin, BufferedReader reader) {
        System.out.println(ANSI_YELLOW + "Пароль должен быть не длиннее 20 символов");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите пароль админа: ");
                String password = reader.readLine();
                while (password.length() > 20) {

                        System.out.println(ANSI_RED + "Пароль слишком длинный");
                        System.out.print(ANSI_GREEN + "Введите пароль админа: ");
                        password = reader.readLine();
                }
                admin.setPassportID(password);
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException nullPointerException){
                admin.setPassportID(null);
                break;
            }
        }
    }

    public void ChooseAdminEyeColor(Person admin, BufferedReader reader){
        System.out.println(ANSI_YELLOW + "Если у админа зеленый цвет глаз, введите 0");
        System.out.println(ANSI_YELLOW + "Если у админа черный цвет глаз, введите 1");
        System.out.println(ANSI_YELLOW + "Если у админа голубой цвет глаз, введите 2");
        System.out.println(ANSI_YELLOW + "Если у админа карий цвет глаз, введите 3");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какой цвет глаз у админа?: ");
                Integer eyeColor = Integer.parseInt(reader.readLine());
                while (eyeColor == null || eyeColor < 0 || eyeColor > 3){
                    if (eyeColor == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Пожалуйста следуйте инструкции");
                    System.out.print(ANSI_GREEN + "Какой же цвет глаз у админа?: ");
                    eyeColor = Integer.parseInt(reader.readLine());
                }
                switch (eyeColor){
                    case 0: admin.setEyeColor(Color.GREEN);
                        break;
                    case 1: admin.setEyeColor(Color.BLACK);
                        break;
                    case 2: admin.setEyeColor(Color.BLUE);
                        break;
                    case 3: admin.setEyeColor(Color.BROWN);
                        break;
                }
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException numberFormatException){
                System.out.println(ANSI_RED + "Пожалуйста используйте инструкцию!!!");
            } catch (NullPointerException nullPointerException){
                System.out.println("\n" + ANSI_RED + "Как вы это сделали??? Нельзя так!" + "\n" + ANSI_RED + "Уберите пожалуйста null");
                break;
            }
        }
    }

    public void ChooseAdminHairColor(Person admin, BufferedReader reader){
        System.out.println(ANSI_YELLOW + "Если у админа зеленый цвет волос, введите 0");
        System.out.println(ANSI_YELLOW + "Если у админа голубой цвет волос, введите 1");
        System.out.println(ANSI_YELLOW + "Если у админа светлый цвет волос, введите 2");
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Какой цвет волос у админа?: ");
                Integer hairColor = Integer.parseInt(reader.readLine());
                while (hairColor == null || hairColor < 0 || hairColor > 2){
                    if (hairColor== null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Пожалуйста следуйте инструкции");
                    System.out.print(ANSI_GREEN + "Какой же цвет волос у админа?: ");
                    hairColor = Integer.parseInt(reader.readLine());
                }
                switch (hairColor){
                    case 0: admin.setHairColor(Color.GREEN);
                        break;
                    case 1: admin.setHairColor(Color.BLUE);
                        break;
                    case 2: admin.setHairColor(Color.WHITE);
                        break;
                }
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException numberFormatException){
                System.out.println(ANSI_RED + "Пожалуйста используйте инструкцию!!!");
            }
        }
    }
    public void ChooseAdminLocation(Person admin, Location location){
        admin.setLocation(location);
    }
    public void ChooseLocationCoordinateX(Location location, BufferedReader reader){
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату X локации, где спрятался админ: ");
                String x = reader.readLine();
                while (x == null || x.isEmpty()) {
                    if (x == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Координата X это число");
                    System.out.print(ANSI_GREEN + "Введите координату X: ");
                    x = reader.readLine();
                }
                location.setX(Double.parseDouble(x));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата X это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ChooseLocationCoordinateY(Location location, BufferedReader reader){
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату Y локации, где спрятался админ: ");
                String y = reader.readLine();
                while (y == null || y.isEmpty()) {
                    if (y == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Координата Y это число");
                    System.out.print(ANSI_GREEN + "Введите координату Y: ");
                    y = reader.readLine();
                }
                location.setY(Float.parseFloat(y));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата Y это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ChooseLocationCoordinateZ(Location location, BufferedReader reader){
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "Введите координату Z локации, где спрятался админ: ");
                String z = reader.readLine();
                while (z == null || z.isEmpty()) {
                    if (z == null){
                        System.out.print("\n");
                    }
                    System.out.println(ANSI_RED + "Координата Z это число");
                    System.out.print(ANSI_GREEN + "Введите координату Z: ");
                    z = reader.readLine();
                }
                location.setZ(Long.parseLong(z));
                break;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(ANSI_RED + "Координата Z это число");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void ChooseLocationName(Location location, BufferedReader reader) throws IOException {
        System.out.print(ANSI_GREEN + "Введите имя локации, где спрятался админ: ");
        String name = reader.readLine();
        while (name == null || name.isEmpty()) {
            if (name == null){
                System.out.print("\n");
            }
            System.out.println(ANSI_RED + "Вы точно знаете, где он спрятался, не надо это скрывать");
            System.out.println(ANSI_GREEN + "Попробуйте ещё раз: ");
            name = reader.readLine();
        }
        location.setName(name);

    }

    public StudyGroup execute(BufferedReader reader) throws IOException {
        StudyGroup studyGroup = new StudyGroup();
        Coordinates coordinates = new Coordinates();
        Person admin = new Person();
        Location location = new Location();
        ChooseGroupName(studyGroup, reader);
        ChooseCoordinateX(coordinates, reader);
        ChooseCoordinateY(coordinates, reader);
        ChooseCoordinates(studyGroup, coordinates);
        ChooseStudentCount(studyGroup, reader);
        ChooseFormOfEducation(studyGroup, reader);
        ChooseSemester(studyGroup, reader);
        ChooseAdminName(admin, reader);
        ChooseAdminPasswordID(admin, reader);
        ChooseAdminEyeColor(admin, reader);
        ChooseAdminHairColor(admin, reader);
        ChooseLocationCoordinateX(location, reader);
        ChooseLocationCoordinateY(location, reader);
        ChooseLocationCoordinateZ(location, reader);
        ChooseLocationName(location, reader);
        ChooseAdminLocation(admin, location);
        ChooseAdmin(studyGroup, admin);
        return studyGroup;
    }
}