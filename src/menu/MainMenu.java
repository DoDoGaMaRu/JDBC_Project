package menu;

import io.Keypad;
import io.Screen;

public class MainMenu {
    public static final int INSERT_SUBJECT = 1;
    public static final int MOVE_TO_SIGNUP = 2;
    public static final int MOVE_TO_SEARCH = 3;
    public static final int EXIT = 4;

    // display main menu and get user command
    public int displayMainMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t 메뉴:\n" );
        screen.displayMessageLine( "\t\t1 - 과목(개설강좌) 등록" );
        screen.displayMessageLine( "\t\t2 - 수강신청으로 이동" );
        screen.displayMessageLine( "\t\t3 - 자료조회로 이동" );
        screen.displayMessageLine( "\t\t4 - 종료" );
        screen.displayMessage( "\t선택하세요: " );
        return keypad.getInt();
    }
}
