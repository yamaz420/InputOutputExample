import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainprog {
    public static void main(String[] args) {
       JOptionPane.showMessageDialog(null, "hej");

        int svar = JOptionPane.showConfirmDialog(null, "Är du över 20 år gammal?", "Ålder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (svar == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Du är över 20 år.. fett gammal gubbe");
        }else {
            JOptionPane.showMessageDialog(null, "Du är under 20 år.. liten pojkvasker");
        }
        if (JOptionPane.showConfirmDialog(null, "Kommer du välja 'yes' ?", "Ålder", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        JOptionPane.showMessageDialog(null, "du ha valt 'yes'");

        FileInput();
        FileChooserInput();
    }
    public static void ScannerInput(){
      //  Scanner scanner = new Scanner();
    }
    private static void FileInput(){
        //en textfil skapas
        File file = new File("myTextFile.txt");
        try {

            if(file.createNewFile()) {
                System.out.println("Fil skapad");
            }else {
                System.out.println("Fil finns redan");
            }
        } catch (IOException ex) {
            Logger.getLogger(mainprog.class.getName()).log(Level.SEVERE, null, ex);
        }

        //text sparas från konsol till textfilen
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv in en text");
        String strInput = scan.nextLine();



        try {
            FileWriter fw = new FileWriter(file, true);

            //if (!file.getName().contains(".txt")) wr = new FileWriter(file+".txt", true);
            fw.append(strInput + "\n");
            fw.write(strInput);
            fw.close();
            System.out.println("Text har sparats till filen");
        } catch (IOException ex) {
            Logger.getLogger(mainprog.class.getName()).log(Level.SEVERE, null, ex);
        }

        //textfilen öppnas och texten skrivs ut
        try (Scanner fileInput = new Scanner(new File("myTextFile.txt"))) {
            while (fileInput.hasNextLine()) {
                System.out.println(fileInput.nextLine());
            }
            fileInput.close();
        }catch (IOException ex) {
            Logger.getLogger(mainprog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static void FileChooserInput(){
        File file;
        JFileChooser jfc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("TextFiler", "txt"); //filtrerar att filechooser bara ska välja txt-filer
        jfc.setFileFilter(filter);
        jfc.showOpenDialog(null);

        if (jfc.getSelectedFile() != null) {
        file = jfc.getSelectedFile();

        jfc.showSaveDialog(null);
        file = jfc.getSelectedFile();
    }
    return;
    }
}
