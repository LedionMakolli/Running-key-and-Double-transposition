


public class test {
 //Funksioni per testim-DoubleTranspositionDecryptor
    public static void main(String[] args) {
        String encryptedText = "LORDXXLHELOW";
        int[] rowKey = {1, 0}; 
        int[] colKey = {2, 0, 1, 3, 4, 5};

        String decrypted = decrypt(encryptedText, rowKey, colKey);
        System.out.println("Teksti i dekriptuar: " + decrypted);
    }
    }

