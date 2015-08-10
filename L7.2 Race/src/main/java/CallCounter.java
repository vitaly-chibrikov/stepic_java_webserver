/**
 * @author v.chibrikov
 */
public class CallCounter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
