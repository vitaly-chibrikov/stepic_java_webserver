package main;


import resources.DBParametersResource;
import sax.ReadXMLFileSAX;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DBParametersResource resource = (DBParametersResource) ReadXMLFileSAX.readXML("./data/MySqlResource.xdb");
        System.out.println(resource);
    }
}
