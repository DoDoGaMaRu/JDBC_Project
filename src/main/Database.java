package main;

import database.DAO;
import database.Transaction;
import io.Keypad;
import io.Screen;
import menu.MainMenu;
import menu.SearchMenu;
import menu.SignupMenu;

public class Database {
    private Keypad keypad;
    private Screen screen;
    private MainMenu mainMenu;
    private SignupMenu signupMenu;
    private SearchMenu searchMenu;
    private Transaction transaction;


    public Database(DAO dao) {
        keypad = new Keypad();
        screen = new Screen();
        mainMenu = new MainMenu();
        signupMenu = new SignupMenu();
        searchMenu = new SearchMenu();
        transaction = new Transaction(dao);
    }


    public void run() {
        boolean userExited = false;
        while ( !userExited ) {
            int command = mainMenu.displayMainMenu(screen, keypad);
            switch ( command ) {
                case MainMenu.INSERT_SUBJECT:
                    insertSubject();
                    break;
                case MainMenu.MOVE_TO_SIGNUP:
                    sighUpMenu();
                    break;
                case MainMenu.MOVE_TO_SEARCH:
                    searchMenu();
                    break;
                case MainMenu.EXIT:
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }

    public void sighUpMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = signupMenu.displaySignupMenu(screen, keypad);
            switch ( command ) {
                case SignupMenu.SIGNUP:
                    insertSignUp();
                    break;
                case SignupMenu.UPDATE_SIGNUP:
                    updateSignUp();
                    break;
                case SignupMenu.BACK:
                    userExited = true;
                    break;
                case SignupMenu.EXIT:
                    System.exit(0);
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }

    public void searchMenu() {
        boolean userExited = false;

        while ( !userExited ) {
            int command = searchMenu.displaySearch(screen, keypad);
            switch ( command ) {
                case SearchMenu.SHOW_SUBJECT:
                    showSubject();
                    break;
                case SearchMenu.SHOW_SIGNUP:
                    showSignUp();
                    break;
                case SearchMenu.SHOW_SUBJECT_ATTENDANCE:
                    showSubjectAttendance();
                    break;
                case SearchMenu.SHOW_SEPARATED_CLASS_ATTENDANCE:
                    showSeparatedClassAttendance();
                    break;
                case SearchMenu.BACK:
                    userExited = true;
                    break;
                case SearchMenu.EXIT:
                    System.exit(0);
                    break;
                default:
                    screen.displayMessageLine(Message.ERR_CHOICE);
                    break;
            }
        }
    }



    public void insertSubject() {
        int sbjId;
        String sbjName;
        int scId;

        screen.displayMessage(Message.INPUT_SUBJECT_NUMBER);
        sbjId = keypad.getInt();
        screen.displayMessage(Message.INPUT_SUBJECT_NAME);
        sbjName = keypad.getString();
        screen.displayMessage(Message.INPUT_DIVIDE_CLASS_NUMBER);
        scId = keypad.getInt();

        if (transaction.insertSubject(sbjId, sbjName, scId)) {
            screen.displayMessageLine(Message.OPEN_SUCCESS);
        }
        else {
            screen.displayMessageLine(Message.OPEN_FAIL);
        }
    }

    public void insertSignUp() {
        int stdId;
        int scId;
        int sbjId;
        String grade;

        screen.displayMessage(Message.INPUT_STUDENT_ID);
        stdId = keypad.getInt();
        screen.displayMessage(Message.INPUT_SUBJECT_NUMBER);
        sbjId = keypad.getInt();
        screen.displayMessage(Message.INPUT_DIVIDE_CLASS_NUMBER);
        scId = keypad.getInt();
        screen.displayMessage(Message.INPUT_GRADE);
        grade = keypad.getString();

        if (transaction.insertSignUp(stdId, scId, sbjId, grade)) {
            screen.displayMessageLine(Message.SUCCESS_SIGN_UP);
        }
        else {
            screen.displayMessageLine(Message.FAIL_SIGN_UP);
        }
    }

    public void updateSignUp() {
        int stdId;
        int newScId;
        int newSbjId;
        int oldSbjId;

        screen.displayMessage(Message.INPUT_STUDENT_ID);
        stdId = keypad.getInt();
        screen.displayMessage(Message.INPUT_OLD_SUBJECT_NUMBER);
        oldSbjId = keypad.getInt();
        screen.displayMessage(Message.INPUT_NEW_SUBJECT_NUMBER);
        newSbjId = keypad.getInt();
        screen.displayMessage(Message.INPUT_DIVIDE_CLASS_NUMBER);
        newScId = keypad.getInt();

        transaction.updateSignUp(stdId, newScId, newSbjId, oldSbjId);
        screen.displayMessageLine(Message.CHANGE_SUCCESS);
    }



    public void showSubject() {
        screen.displayMessage(transaction.showSubject());
    }

    public void showSignUp() {
        screen.displayMessage(Message.INPUT_STUDENT_ID);
        screen.displayMessage(transaction.showSignUp(keypad.getInt()));
    }

    public void showSubjectAttendance() {
        screen.displayMessage(Message.INPUT_SUBJECT_NUMBER);
        screen.displayMessage(transaction.showSubjectAttendance(keypad.getInt()));
    }

    public void showSeparatedClassAttendance() {
        screen.displayMessage(Message.INPUT_SUBJECT_NUMBER);
        int sbjId = keypad.getInt();
        screen.displayMessage(Message.INPUT_DIVIDE_CLASS_NUMBER);
        int scId = keypad.getInt();

        screen.displayMessage((transaction.showDistributionAttendance(sbjId, scId)));
    }
}
