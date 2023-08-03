import java.io.*;
import java.util.Scanner;

public class Game implements Serializable {
    private int puan=0,id;

    public Game() {
        System.out.print("Kullanıcı id'niz :");

        Scanner scanner = new Scanner(System.in);

        this.id = scanner.nextInt();
    }

    public void puanTopla(int w){
        switch (w){
            case 1:
                puan+=200;
                System.out.println("puan : "+puan);
                break;
            case 2:
                puan+=400;
                System.out.println("puan : "+puan);
                break;
            case 3:
                puan+=600;
                System.out.println("puan : "+puan);
                break;
            case 4:
                break;
            default:
                System.out.println("Hatalı seçim.");
                break;
        }
    }






    //************************************************************************


    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
