package models;

public enum Semester {
    FIRST{
        @Override
        public String toString() { return "Первый";}
    },
    SECOND{
        @Override
        public String toString() { return "Второй";}
    },
    THIRD{
        @Override
        public String toString() { return "Третий";}
    },
    FOURTH{
        @Override
        public String toString() { return "Четвертый";}
    },
    FIVETH{
        @Override
        public String toString() { return "Пятый";}
    },
    SIXTH{
        @Override
        public String toString() { return "Шестой";}
    },
    SEVENTH{
        @Override
        public String toString() { return "Седьмой";}
    },
    EIGHTH{
        @Override
        public String toString() { return "Восьмой";}
    };
}

