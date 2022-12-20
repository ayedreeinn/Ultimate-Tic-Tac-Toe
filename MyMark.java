package UltimateTTT;

public class MyMark {

    private String mark;

    // Constructor sets a mark for the player
    public MyMark(String userMark) {
        setMark(userMark);
    }
    
    // Getter
    public String getMark() {
        return mark;
    }
    
    // Setter
    private void setMark(String userMark) {
        mark = userMark;
    }
}