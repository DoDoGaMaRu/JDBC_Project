package menu;

import io.Keypad;
import io.Screen;

public class SearchMenu {
    public static final int SHOW_SUBJECT = 1;
    public static final int SHOW_SIGNUP = 2;
    public static final int SHOW_SUBJECT_ATTENDANCE = 3;
    public static final int SHOW_SEPARATED_CLASS_ATTENDANCE = 4;
    public static final int BACK = 5;
    public static final int EXIT = 6;

    public int displaySearch(Screen screen, Keypad keypad) {
        screen.displayMessageLine( "\n\t\t 메뉴:\n" );
        screen.displayMessageLine( "\t\t1 - 개설강좌 조회" );
        screen.displayMessageLine( "\t\t2 - 수강신청 확인서 조회" );
        screen.displayMessageLine( "\t\t3 - 개설과목별 출석부 조회" );
        screen.displayMessageLine( "\t\t4 - 분반별 출석부 조회" );
        screen.displayMessageLine( "\t\t5 - 뒤로가기" );
        screen.displayMessageLine( "\t\t6 - 종료" );
        screen.displayMessage( "\t선택하세요: " );
        return keypad.getInt();
    }
}
