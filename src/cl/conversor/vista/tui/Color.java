package cl.conversor.vista.tui;

public enum Color {
    RESET       ("\u001B[0m"),
    BLACK       ("\u001B[30m"),
    RED         ("\u001B[31m"),
    GREEN       ("\u001B[32m"),
    YELLOW      ("\u001B[33m"),
    BLUE        ("\u001B[34m"),
    PURPLE      ("\u001B[35m"),
    CYAN        ("\u001B[36m"),
    WHITE       ("\u001B[37m"),
    BLACK_BKG   ("\u001B[40m"),
    RED_BKG     ("\u001B[41m"),
    GREEN_BKG   ("\u001B[42m"),
    YELLOW_BKG  ("\u001B[43m"),
    BLUE_BKG    ("\u001B[44m"),
    PURPLE_BCG  ("\u001B[45m"),
    CYAN_BKG    ("\u001B[46m"),
    WHITE_BKG   ("\u001B[47m");

    
    private final String code;
    Color(String code) {
        this.code = code;
    }
    
    public final String code() {
        return this.code;
    }
}
