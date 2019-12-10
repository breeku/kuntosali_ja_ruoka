package com.example.getfit;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton luokka, joka sisältää ArrayListin, jossa on ruokien tiedot.
 * @author ilkka
 * @version 1.0 5/12/2019
 */
public class Ruoat {
    private List<Ruoka> food;
    private static final Ruoat ourInstance = new Ruoat();

    public static Ruoat getInstance() {
        return ourInstance;
    }

    private Ruoat() {
        food = new ArrayList<>();
        food.add(new Ruoka("Kanaa ja riisiä",
                "-paketti kanaa (250g)\n-Ruokakermaa(2dl)\n-Riisiä noin 2dl\n-Apetit pakaste kasvikset\n-Mausteeksi curry ja mustapippuri",
                "1. Paista kanaa pannulla kunnes pinta on ruskistunut. Lisää ruokakerma ja mausteet. Anna hautua pannulla noin 5 minuuttia.\n2. Keitä riisi ja kavikset erikseen.",
                "kanaa_riisi_kasvikset"));
        food.add(new Ruoka("Vuohenjuusto-kanapasta",
                "-Spagettia (300g)\n-lehtikaalia(200g)\n-Hunajamarinoituja broilerin paistisuikaleita 450g\n-Öljyä 1-2 rkl\n-Suolaa 1/2tl\n-Mustapippuria\n-Vuohenjuustoa 200g\n-Sitruunapestoa 5rkl\n-Pastan keitinvesi 1dl",
                "1. Keitä pasta suolavedessä. Ota kaksi desiä keitinvettä talteen.\n2. Poista lehtikaalista kovat kohdat ja pilko hyvät osat paloiksi.\n3. Paista kana äljytyssä pannussa. Lisää öljyä ja lehtikaali. Paista kunnes lehtikaali on painunut kokoon. Mausta suolalla ja pippurilla. Sekoita tämä pastan sekaan." +
                        "\n3. Plaoittele 3/4 vuohenjuustosta ja lisää se peston ja keitinveden kanssa pastan joukkoon. Murenna loput vuohenjuustosta pinnalle.",
                "vuohenjuusto"));
        food.add(new Ruoka("Mango-lohipasta",
                "-Tagliatelle-pastaa 300g\n-Lohikuutioita 300g\n-Sipulikuutioita 1dl\n-Öljyä paistoon 1rkl\n-Syöntikypsä mango 400g\n-Parsakaalia 200g\n-Ruokakermaa 1prk\n-Suolaa 1tl\n-Mustapippuria.",
                "1. Keitä pasta pakkauksen ohjeen mukaan.\n2. Sulata pakaste lohikuutiot mikrossa. Kuullota sipulit pannulla. Lisää lohi pannulle ja paista. Mausta suolalla." +
                        "<\n3. Leikkaa mango pieniksi kuutioiksi. Pilko parsakaali ja lisää se pannulle. Lisää pannulle ruokakerma ja mango. Paista käännellen 4-5min. Lisää lopuksi lohisipuli seos pannulle.",
                "lohimango"));
        food.add(new Ruoka("Härkis-pastakastike",
                "-Härkis kypsää härkäpapuvalmistetta 250g\n-sipuli 100g\n-valkosipulinkynsi 2kpl" +
                        "\nöljyä 1rkl\n-tomaattimurska 500g\n-aurinkokuivattuja tomaattisuikaleita 1/2dl\n-tomaattisose 1rkl\n-suolaa 1tl\n-kuivattua basilikaa 1tl\n-sokeria 1/2tl\n-mustapippuria ripaus\n-kaura kasvirasvasekoite 1-2dl",
                "1. Kuori ja hienonna sipuli ja valkosipuli. Kuullota sipulit pannulla.\n2. Lisää pannulle tomaattimurska, aurinkokuivatut tomaattisuikaleet, tomaattisose ja mausteet\n3. " +
                        "Sekoita kastikkeen joukkoon kaurakerma ja härkäpapuvalmiste. Kuumenna kastike ja tarjoile.",
                "harkis"));
        food.add(new Ruoka("",
                "",
                "",
                ""));
        food.add(new Ruoka("",
                "",
                "",
                ""));
    }

    /**
     * Palauttaa listan, jossa ruokien tiedot.
     * @return food koko food lista palautetaan.
     */
    public List<Ruoka> getFood() {
        return food;
    }

    /**
     * Palauttaa yhden ruokalajin tiedot.
     * @param i saa arvon riippuen käyttäjän valitsemasta ruokalajista.
     * @return food.get(i) riippuen i:n arvosta palautetaan ruokalajin tiedot.
     */
    public Ruoka getFood(int i) {
        return food.get(i);
    }
}
