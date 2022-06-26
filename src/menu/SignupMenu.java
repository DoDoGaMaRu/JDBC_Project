package menu;

import io.Keypad;
import io.Screen;

public class SignupMenu {
    public static final int SIGNUP = 1;
    public static final int UPDATE_SIGNUP = 2;
    public static final int BACK = 3;
    public static final int EXIT = 4;

    public int displaySignupMenu(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t 메뉴:\n" );
        screen.displayMessageLine( "\t\t1 - 수강신청" );
        screen.displayMessageLine( "\t\t2 - 수강신청 변경" );
        screen.displayMessageLine( "\t\t3 - 뒤로가기" );
        screen.displayMessage( "\t선택하세요: " );
        return keypad.getInt();
    }
}
