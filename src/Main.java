import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
      /*  Xterm.clear();
        Xterm.setPosition(25,8);
        Xterm.print("С новым годом ", Xterm.Red);
        Xterm.print("(учебным)", Xterm.Blue);
        Xterm.print("!", Xterm.Red);
        Xterm.setPosition(0,16);
*/
        int a = Xterm.inputInt("Введите первое число -> ");
        int b = Xterm.inputInt("Введите второе число -> ");
        int c = Xterm.inputInt("Введите третье число -> ");
        Xterm.print("Исходные данные:    a = " + a + "; b = " + b + "; с = " + c, Xterm.White, 2);

        double result =(a+b+c);
        result = result/3;
        Xterm.print("Среднее арифметическое: " +result, Xterm.Red);
    }
}