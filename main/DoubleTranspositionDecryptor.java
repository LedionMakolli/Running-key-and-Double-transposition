
   //Krijimi i matrices nga teksti i enkriptuar
    private static char[][] createMatrix(String text, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        text = text.replace(" ",""); 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (index < text.length()) {
                    matrix[i][j] = text.charAt(index++);
                } else {
                    matrix[i][j] = 'X'; 
                }
            }
        }

        return matrix;
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

    //Funksioni per testim
    public static void main(String[] args) {
        String encryptedText = "LORDXXLHELOW";
        int[] rowKey = {1, 0}; 
        int[] colKey = {2, 0, 1, 3, 4, 5};

        String decrypted = decrypt(encryptedText, rowKey, colKey);
        System.out.println("Teksti i dekriptuar: " + decrypted);
    }
}


