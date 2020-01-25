import java.io.*;

public class Fibonacci {
    public static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    public static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vladyslav\\Desktop\\source.txt");
        File file1 = new File("C:\\Users\\Vladyslav\\Desktop\\output.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));

        String line = reader.readLine();
        int linesnumber = 0;

        while (line != null) {
            String[] s = line.split(" ");

            if (isFibonacci(Integer.parseInt(s[1]))) {
                linesnumber++; // counting number of lines which contains Fibonacci number
                writer.write(Integer.toString(linesnumber) + ' ');//write number of the line

                // after space in the same row put reverse text
                byte[] strAsByteArray = s[0].getBytes();
                byte[] result = new byte[strAsByteArray.length];
                for (int i = 0; i < strAsByteArray.length; i++) {
                    writer.write(result[i] = strAsByteArray[strAsByteArray.length - i - 1]);
                }
                // writer.write(new StringBuilder(s[0]).reverse().toString());

                writer.newLine();
            }
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
