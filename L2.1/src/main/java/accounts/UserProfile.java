package accounts;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UserProfile {
    private final String name;
    private final String pass;
    private final String email;

    public UserProfile(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public UserProfile(String name) {
        this.name = name;
        this.pass = name;
        this.email = name;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
}
