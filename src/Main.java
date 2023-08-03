import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Puan toplama oyunu \n");


        //objeler

        Game game1 = new Game();

        Kayit kayit1 = new Kayit();


        String filePath = "points.bin"; // Dosya yolu burada değiştirilmeli

        File file = new File(filePath);


        Scanner scanner = new Scanner(System.in);


        //oyun mantığı
        System.out.println("1.Takla at\n2.Şarkı söyle\n3.Şov yap\n4.Çıkış\n\n");


        if (!file.exists()){

            int k;

            while (true)
            {
                System.out.print("işlem :");
                k = scanner.nextInt();

                game1.puanTopla(k);

                if (k == 4){
                    break;
                }
            }
        }
        else {

            //şunu başta çağırmazsak hata alırız

            kayit1.kayittanAl();

            //önemli listeden id'yi bulunca eklemeye başlar

            int i=0;

            //silme işlemi


            Iterator<Game> iterator = kayit1.getList().iterator();



            for (Game q : kayit1.getList()){
                if (q.getId() == game1.getId()){


                    game1.setPuan(q.getPuan());



                    kayit1.getList().remove(i);


                    //break konmazsa hata alınır çünkü silinen değerden sonrası kalmaz hataya düşer
                    break;
                }

                i++;
            }


            /*

            buda kullanılabilir silme için

            while (iterator.hasNext()) {

                Game game = iterator.next();


                if (game.getId() == game1.getId()) {
                    iterator.remove();
                    System.out.println("Buldum");
                    game1.setPuan(game.getPuan());



                    kayit1.getList().remove(i);

                    break;
                }
            }

            */



            //kayıttan alarak başla




            int k;

            while (true)
            {
                System.out.print("işlem :");
                k = scanner.nextInt();

                game1.puanTopla(k);

                if (k == 4){
                    break;
                }
            }
        }

        // Güncellenmiş puanları kaydet
        kayit1.puanEkle(game1);


    }
}