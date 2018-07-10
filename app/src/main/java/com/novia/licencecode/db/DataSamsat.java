package com.novia.licencecode.db;

import android.content.Context;

/**
 * Created by meta on 10/07/18.
 */
public class DataSamsat {

    public static void save(Context context) {
        SamsatDb db = new SamsatDb(context);
        Samsat samsat = new Samsat();

        samsat.address = "Kantor Bersama Samsat Jakarta Utara Pusat, Jl. Gunung Sahari No. 13, " +
                "Pademangan, Jakarta Utara 14420, email: samsatpusat@gmail.com" +
                "\nTelp: (021) 64715202, 6405826\n" +
                "Fax: (021) 6405826";
        samsat.name = "Unit PKB & BBN-KB Jakarta Pusat";
        samsat.lat = -6.137323;
        samsat.lon = 106.833297;
        db.insert(samsat);

        samsat.address = "Kantor Bersama Samsat Jakarta Barat, Jl. Daan Mogot KM. 13, Cengkareng, " +
                "Jakarta Barat 11720, email: unit_pelayanan_samsat_barat@yahoo.co.id" +
                "\nTelp: (021) 5442283, 5442301, 5442302\n" +
                "Fax: (021) 5442283";
        samsat.name = "Unit PKB & BBN-KB Jakarta Barat";
        samsat.lat = -6.153667;
        samsat.lon = 106.738311;
        db.insert(samsat);

        samsat.address = "Kantor Bersama Samsat Jakarta Utara Pusat, Jl. Gunung Sahari No. 13, " +
                "Pademangan, Jakarta Utara 14420, email: samsatutara@yahoo.com" +
                "\nTelp: (021) 64715202\n" +
                "Fax: (021) 6404304, 6404918";
        samsat.name = "Unit PKB & BBN-KB Jakarta Utara";
        samsat.lat = -6.137323;
        samsat.lon = 106.833297;
        db.insert(samsat);

        samsat.address = "Komplek Gedung Polda Metro Jaya, Jl. Jendral Gatot Subroto, Kebayoran Baru," +
                " Jakarta Selatan 12110, email: samsat.selatan@yahoo.com dan " +
                "uppkb.samsatselatan@jakarta.go.id" +
                "\n Telp: (021) 5737219\n" +
                "Fax: (021) 5255382";
        samsat.name = "Unit PKB & BBN-KB Jakarta Selatan";
        samsat.lat = -6.223468;
        samsat.lon = 106.814274;
        db.insert(samsat);

        samsat.address = "Kantor Bersama Samsat Jakarta Timur, Jl. D.I. Panjaitan Kav. 55, Jatinegara," +
                " Jakarta Timur 13410, email: samsat.timur@yahoo.co.id" +
                "\nTelp: (021) 8199849-52, 8199854";
        samsat.name = "Unit PKB & BBN-KB Jakarta Timur";
        samsat.lat = -6.229504;
        samsat.lon = 106.87688;
        db.insert(samsat);

        samsat.address = "Kantor Dinas Pelayanan Pajak, Jl. Abdul Muis No. 66 Lantai 1 dan 10, Petojo " +
                "Selatan-Gambir, Jakarta Pusat 10160, email: upt.humasdpp@gmail.com, " +
                "Facebook: Humas Pajak Jakarta, Website: dpp.jakarta.go.id, Instagram: " +
                "humaspajakjakarta, Pinterest: Humas Pajak Jakarta, Twitter: @humaspajakjkt, Youtube: " +
                "Humas Pajak Jakarta, Google +: upt.humasdpp@gmail.com" +
                "\nTelp: (021) 3865580-85 ext 5036 & 5037, atau (021) 3865629 " +
                "dan Tlp/Fax : (021) 3865765";
        samsat.name = "Unit Pelayanan Penyuluhan dan Layanan Informasi (Humas DPP)";
        samsat.lat = -6.184263;
        samsat.lon = 106.8272497;
        db.insert(samsat);
    }
}
