import java.io.*;
import java.util.LinkedList;

public class Kayit {
    //başlat
    private LinkedList<Game> list = new LinkedList<Game>();
    private Game game2;


    //************************************************************************

    public void ekle(Game game2){

        list.add(game2);

    }

    public void puanEkle(Game game) {
        list.add(game);
        kaydet();
    }

    public void kaydet() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("points.bin"))) {
            out.writeObject(list);
            System.out.println("Puanlar kaydedildi, istediğiniz zaman kullanabilirsiniz!");
        } catch (IOException e) {
            System.out.println("Puanlar dosyaya kaydedilirken bir hata oluştu.");
        }
    }


    //************************************************************************

    public void kayittanAl() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("points.bin"))) {
            list = (LinkedList<Game>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Puan dosyadan yüklenirken bir hata oluştu.");
        }
    }


    //************************************************************************


    public LinkedList<Game> getList() {
        return list;
    }

    public void setList(LinkedList<Game> list) {
        this.list = list;
    }

    public Game getGame2() {
        return game2;
    }

    public void setGame2(Game game2) {
        this.game2 = game2;
    }
}
