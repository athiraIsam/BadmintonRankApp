package nami.apps.badmintonrankapp.model;

import nami.apps.badmintonrankapp.R;

public class PlayerMemberID {

    public static int  getSinglePlayerImageID(int memberId)
    {
        switch (memberId)
        {
            case 25831: return R.drawable.viktor_axelsen;
            case 89785: return R.drawable.kento_momota;
            case 95661: return R.drawable.anthony;
            case 75787: return R.drawable.chen_long;
            case 81561: return R.drawable.lee_zii_jia;
            case 91554: return R.drawable.antonsen;
            case 34810: return R.drawable.chou_tien_chen;
            case 73442: return R.drawable.jonanthan;
            case 45171: return R.drawable.ng_ka_long;
            case 62855: return R.drawable.rasmus;
            case 57823: return R.drawable.kanta_tsuneyama;
            case 65042: return R.drawable.wang_tzu_wei;
            case 57945: return R.drawable.shi_yu_qi;
            case 93627: return R.drawable.kidambi;
            case 94780: return R.drawable.lee_cheuk_yiu;
            case 42776: return R.drawable.sai_praneeth;
            case 85394: return R.drawable.kenta_nishimoto;
            case 92508: return R.drawable.kantaphon;
            case 53753: return R.drawable.hans_kristian;
            case 76115: return R.drawable.loh_kean_yew;
            case 68870: return R.drawable.lakshya_sen;
            case 81887: return R.drawable.shesar_hiren;
            case 64032: return R.drawable.kunlavut;
            case 77003: return R.drawable.sameer_verma;
            case 14587: return R.drawable.tommy_sugiarto;
            case 35642: return R.drawable.ratchanok_intanon;
            case 73173: return R.drawable.pusarla_v_sindhu;
            case 87442: return R.drawable.an_se_young;
            case 18228: return R.drawable.carolina_marin;
            case 96713: return R.drawable.nozomi_okuhara;
            case 96312: return R.drawable.akane_yamaguchi;
            case 78778: return R.drawable.chen_yu_fei;
            case 61427: return R.drawable.tai_tzu_ying;

            default: return R.drawable.unknown_player;
        }
    }

    public static int  getDoubleImageID(int memberId)
    {
        switch (memberId)
        {

            case 26394: return R.drawable.marcus_gideon;
            case 80057: return R.drawable.kevin_sanjaya;
            case 51074: return R.drawable.hendra_setiawan;
            case 52749: return R.drawable.mohamad_ahsan;

            default: return R.drawable.unknown_player;
        }
    }
}
