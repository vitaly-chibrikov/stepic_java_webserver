package reflection;

import java.util.Arrays;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public enum Types {
    BYTE,
    BOOLEAN,
    SHORT,
    CHAR,
    INT,
    FLOAT,
    LONG,
    DOUBLE,
    OBJECT;

    private static final String ALL_TYPES_STRING = Arrays.toString(Types.values());

    public static Types getType(Class<?> clazz) {
        String className = clazz.getSimpleName().toUpperCase();
        if (ALL_TYPES_STRING.contains(className)) {
            return Types.valueOf(className);
        } else {
            return Types.OBJECT;
        }
    }
}
