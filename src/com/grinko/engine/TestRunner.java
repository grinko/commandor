

/*
import java.io.Console;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

*/
/**
 * Created by grinko on 18.8.15.
 *//*

public class TestRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
        Console console = System.console();
        Reader reader = console.reader();
        ArrayList<Long> timeStamps = new ArrayList<Long>();
        StringBuilder password = new StringBuilder();
        timeStamps.add(System.currentTimeMillis());
        System.out.println("Enter your 8 character password");
        for(int i = 0;i<8;i++) {
            password.append(reader.read());
            timeStamps.add(System.currentTimeMillis());
        }
        System.out.println("Timestamps: ");
        System.out.println(timeStamps);
        cmd = new String[] {"/bin/sh", "-c", "stty sane </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }
}
*/
