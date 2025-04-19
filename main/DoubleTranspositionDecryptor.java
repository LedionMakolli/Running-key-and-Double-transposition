
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

