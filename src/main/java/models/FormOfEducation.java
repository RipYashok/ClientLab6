package models;

public enum FormOfEducation {
    DISTANCE_EDUCATION{
        @Override
        public String toString() { return "Дистанционное";}
    },
    FULL_TIME_EDUCATION{
        @Override
        public String toString() { return "Полный учебный день";}
    },
    EVENING_CLASSES{
        @Override
        public String toString() { return "Вечернее обучение";};
    };
}
