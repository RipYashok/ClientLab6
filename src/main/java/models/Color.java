package models;

public enum Color {
    GREEN{
        @Override
        public String toString() { return "Зеленый";}
    },
    BLUE{
        @Override
        public String toString() { return "Голубой";}
    },
    WHITE{
        @Override
        public String toString() { return "Светлый";}
    },
    BLACK{
        @Override
        public String toString() { return "Черный";}
    },
    BROWN{
        @Override
        public String toString() { return "Карий";}
    };
}
