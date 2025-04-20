


public class test {
 //Funksioni per testim-DoubleTranspositionDecryptor
    public static void main(String[] args) {
        System.out.println("Algoritmi Double Transposition");
        String plaintext = "HELLOWORLD";
        System.out.println("Teskti para enkriptimit: " + plaintext);

        int[] rowKey = {1, 0};
        int[] colKey = {2, 0, 1, 3, 4, 5};

        String encrypted = DoubleTransposition.encrypt(plaintext, rowKey, colKey);

        System.out.println("Teksti i enkriptuar: " + encrypted);
        String decrypted = DoubleTransposition.decrypt(encrypted, rowKey, colKey);
        System.out.println("Teksti i dekriptuar: " + decrypted);

        System.out.println("Algoritmi Running Key");
        String plaintxt = "HELLOWORLD";
        String celesi = "HELLOWORLD";
        System.out.println("Teksti para enkriptimit: " + plaintxt);

        String encrypted2 = RunningKey.Encrypt(plaintxt, celesi);
        System.out.println("Teksti i enkriptuar: " + encrypted2);

        String decrypted2 = RunningKey.Decrypt(encrypted2, celesi);
        System.out.println("Teksti i dekriptuar: " + decrypted2);
    }
    }

