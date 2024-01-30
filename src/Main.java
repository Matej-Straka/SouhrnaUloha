import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EvidenceDeskovek evidenceDeskovek = new EvidenceDeskovek();
        evidenceDeskovek.nactiDeskovkyZeSouboru("deskovky.txt");
        DeskovkaForm deskovka = new DeskovkaForm(evidenceDeskovek);
        deskovka.setVisible(true);
    }
}