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

    // Funksioni i enkriptimit
    public static String encrypt(String plaintext, int[] rowKey, int[] colKey) {
        plaintext = plaintext.replace(" ", "").toUpperCase();
        int rows = rowKey.length;
        int cols = colKey.length;
        
        char[][] matrix = createMatrix(plaintext, rows, cols);

        // Ri-rendit rreshtat
        char[][] rowTransposed = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            rowTransposed[i] = matrix[rowKey[i]];
        }

        // Ri-rendit kolonat
        char[][] colTransposed = new char[rows][cols];
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                colTransposed[i][j] = rowTransposed[i][colKey[j]];
            }
        }

        // Nderton tekstin e enkriptuar
        StringBuilder encrypted = new StringBuilder();
        for (char[] row : colTransposed) {
            for (char c : row) {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    // Funksioni i dekriptimit
    public static String decrypt(String encryptedText, int[] rowKey, int[] colKey) {
        int rows = rowKey.length;
        int cols = colKey.length;
        char[][] matrix = createMatrix(encryptedText, rows, cols);


        //Rregullimi i kolonave
        char[][] colDeTransposed = new char[rows][cols];
        for (int j = 0; j < cols; j++) {
            int originalCol = colKey[j];
            for (int i = 0; i < rows; i++) {
                colDeTransposed[i][originalCol] = matrix[i][j];
            }
        }

        // Rregullon renditjen e rreshtave
        char[][] finalMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            int originalRow = rowKey[i];
            finalMatrix[originalRow] = colDeTransposed[i];
        }

        //Konvertimi ne tekst
        StringBuilder decrypted = new StringBuilder();
        for (char[] row : finalMatrix) {
            for (char c : row) {
                decrypted.append(c);
            }
        }

        return decrypted.toString().replaceAll("X", "");
    }
}

