import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Main {
    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        System.out.println(ansi().fg(BLUE).bg(GREEN).a("选项").reset());
        System.out.println(ansi().fg(WHITE).bg(BLACK).a("1. 进入").reset());
        System.out.println(ansi().fg(BLACK).bg(WHITE).a("2. 退出").reset());
        System.out.println(ansi().fg(RED).bg(YELLOW).a("3. 警告").reset());
        AnsiConsole.systemUninstall();
    }
}
