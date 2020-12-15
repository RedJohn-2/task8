package denis.korchagin;

import denis.korchagin.utils.ArrayUtils;

public class Main {

    public static void main(String[] args) {
        InputArgs inputArgs = new InputArgs(args[0], args[1]);
        double[][] matrix = ArrayUtils.readDoubleArray2FromFile(inputArgs.getInputFile());
        ArrayUtils.writeArrayToFile(inputArgs.getOutputFile(), createMatrixWithSaddlePoints(matrix));
        ArrayUtils.printBooleanArray2(createMatrixWithSaddlePoints(matrix));
    }

    static boolean[][] createMatrixWithSaddlePoints(double[][] matrix) {
        boolean[][] matrixWithSaddlePoints = new boolean[matrix.length][];
        for (int i = 0; i < matrixWithSaddlePoints.length; i++) {
            matrixWithSaddlePoints[i] = new boolean[matrix[i].length];
            for (int j = 0; j < matrixWithSaddlePoints[i].length; j++) {
                matrixWithSaddlePoints[i][j] = isSaddlePoint(matrix, i, j);
            }
        }
        return matrixWithSaddlePoints;
    }

    static boolean isSaddlePoint(double[][] matrix, int i, int j) {
        return (isMaxInRow(matrix, i, j) && isMinInColumn(matrix, i, j)) ||
                (isMinInRow(matrix, i, j) && isMaxInColumn(matrix, i, j));
    }

    static boolean isMaxInRow(double[][] matrix, int i, int j) {
        for (int s = 0; s < matrix[i].length; s++) {
            if (matrix[i][j] < matrix[i][s]) return false;
        }
        return true;
    }

    static boolean isMinInRow(double[][] matrix, int i, int j) {
        for (int s = 0; s < matrix[i].length; s++) {
            if (matrix[i][j] > matrix[i][s]) return false;
        }
        return true;
    }

    static boolean isMaxInColumn(double[][] matrix, int i, int j) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[i][j] < matrix[r][j]) return false;
        }
        return true;
    }

    static boolean isMinInColumn(double[][] matrix, int i, int j) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[i][j] > matrix[r][j]) return false;
        }
        return true;
    }
}
