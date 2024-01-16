import java.util.ArrayList;
import java.util.List;

public class EvidenceDeskovek {

    private List<Deskovka> seznamDeskovek = new ArrayList<>();

    public List<Deskovka> getSeznamDeskovek() {
        return seznamDeskovek;
    }

    public void pridejDeskovku(Deskovka deskovka){
        seznamDeskovek.add(deskovka);
    }
    public void odstranDeskovku(Deskovka deskovka){
        seznamDeskovek.remove(deskovka);
    }
    public Deskovka najdiDeskovku(int index){
        return seznamDeskovek.get(index);
    }
}
