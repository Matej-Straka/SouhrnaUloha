import javax.swing.*;

public class DeskovkaForm extends JFrame {
    private JTextField nazev;
    private JCheckBox koupeno;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JButton předchozíButton;
    private JButton uložitButton;
    private JButton dalšíButton;
    private JPanel panel;

    private int DeskovkaIndex = 0;
    private EvidenceDeskovek evidenceDeskovek;

    public DeskovkaForm(EvidenceDeskovek evidenceDeskovek) {
        this.evidenceDeskovek = evidenceDeskovek;
        setContentPane(panel);
        pack();
        setTitle("Deskové hry");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zapisUdajeOAktualniDeskovceDoOkna();
        dalšíButton.addActionListener(e -> {
            if (DeskovkaIndex < evidenceDeskovek.getVelikostSeznamu() - 1) {
                DeskovkaIndex++;
                zapisUdajeOAktualniDeskovceDoOkna();
            }
        });
        předchozíButton.addActionListener(e -> {
            if (DeskovkaIndex > 0) {
                DeskovkaIndex--;
                zapisUdajeOAktualniDeskovceDoOkna();
            }
        });
        uložitButton.addActionListener(e -> {
            if(evidenceDeskovek.getPocetDeskovek() > 0){
                Deskovka deskovka = evidenceDeskovek.najdiDeskovku(DeskovkaIndex);
                deskovka.setNazev(nazev.getText());
                deskovka.setKoupena(koupeno.isSelected());
                if (radio1.isSelected()) {
                    deskovka.setOblibenost(1);
                } else if (radio2.isSelected()) {
                    deskovka.setOblibenost(2);
                } else if (radio3.isSelected()) {
                    deskovka.setOblibenost(3);
                }
                evidenceDeskovek.ulozDeskovkyDoSouboru("deskovky.txt");
            }
        });
    }

    private void zapisUdajeOAktualniDeskovceDoOkna(){
        if(evidenceDeskovek.getPocetDeskovek() == 0){
           nazev.setText("");
           koupeno.setSelected(false);
           radio1.setSelected(true);
        } else{
        Deskovka deskovka = evidenceDeskovek.najdiDeskovku(DeskovkaIndex);
        nazev.setText(deskovka.getNazev());
        koupeno.setSelected(deskovka.isKoupena());
        switch (deskovka.getOblibenost()){
            case 1:
                radio1.setSelected(true);
                break;
            case 2:
                radio2.setSelected(true);
                break;
            case 3:
                radio3.setSelected(true);
                break;
        }
        }
    }
}