package resources;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
@SuppressWarnings("UnusedDeclaration")
public class DBParametersResource {
    private final String name;
    private final String pass;
    private final String user;

    public DBParametersResource() {
        this.name = "";
        this.pass = "";
        this.user = "";
    }

    public DBParametersResource(String name, String pass, String user) {
        this.name = name;
        this.pass = pass;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "DBParametersResource{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
