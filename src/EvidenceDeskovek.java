import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceDeskovek {

    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public void pridejDeskovku(Deskovka deskovka){
        seznamDeskovek.add(deskovka);
    }
    public void odstranDeskovku(Deskovka deskovka){
        seznamDeskovek.remove(deskovka);
    }
    public int getVelikostSeznamu(){
        return seznamDeskovek.size();
    }
    public Deskovka najdiDeskovku(int index){
        return seznamDeskovek.get(index);
    }
    public int getPocetDeskovek(){
        return seznamDeskovek.size();
    }
    public void ulozDeskovkyDoSouboru(String nazevSouboru){
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nazevSouboru)))){
            for (Deskovka deskovka : seznamDeskovek) {
                pw.println(deskovka.getNazev() + ";" + deskovka.isKoupena() + ";" + deskovka.getOblibenost());
                pw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void nactiDeskovkyZeSouboru(String nazevSouboru){
        seznamDeskovek.clear();
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(nazevSouboru)))){
            while(sc.hasNextLine()){
                String[] line = sc.nextLine().split(";");
                seznamDeskovek.add(new Deskovka(line[0], line[1].equals("ano"), Integer.parseInt(line[2])));
            }
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
