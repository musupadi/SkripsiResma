package com.destinyapp.skripsiresma.Model;

import java.util.ArrayList;

public class LaguWajibData {
    public static String[][] data = new String[][]{
            {"Ibu Kita Kartini",
                    "Lirik",
                    "http://192.168.0.3/Lagu/TheRisingShieldHero.mp3"
            },
            {"Hymne Guru",
                "Lirik",
                "http://192.168.0.3/Lagu/TheRisingShieldHero.mp3"}
    };
    public static ArrayList<ModelLaguWajib> getListData(){
        ModelLaguWajib laguWajib = null;
        ArrayList<ModelLaguWajib> list = new ArrayList<>();
        for (String[] aData : data) {
            laguWajib = new ModelLaguWajib();
            laguWajib.setNamaLagu(aData[0]);
            laguWajib.setLirik(aData[1]);
            laguWajib.setLagu(aData[2]);
            list.add(laguWajib);
        }
        return list;
    }
}
