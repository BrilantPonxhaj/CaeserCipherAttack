import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SulmiCezarit {
    public static void main(String[] args) {
        String ciphertext = "";
        try{
            ciphertext = new String (Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\IdeaProjects\\CaesarCipher\\ciphertext.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String plaintext = Dekriptimi (ciphertext);
        System.out.println("Teksti i dekriptuar: " + plaintext);
        }

    }

    public static int Kontrolli(String[] ControlWords, String CipherTextWords) {
        int celesi_final = 0;
        for (int i = 0; i < ControlWords.length; i++)
            if (ControlWords[i].length() == CipherTextWords.length()) {
                celesi_final = CipherTextWords.charAt(0) - ControlWords[i].charAt(0);
                if (ControlWords[i].equals(Mesazhi(CipherTextWords, celesi_final)))

                    return celesi_final;
            }
            return -1;
        }




        public static String Mesazhi (String Ciphertext,int celsi){
            StringBuilder tekstiDekoduar = new StringBuilder(Ciphertext);
            for (int i = 0; i < Ciphertext.length(); i++) {
                char ch = Ciphertext.charAt(i);
                if (ch >= 'A' && ch <= 'Z')
                    if (Ciphertext.charAt(i) != ' ')
                        tekstiDekoduar.setCharAt(i, (char) (((Ciphertext.charAt(i) - 'A' - celsi + 26) % 26) + 'A'));
            }

            return tekstiDekoduar.toString();
        }

    public static String textidekriptuar = "";

    public static String Dekriptimi(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();

        char[] mesazhiarray = ciphertext.toCharArray();

        String[] fjaletkyqe = {"AND", "IS"};

        String[] ciphertextsplit = ciphertext.split(" ");

        List<String> fjalet = new ArrayList<String>();
        for (int i = 0; i < ciphertextsplit.length; i++) {
            for (int j = 0; j < fjaletkyqe.length; j++) {
                if (ciphertextsplit[i].length() == fjaletkyqe[j].length()) {
                    fjalet.add(ciphertextsplit[i]);
                }
            }
        }
        String[] vargu1 = fjalet.toArray(new String[0]);

        int celesi = 0;
        for (int i = 0; i < vargu1.length; i++) {
            celesi = Kontrolli(fjaletkyqe, vargu1[i].toString());
            if (celesi != -1) {
                textidekriptuar += Mesazhi(ciphertext, celesi);
                break;
            }
        }
        return textidekriptuar;
    }
}
