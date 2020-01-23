import java.io.*;

// Класс, обеспечивающий вывод строк текста с возможностью
// позиционирования и использования цветов, а также ввод чисел
// целых типов int и long и вещественных float и double.
public class Xterm {

    private static final DataInputStream in =
            new DataInputStream(System.in);
    private static final int MAXLEN = 255;
    private static String inputString() throws IOException {
        byte buf[] = new byte[MAXLEN];
        int i = in.read(buf);
        return new String(buf,0,i-1);
    }

    // Имена цветов символов и фона
    public static final int Black   = 0;
    public static final int Red     = 1;
    public static final int Green   = 2;
    public static final int Yellow  = 3;
    public static final int Blue    = 4;
    public static final int Magenta = 5;
    public static final int Cyan    = 6;
    public static final int White   = 7;

    // Метод очистки экрана
    public static void clear() {
        System.out.print("\033[2J");
    }

    // Метод позиционирования курсора
    public static void setPosition(int x, int y) {
        System.out.print("\033[" + (y+1) + ";" + (x+1) + "H");
    }

    // Методы вывода строки
    public static void print(String txt) {
        System.out.print("\033[0m\033[30;1m"+txt+"\033[0m\033[30m");
    }
    public static void print(String txt, int fg) {
        System.out.print("\033[0m\033[" + (30+fg)
                +";1m" + txt + "\033[0m\033[30m");
    }
    public static void print(String txt, int fg, int bg) {
        System.out.print("\033[0m\033["+(bg==7?"":""+(40+bg)+";")+
                (30+fg)+";1m" + txt + "\033[0m\033[30m");
    }

    public static void println(String txt) {
        print(txt + "\n");
    }
    public static void println(String txt, int fg) {
        print(txt + "\n");
    }
    public static void println(String txt, int fg, int bg) {
        print(txt + "\n");
    }

    // Методы ввода чисел типов int, long, float, double
    public static int inputInt() throws IOException,
            NumberFormatException {
        return Integer.valueOf(inputString()).intValue();
    }
    public static int inputInt(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputInt();
    }

    public static long inputLong() throws IOException,
            NumberFormatException {
        return Long.valueOf(inputString()).longValue();
    }
    public static long inputLong(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputLong();
    }

    public static float inputFloat() throws IOException,
            NumberFormatException {
        return Float.valueOf(inputString()).floatValue();
    }
    public static float inputFloat(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputFloat();
    }

    public static double inputDouble() throws IOException,
            NumberFormatException {
        return Double.valueOf(inputString()).doubleValue();
    }
    public static double inputDouble(String prompt)
            throws IOException, NumberFormatException {
        print(prompt); return inputDouble();
    }
    // Методы ввода строки, рассматриваемой как массив символов.
    public static char[] inputChars() throws IOException {
        return (inputString()).toCharArray();
    }
    public static char[] inputChars(String prompt)
            throws IOException {
        print(prompt);
        return (inputString()).toCharArray();
    }
}