import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SulmiCezarit {
    public static void main(String[] args) {

    }
    public static int Kontrolli(String[] ControlWords, String CipherTextWords)
    {
        int celesi_final = 0;
        return celesi_final;
    }




    public static String Mesazhi(String Ciphertext, int celsi) {
        StringBuilder tekstiDekoduar = new StringBuilder(Ciphertext);
        for (int i = 0; i < Ciphertext.length(); i++) {
            char ch = Ciphertext.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                if (Ciphertext.charAt(i) != ' ')
                    tekstiDekoduar.setCharAt(i, (char) (((Ciphertext.charAt(i) - 'A' - celsi + 26) % 26) + 'A'));
        }

        return tekstiDekoduar.toString();
    }
}