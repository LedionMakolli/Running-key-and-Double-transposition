public class DoubleTransposition {

    // Krijimi i matrices
    private static char[][] createMatrix(String text, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        text = text.replace(" ", "");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < text.length()) {
                    char currentChar = text.charAt(index);
                    matrix[i][j] = currentChar;
                    index++;
                } else {
                    // Nese jane perfunduar karakteret, mbushe me 'X'
                    matrix[i][j] = 'X';
                }
            }
        }
        return matrix;
    }
}
