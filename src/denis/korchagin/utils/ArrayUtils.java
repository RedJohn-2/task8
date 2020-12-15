package denis.korchagin.utils;

import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class ArrayUtils {

    /**
     * Набор функций для работы с массивами
     *
     * @author Дмитрий Соломатин (кафедра ПиИТ ФКН ВГУ)
     */

    public static double[] toPrimitive(Double[] arr) {
        if (arr == null) {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toDoubleArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Double> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextDouble());
        }

        Double[] arr = list.toArray(new Double[0]);
        return ArrayUtils.toPrimitive(arr);
    }

    public static double[][] toDoubleArray2(String[] lines) {
        double[][] arr2 = new double[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toDoubleArray(lines[r]);
        }
        return arr2;
    }


    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }

    public static double[][] readDoubleArray2FromFile(String fileName) {
        try {
            return toDoubleArray2(readLinesFromFile(fileName));
        }
        catch(FileNotFoundException e) {
            return null;
        }
    }

    public static void writeArrayToFile(String fileName, boolean[][] arr) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    writer.write(arr[i][j] + " ");
                }
                writer.write('\n');
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printBooleanArray2(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
