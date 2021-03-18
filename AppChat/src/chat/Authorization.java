package chat;
// Для проверки работы графического интерфейса
public class Authorization {

    private static final String NAME = "1";
    private static final String PASS = "1";
    private static boolean authorize;

    public static boolean isAuthorize() {
        return authorize;
    }

    public static void userLogIn(String name, String pass) {
        if (name.equals(NAME) && pass.equals(PASS)) authorize = true;
        else ChatPopUp.alert("Incorrect Login/Password");
    }

    public static void userLogOut() {
        authorize = false;
        ChatPopUp.alert("See You Soon...");
    }
}
