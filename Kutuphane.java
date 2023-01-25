
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map.Entry;


public class Kutuphane {


    HashMap<String ,String> isimler_ve_okuduklari_kitaplar =new HashMap<String,String>();
    HashMap<Integer ,String> kisiler=new HashMap<Integer,String>();
    HashMap<Integer ,String> kitaplar=new HashMap<Integer,String>();




    public void topluKayit(ArrayList<Pair<String, String>> kayitlar) {

        for(int i=0; i<kayitlar.size();i++){
            this.isimler_ve_okuduklari_kitaplar.put(kayitlar.get(i).getFirst(),kayitlar.get(i).getSecond());

        }
        for(int i=0; i<kayitlar.size();i++){
            this.kisiler.put(i,kayitlar.get(i).getFirst());

        }
        for(int i=0; i<kayitlar.size();i++){
            this.kitaplar.put(i,kayitlar.get(i).getSecond());

        }


    }

    public void ozetGec(){
    /*
    ArrayList<String> Alfabetik = new ArrayList<String>(isimler.keySet());
    Collection<String> values = kisiler.values();

    // Creating an ArrayList of values
    ArrayList<String> listOfValues = new ArrayList<>(values);
    Collections.sort(Alfabetik);
    for(int i=0;i<Alfabetik.size();i++) {
        System.out.println(Alfabetik.get(i)+"\t"+ Collections.frequency(listOfValues, Alfabetik.get(i)));
    }

     */
        ArrayList<String> Alfabetik_siralama = new ArrayList<String>(isimler_ve_okuduklari_kitaplar.keySet());


        Collections.sort(Alfabetik_siralama);

        for (int i = 0; i < Alfabetik_siralama.size(); i++) {
            int counter = 0;

            Iterator iterate = kisiler.entrySet().iterator();

            while (iterate.hasNext()) {
                Entry pairs = (Entry) iterate.next();
                if (pairs.getValue().equals(Alfabetik_siralama.get(i))) {
                    counter++;
                }
            }
            System.out.println(Alfabetik_siralama.get(i) +"\t"+  counter);
        }



    }
    public String enCokKitapOkuyan() {

        ArrayList<String> isim_ve_kitap_List = new ArrayList<String>(isimler_ve_okuduklari_kitaplar.keySet());
        ArrayList<Integer> sayilar = new ArrayList<Integer>();

       // int max = 0;
        //int index;
        for (String s : isim_ve_kitap_List) {
            int count_them = 0;

            for (Entry<Integer, String> integerStringEntry : kisiler.entrySet()) {
                Entry enter = (Entry) integerStringEntry;
                if (enter.getValue().equals(s)) {
                    count_them++;
                    sayilar.add(count_them);
                }
            }
        }
        return isim_ve_kitap_List.get(sayilar.indexOf(Collections.max(sayilar)-1));
    }
    public int toplamAlinanKitapSayisi() {
        int toplam_alinan_kitap=kitaplar.size();
        return  toplam_alinan_kitap;}

    public int toplamOkuyucuSayisi() {
        int okuyucu_sayisi= isimler_ve_okuduklari_kitaplar.size();
        return okuyucu_sayisi;}

    public String enAzOkunanKitap() {

        Collection<String> get_values = kitaplar.values();
        String[] kitap_isimleri_arr = get_values.toArray(new String[0]);

        HashMap<String, Integer> map_tmp = new HashMap<>();

        for (String str : kitap_isimleri_arr) {

            if (map_tmp.containsKey(str)) {
                int val = map_tmp.get(str);
                val++;
                map_tmp.put(str, val);
            } else {
                map_tmp.put(str, 1);
            }

        }
        int least_num = map_tmp.get(kitap_isimleri_arr[0]);
        String least_book_name = kitap_isimleri_arr[0];

        for (Iterator<String> iterator = map_tmp.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();

            if (map_tmp.get(key) < least_num) {
                least_num = map_tmp.get(key);
                least_book_name = key;
            }

        }
        return least_book_name;
    }
}




