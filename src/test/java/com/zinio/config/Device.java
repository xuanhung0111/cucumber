package com.zinio.config;

import java.util.HashMap;
import java.util.Map;

public enum Device {
	  IOS_IPHONE_6_LOCAL("iPhone Zinio", "Apple", "MG472QL/A", "IOS", "10.3.1", 0L,
	      "2c08e9f1674cbc17f96848872f4bad833b8e0346", 4725),
	  IOS_IPAD_4_MINI_LOCAL("iPad Mini 4", "Apple", "iPad Mini 4", "IOS", "10.3.1", 0L, 
	      "940d6d6b45033f1a256ba521046067d2b961c027", 4725),
	  IOS_IPAD_2_LOCAL("iPad 2", "Apple", "MGL12TY/A", "IOS", "10.2.1", 0L, 
	      "b2ed880ae0f6aaf8e289040427f6c43e7f452b7c", 4725),
	  IOS_IPAD_PRO_LOCAL("iPad Pro", "Apple", "ML0F2TY/A", "IOS", "10.3.2", 0L, 
	      "f1fee43cf4adc4e57fe11965b41653a8970327b4", 4725),
	  IOS_IPAD_FARM("iPad", "Apple", "iPad", "IOS", "10.3.1", 0L, 
	      "abeddada52d3b499353d03e784a61beaf071bcaa", 4755),
	  IOS_IPAD_MINI_4_FARM("iPad Mini 4", "Apple", "iPad Mini 4", "IOS", "10.3.2", 0L, 
	      "e777daad8c472c690701e4a686c41a25222a83c7", 4752),
	  IOS_IPHONE_7_FARM("iPhone 7", "Apple", "iPhone 7", "IOS", "10.3.2", 0L, 
	      "6fb59a3762bcf4621d22428ac42e28627610d0e5", 4758),
	  IOS_IPHONE_SE_FARM("iPhone SE", "Apple", "iPhone SE", "IOS", "10.3.2", 0L, 
	      "cf4f7a31faae8b33863134821461988ee64fc3d4", 4761),
	  ANDROID_GALAXY_TAB_A6_FARM("Galaxy Tab A", "Samsung", "Galaxy Tab A6", "ANDROID", "5.1.1", 
	      0L, "310091aa4de12400", 4733),
	  ANDROID_GALAXY_S7_EDGE_FARM("Galaxy S7 Edge", "Samsung", "Galaxy S7 Edge", "ANDROID",
	      "6.0.1", 0L, "ce11160bc5979b0205", 4736),
	  ANDROID_NEXUS_5_FARM("Nexus 5X", "LG", "Nexus 5", "ANDROID", "7.1.1", 0L, "0255b2ba85c290b7", 
	      4739),
	  ANDROID_NEXUS_LOCAL("Nexus 6", "LG", "Nexus 6", "ANDROID", "6.0.1", 0L, "ZX1G524LFX", 4725),
	  ANDROID_GALAXY_S4_LOCAL("Samsung Galaxy S4", "Samsung", "Galaxy S4", "ANDROID", "4.4.4", 0L),
	  ANDROID_GALAXY_S6_LOCAL("Samsung Galaxy S6", "Samsung", "Galaxy S6", "ANDROID", "6.0.1", 0L), 
	  ANDROID_GALAXY_S7_LOCAL("Samsung Galaxy S7 Edge", "Samsung", "Galaxy S7", "ANDROID", "6.0.1", 0L,
	      "9885e6314b41493948", 4725),
	  ANDROID_GALAXY_TAB_A6_LOCAL("Galaxy Tab A6", "Samsung", "Galaxy Tab A6", "ANDROID", "5.1.1", 
	      1381L, "3100297a15aa4300", 4730),
	  ANDROID_COOLPAD("Coolpad 8730L", "Coolpad", "8730L", "ANDROID", "4.3", 962L),
	  ANDROID_COOLPAD_DASHEN("Coolpad Dashen F2 8675", "Coolpad", "Coolpad Dashen F2 8675", 
	      "ANDROID", "4.4.2", 955L),
	  ANDROID_GALAXY_A("Samsung Galaxy A3 SM-A300FU", "Samsung", "Galaxy A3 SM-A300FU", "ANDROID", 
	      "5.0.2", 1385L),
	  ANDROID_GALAXY_ALPHA("Samsung Galaxy Alpha SM-G850F", "Samsung", "Galaxy Alpha SM-G850F", 
	      "ANDROID", "5.0.2", 1193L),
	  ANDROID_GALAXY_CORE_ADVANCE("Samsung Galaxy Core Advance", "Samsung", "Galaxy Core Advance", 
	      "ANDROID", "4.2.2", 1173L),
	  ANDROID_GALAXY_CORE_2("Samsung Galaxy Core 2 SM-G355M", "Samsung", "Galaxy Core 2 SM-G355M", 
	      "ANDROID", "4.2.2", 1195L),
	  ANDROID_GALAXY_S3_T999("Samsung Galaxy S III SGH-T999", "Samsung", "Galaxy SIII", "ANDROID", 
	      "4.1.2", 200L),
	  ANDROID_GALAXY_S3_NEO("Samsung Galaxy S3 Neo", "Samsung", "Galaxy S3 Neo", "ANDROID", 
	      "4.4.4", 1237L),
	  ANDROID_GALAXY_S3_VERIZON("Samsung Galaxy S III Verizon SCH-I535", "Samsung", 
	      "Galaxy SIII Verizon", "ANDROID", "4.1.1", 365L),
	  ANDROID_GALAXY_S3_SGH_I747("Samsung Galaxy S III SGH-I747", "Samsung", "Galaxy S III SGH-I747", 
	      "ANDROID", "4.3", 537L),
	  ANDROID_GALAXY_S3_SPH_L710("Samsung Galaxy S III SPH-L710 4.4.2", "Samsung", 
	      "Galaxy S III SPH-L710", "ANDROID", "4.4.2", 1235L),
	  ANDROID_GALAXY_S3_GT_I9305("Samsung Galaxy S III GT-I9305", "Samsung", 
	      " Galaxy S III GT-I9305", "ANDROID", "4.3", 648L),
	  ANDROID_GALAXY_S3_MINI("Samsung Galaxy S III Mini GT-I8190L", "Samsung", 
	      "Galaxy S III Mini GT-I8190L", "ANDROID", "4.1.2", 549L),
	  ANDROID_GALAXY_S3_I9300("Samsung Galaxy S3 i9300 4.4.4", "Samsung", 
	      "Galaxy S3 i9300 4.4.4", "ANDROID", "4.4.4", 1369L),
	  ANDROID_GALAXY_GRAND_DUOS("Samsung Galaxy Grand Duos GT-I9082L", "Samsung", 
	      "Galaxy Grand Duos GT-I9082L", "ANDROID", "4.1.2", 539L),
	  ANDROID_GALAXY_GRAND_2("Samsung Galaxy Grand 2 SM-G7105", "Samsung", 
	      "Galaxy Grand 2 SM-G7105", "ANDROID", "4.4.2", 884L),
	  ANDROID_GALAXY_GRAND_2_SM_G7102("Samsung Galaxy Grand 2 SM-G7102", "Samsung", 
	      "Galaxy Grand 2 SM-G7102", "ANDROID", "4.4.2", 1179L),
	  ANDROID_GALAXY_GRAND_NEO("Samsung Galaxy Grand Neo GT-I9060I", "Samsung", 
	      "Galaxy Grand Neo GT-I9060I", "ANDROID", "4.4.4", 1194L),
	  ANDROID_GALAXY_ROUND("Samsung Galaxy Round SM-G910S", "Samsung", 
	      "Galaxy Round SM-G910S", "ANDROID", "4.3", 888L),
	  ANDROID_GALAXY_S_DUOS("Samsung Galaxy S Duos GT-S7562L", "Samsung", 
	      "Galaxy S Duos GT-S7562L", "ANDROID", "4.0.4", 561L), 
	  ANDROID_GALAXY_S_DUOS_2("Samsung Galaxy S Duos 2 GT-S7582", "Samsung", 
	      "Galaxy S Duos 2 GT-S7582", "ANDROID", "4.2.2", 1184L), 
	  ANDROID_GALAXY_S4("Samsung Galaxy S4 GT-I9506", "Samsung", "Galaxy S4", "ANDROID", "5.0.1",
	      1238L),
	  ANDROID_GALAXY_S4_ALTIUS("Samsung Galaxy S4 Altius SC-04E", "Samsung", "Galaxy S4 Altius SC-04E", 
	      "ANDROID", "5.0.1", 1207L),
	  ANDROID_GALAXY_S4_ALTIUS_SCH_R970("Samsung Galaxy S4 Altius SCH-R970", "Samsung", 
	      "Galaxy S4 Altius SCH-R970", "ANDROID", "5.0.1", 1211L),
	  ANDROID_GALAXY_S4_ALTIUS_SGH_M919("Samsung Galaxy S4 Altius SGH-M919", "Samsung", 
	      "Galaxy S4 Altius SGH-M919", "ANDROID", "4.4.4", 1236L),
	  ANDROID_GALAXY_S4_ZOOM("Samsung Galaxy S4 Zoom SM-C105", 
	      "Samsung", "Galaxy S4 Zoom SM-C105", 
	      "ANDROID", "4.4.2", 1083L), 
	  ANDROID_GALAXY_S5("Samsung Galaxy S5 SM-G900F", "Samsung", "Galaxy S5", "ANDROID", "4.4.2", 
	      1636L),
	  ANDROID_GALAXY_S5_MINI("Samsung Galaxy S5 Mini SM-G800F", "Samsung", "Galaxy S5 Mini SM-G800F", 
	      "ANDROID", "4.4.2", 1069L),
	  ANDROID_GALAXY_A5("Samsung Galaxy A5 SM-A500FU", "Samsung", "Galaxy A5", "ANDROID", "4.4.4", 
	      938L),
	  ANDROID_GALAXY_A7("Samsung Galaxy A7 SM-A700F", "Samsung", "Galaxy A7 SM-A700F", "ANDROID", 
	      "4.4.4", 1015L),
	  ANDROID_GALAXY_S6("Samsung Galaxy S6 SM-G920F", "Samsung",  "Galaxy S6", "ANDROID", "6.0.1", 
	      1368L), 
	  ANDROID_GALAXY_S6_EDGE("Samsung Galaxy S6 Edge SM-G925F", "Samsung", "Galaxy S6 Edge", "ANDROID",
	      "5.1.1", 1249L), 
	  ANDROID_GALAXY_S7("Samsung Galaxy S7 SM-G930F", "Samsung", "Galaxy S7", "ANDROID", "6.0.1",
	      1663L),
	  ANDROID_GALAXY_S7_EDGE("Samsung Galaxy S7 Edge SM-G935F", "Samsung", "Galaxy S7 Edge", "ANDROID",
	      "6.0.1", 2016L),
	  ANDROID_GALAXY_MEGA("Samsung Galaxy Mega GT-I9205", "Samsung", "Galaxy Mega GT-I9205", "ANDROID",
	      "4.4.2", 1016L),
	  ANDROID_GALAXY_NEXUS("Samsung Galaxy Nexus GT-I9250 4.3 -US", "Samsung", 
	      "Galaxy Nexus GT-I9250 4.3 -US", "ANDROID", "4.3", 1020L),
	  ANDROID_GALAXY_NOTE_GT_N8013("Samsung Galaxy Note 10.1 GT-N8013", "Samsung", 
	      "Galaxy Note 10.1 GT-N8013", "ANDROID", "4.1.2", 262L),
	  ANDROID_GALAXY_NOTE_GT_N7000("Samsung Galaxy Note GT-N7000", "Samsung", 
	      "Galaxy Note GT-N7000", "ANDROID", "4.1.2", 218L),
	  ANDROID_GALAXY_NOTE_PRO("Samsung Galaxy NotePRO 12.2 SM-P900", "Samsung", 
	      "Galaxy NotePRO 12.2 SM-P900", "ANDROID", "4.4.2", 665L),
	  ANDROID_GALAXY_NOTE2("Samsung Galaxy Note 2", "Samsung", "Galaxy Note 2", "ANDROID", "4.4.2", 
	      1077L),
	  ANDROID_GALAXY_NOTE3("Samsung Galaxy Note 3 SM-N900V", "Samsung", "Galaxy Note 3", "ANDROID", 
	      "4.4.4", 854L),
	  ANDROID_GALAXY_NOTE3_NEO("Samsung Galaxy Note 3 Neo SM-N7505", "Samsung", 
	      "Galaxy Note 3 Neo SM-N7505", "ANDROID", "4.4.2", 867L),
	  ANDROID_GALAXY_NOTE_8("Samsung Galaxy Note 8.0 GT-N5110", "Samsung", "Galaxy Note 8.0 GT-N5110", 
	      "ANDROID", "4.4.2", 743L),
	  ANDROID_GALAXY_TAB_A("Samsung Galaxy Tab A T550", "Samsung", "Galaxy Tab A T550", "ANDROID", 
	      "5.0.2", 1381L),
	  ANDROID_GALAXY_TAB_2_10_1("Samsung Galaxy Tab 2 10.1 GT-P5113", "Samsung", 
	      "Galaxy Tab 2 10.1 GT-P5113", "ANDROID", "4.2.2", 1082L),
	  ANDROID_GALAXY_TAB_2_GT_P5100("Samsung Galaxy Tab 2 10.1 GT-P5100", "Samsung", 
	      "Galaxy Tab 2 10.1 GT-P5100", "ANDROID", "4.1.2", 202L),
	  ANDROID_GALAXY_TAB_2_GT_P3113("Samsung Galaxy Tab 2 7.0 GT-P3113", "Samsung", 
	      "Galaxy Tab 2 7.0 GT-P3113", "ANDROID", "4.2.2", 632L),
	  ANDROID_GALAXY_TAB_2_GT_P7510("Samsung Galaxy Tab 10.1 GT-P7510", "Samsung", 
	      "Galaxy Tab 10.1 GT-P7510", "ANDROID", "4.0.4", 222L),
	  ANDROID_GALAXY_TAB_3("Samsung Galaxy Tab 3 8.0 SM-T310", "Samsung", 
	      "Galaxy Tab 3 8.0 SM-T310", "ANDROID", "4.4.2", 950L),
	  ANDROID_GALAXY_TAB_4("Samsung Galaxy Tab 4 SM-T230NU", "Samsung", 
	      "Galaxy Tab 4 SM-T230NU", "ANDROID", "4.4.2", 1149L),
	  ANDROID_GALAXY_TAB_4_10_1("Samsung Galaxy Tab 4 10.1 SM-T530NU", "Samsung", 
	      "Galaxy Tab 4 10.1 SM-T530NU", "ANDROID", "4.4.2", 1187L),
	  ANDROID_GALAXY_TAB_4_8_0("Samsung Galaxy Tab 4 8.0 SM-T330NU", "Samsung", 
	      "Galaxy Tab 4 8.0 SM-T330NU", "ANDROID", "4.4.2", 756L),
	  ANDROID_GALAXY_TAB_4_7_0("Samsung Galaxy Tab 4 7.0 SM-T230NU", "Samsung", 
	      "Galaxy Tab 4 7.0 SM-T230NU", "ANDROID", "4.4.2", 778L),  
	  ANDROID_GALAXY_TAB_PRO("Samsung Galaxy TabPRO 8.4 SM-T320", "Samsung", 
	      "Galaxy TabPRO 8.4 SM-T320", "ANDROID", "4.4.2", 699L),
	  ANDROID_GALAXY_TAB_S2("Samsung Galaxy Tab S2 T810", "Samsung", "Galaxy Tab S2 T810", "ANDROID", 
	      "5.1.1", 1382L),
	  ANDROID_GALAXY_TAB_S("Samsung Galaxy Tab S 8.4 SM-T700", "Samsung", 
	      "Galaxy Tab S 8.4 SM-T700", "ANDROID", "5.0.2", 1147L),
	  ANDROID_GALAXY_TAB_S_10_5("Samsung Galaxy Tab S 10.5 SM-T800", "Samsung", 
	      "Galaxy Tab S 10.5 SM-T800", "ANDROID", "5.0.2", 1232L),
	  ANDROID_GALAXY_TREND_PLUS("Samsung Galaxy Trend Plus S7580", "Samsung", "Galaxy Trend Plus S7580",
	      "ANDROID", "4.2.2", 1245L),
	  ANDROID_GALAXY_CAMERA("Samsung Galaxy Camera EK-GC100", "Samsung", "Galaxy Camera EK-GC100", 
	      "ANDROID", "4.1.2", 205L),
	  ANDROID_GALAXY_CAMERA_2("Samsung Galaxy Camera 2 EK-GC200", "Samsung", "Galaxy Camera 2 EK-GC200", 
	      "ANDROID", "4.3", 921L),
	  ANDROID_GALAXY_K_ZOOM("Samsung Galaxy K zoom SM-C115", "Samsung", "Galaxy K zoom SM-C115", 
	      "ANDROID", "4.4.2", 806L),
	  ANDROID_ACER_ICONIA_A500( "Acer Iconia A500", "Acer", "Iconia A500", "ANDROID", "6.0.1", 31L), 
	  ANDROID_ACER_ICONIA_TAB_8( "Acer Iconia Tab 8 A1-840FHD -US", "Acer", "Iconia Tab 8 A1-840FHD-US",
	      "ANDROID", "4.4.2", 914L), 
	  ANDROID_ASUS_EEE_TF101("Asus Eee Pad Transformer TF101", "Acer", "Eee Pad Transformer TF101", 
	      "ANDROID", "4.0.3", 43L), 
	  ANDROID_ASUS_MEMO_PAD_7("Asus Memo Pad 7 K007 -US", "Acer", "Memo Pad 7 K007 -US", "ANDROID", 
	      "5.0.1", 1100L), 
	  ANDROID_ASUS_TRANSFORMER_TF300TL("Asus Transformer Pad TF300TL", "Acer", "Transformer TF300TL", 
	      "ANDROID", "4.2.1", 49L),
	  ANDROID_ASUS_ZENFONE_2("Asus ZenFone 2 Z008D -US", "Acer", "ZenFone 2 Z008D -US", "ANDROID", 
	      "5.0", 1217L),
	  ANDROID_DELL_VENUE("Dell Venue 8 3840", "Acer", "Venue 8 3840", "ANDROID", "4.4.4", 1222L),
	  ANDROID_FUHU_NABI("Fuhu Nabi Dream Tab 8", "Fuhu", "Nabi Dream Tab 8", "ANDROID", "4.4.2", 1010L),
	  ANDROID_HTC_ONE_X("HTC One X AT&T X325e", "HTC", "One X AT&T X325e", "ANDROID", "4.0.4", 58L),
	  ANDROID_HTC_EVO_4G("HTC EVO 4G", "HTC", "EVO 4G", "ANDROID", "2.3.5", 331L),
	  ANDROID_HTC_AMAZE_4G("HTC Amaze 4G", "HTC", "Amaze 4G", "ANDROID", "4.0.3", 356L),
	  ANDROID_HTC_ONE_XL("HTC One XL X325s", "HTC", "One XL X325s", "ANDROID", "4.0.3", 98L),
	  ANDROID_HTC_ONE_MINI2("HTC One Mini 2", "HTC", "One Mini 2", "ANDROID", "4.4.2", 1137L),
	  ANDROID_HTC_ONE_E8("HTC One E8", "HTC", "One E8", "ANDROID", "5.0.2", 1140L),
	  ANDROID_HTC_ONE_M7("HTC One M7 5.0.2", "HTC", "One M7 5.0.2", "ANDROID", "5.0.2", 1246L),
	  ANDROID_HTC_ONE_M9("HTC One M9", "HTC", "One M9", "ANDROID", "6.0", 1374L),
	  ANDROID_HTC_ONE_S("HTC One S Z520e", "HTC", "One S Z520e", "ANDROID", "4.1.1", 1248L),
	  ANDROID_HTC_SENSATION_XL("HTC Sensation XL X315e", "HTC", "Sensation XL X315e", "ANDROID", 
	      "4.0.3", 108L),
	  ANDROID_HTC_DESIRE_Z("HTC Desire Z (Vision) A7272", "HTC", "Desire Z (Vision) A7272", "ANDROID", 
	      "2.3.3", 123L),
	  ANDROID_HTC_DESIRE_516("HTC Desire 516", "HTC", "Desire 516", "ANDROID", "4.3", 1014L),
	  ANDROID_HTC_DESIRE_610("HTC Desire 610", "HTC", "Desire 610", "ANDROID", "4.4.2", 1045L),
	  ANDROID_HTC_DESIRE_816("HTC Desire 816 (HTC 710C)", "HTC", "Desire 816 (HTC 710C)", "ANDROID", 
	      "5.0.2", 1074L),
	  ANDROID_HTC_DROID_DNA("HTC Droid DNA", "HTC", "Droid DNA", "ANDROID", "4.4.2", 1054L),
	  ANDROID_HUAWEI_ASCEND_C8813Q("Huawei Ascend C8813Q", "Huawei", "Ascend C8813Q", "ANDROID", 
	      "4.1.2", 125L),
	  ANDROID_HUAWEI_ASCEND_G6_L11("Huawei Ascend G6-L11 4G LTE", "Huawei", "Ascend G6-L11 4G LTE", 
	      "ANDROID", "4.3", 802L),
	  ANDROID_HUAWEI_ASCEND_G6_C00("Huawei Ascend G6-C00", "Huawei", "Ascend G6-C00", "ANDROID", "4.3",
	      862L),
	  ANDROID_HUAWEI_ASCEND_G300("Huawei Ascend G300 (Huawei C8815)", "Huawei", "Ascend G300", 
	      "ANDROID", "4.1.2", 517L),
	  ANDROID_HUAWEI_ASCEND_MATE_7("Huawei Ascend Mate 7", "Huawei", "Ascend Mate 7", "ANDROID", "6.0",
	      1377L),
	  ANDROID_HUAWEI_ASCEND_G600("Huawei Ascend G600 U8950-1", "Huawei", "Ascend G600 U8950-1", 
	      "ANDROID", "4.0.4", 136L),
	  ANDROID_HUAWEI_ASCEND_P1_U9200("Huawei Ascend P1 U9200", "Huawei", "Ascend P1 U9200", 
	      "ANDROID", "4.0.3", 137L),
	  ANDROID_HUAWEI_ASCEND_P6_U06("Huawei Ascend P6-U06", "Huawei", "Ascend P6-U06", "ANDROID", 
	      "4.2.2", 548L),
	  ANDROID_HUAWEI_ASCEND_P8_LITE("Huawei Ascend P8 Lite", "Huawei", "Ascend P8 Lite", "ANDROID", 
	      "5.0.2", 1403L),
	  ANDROID_HUAWEI_HONOR_2("Huawei Honor 2 U9508", "Huawei", "Honor 2 U9508", "ANDROID", 
	      "4.0.4", 138L),
	  ANDROID_HUAWEI_HONOR_U8860("Huawei Honor U8860", "Huawei", "Honor U8860", "ANDROID", 
	      "4.0.3", 135L),
	  ANDROID_HUAWEI_HONOR_6("Huawei Honor 6 H60-L01", "Huawei", "Honor 6 H60-L01", "ANDROID", 
	      "4.4.2", 845L),
	  ANDROID_HUAWEI_HONOR_6_PLUS("Huawei Honor 6 Plus", "Huawei", "Honor 6 Plus", "ANDROID", 
	      "4.4.2", 1266L),
	  ANDROID_HUAWEI_HONOR_6_H60_L04("Huawei Honor 6 H60-L04", "Huawei", "Honor 6 H60-L04", "ANDROID", 
	      "4.4.2", 944L),
	  ANDROID_HUAWEI_HONOR_7("Huawei Honor 7 PLK-L01", "Huawei", "Honor 7 PLK-L01", "ANDROID", 
	      "5.0", 1144L),
	  ANDROID_HUAWEI_HONOR_4("Huawei Honor 4 Play G621-TL00M", "Huawei", "Honor 4 Play G621-TL00M", 
	      "ANDROID", "4.4.4", 903L),
	  ANDROID_HUAWEI_HONOR_4A("Huawei Honor 4A", "Huawei", "Huawei Honor 4A", "ANDROID", "5.1.1", 
	      1363L),
	  ANDROID_HUAWEI_HONOR_4C("Huawei Honor 4C Play", "Huawei", "Huawei Honor 4C Play", "ANDROID", 
	      "4.4.4", 1362L),
	  ANDROID_HUAWEI_HONOR_4X("Huawei Honor 4X Play Che2-TL00", "Huawei", "Honor 4X Play Che2-TL00", 
	      "ANDROID", "4.4.2", 902L),
	  ANDROID_HUAWEI_HONOR_7I("Huawei Honor 7i", "Huawei", "Huawei Honor 7i", "ANDROID", "5.1.1", 
	      1624L),
	  ANDROID_HUAWEI_HONOR_5X("Huawei Honor 5X", "Huawei", "Honor 5X", "ANDROID", "5.1.1", 1402L),
	  ANDROID_HUAWEI_MEDIAPAD_7("Huawei MediaPad 7 Vogue", "Huawei", "MediaPad 7 Vogue", "ANDROID", 
	      "4.1.2", 541L),
	  ANDROID_HUAWEI_MEDIAPAD_10_LINK("Huawei MediaPad 10 LINK", "Huawei", "MediaPad 10 LINK", 
	      "ANDROID", "4.1.2", 546L),
	  ANDROID_LENOVO_A798("Lenovo A798t", "Lenovo", "A798t", "ANDROID", "4.0.4", 142L),
	  ANDROID_LENOVO_A820("Lenovo A820", "Lenovo", "A820", "ANDROID", "4.1.2", 519L),
	  ANDROID_LENOVO_K3_NOTE("Lenovo K3 Note K50-T5", "Lenovo", "K3 Note K50-T5", "ANDROID", "5.0", 
	      1154L),
	  ANDROID_LENOVO_K900("Lenovo K900", "Lenovo", "K900", "ANDROID", "4.2.2", 1170L),
	  ANDROID_LENOVO_LEMON("Lenovo Lemon K3 K30-T", "Lenovo", "Lemon K3 K30-T", "ANDROID", "4.4.4", 
	      960L),
	  ANDROID_LENOVO_YOGA_8("Lenovo YOGA Tablet 8 B6000-F", "Lenovo", "YOGA Tablet 8 B6000-F", "ANDROID",
	      "4.4.2", 1143L),
	  ANDROID_LG_OPTIMUS_L5("LG Optimus L5 Dual E615", "LG", "Optimus L5 Dual E615", "ANDROID", "4.0.4",
	      563L),
	  ANDROID_LG_OPTIMUS_L90("LG Optimus L90", "LG", "Optimus L90", "ANDROID", "5.0.2", 1176L),
	  ANDROID_LG_OPTIMUS_GEE_E975("LG Optimus Gee E975", "LG", "Optimus Gee E975", "ANDROID", "4.4.2", 
	      1080L),
	  ANDROID_LG_G_PAD("LG G Pad 8.3 V500", "LG", "G Pad 8.3 V500", "ANDROID", "4.4.2", 700L),
	  ANDROID_LG_G_PRO("LG G Pro 2 D838", "LG", "G Pro 2 D838", "ANDROID", "5.0.1", 1373L),
	  ANDROID_LG_G2_VERIZON("LG G2 Verizon VS980", "LG", "G2 Verizon VS980", "ANDROID", "4.2.2",
	      568L),
	  ANDROID_LG_G3("LG G3 D855", "LG", "G3 D855", "ANDROID", "5.0", 1240L),
	  ANDROID_LG_G4("LG G4 F500L", "LG", "G4 F500L", "ANDROID", "5.1", 1042L),
	  ANDROID_LG_G5("LG G5 H830", "LG", "LG G5 H830", "ANDROID", "6.0.1", 1391L),
	  ANDROID_LG_GOOGLE_NEXUS_5("LG Google Nexus 5 5.1 -US", "LG", "Google Nexus 5 5.1 -US", "ANDROID",
	       "5.1", 1252L),
	  ANDROID_LG_GOOGLE_NEXUS_5_6_0("LG Google Nexus 5 6.0.1 -US", "LG", "Google Nexus 5 6.0.1 -US", 
	      "ANDROID", "6.0.1", 1485L),
	  ANDROID_LG_OPTIMUS_FUEL("LG Optimus Fuel (L40 D160)", "LG", "Optimus Fuel (L40 D160)", "ANDROID",
	      "4.4", 1058L),
	  ANDROID_LG_SPIRIT("LG Spirit H440N", "LG", "Spirit H440N", "ANDROID", "5.0.1", 945L),
	  ANDROID_LG_VU_3("LG Vu 3 LG-F300K", "LG", "Vu 3 LG-F300K", "ANDROID", "4.4.42", 1171L),
	  ANDROID_LG_VOLT("LG Volt", "LG", "Volt", "ANDROID", "4.4.42", 1181L),
	  ANDROID_GALAXY_S_II_ROCKET("Samsung Galaxy S II Skyrocket SGH-i727", "Samsung", 
	      "Galaxy S II Skyrocket SGH-i727", "ANDROID", "4.0.4", 272L),
	  ANDROID_NVIDIA_SHIELD("NVIDIA Shield", "NVIDIA", "Shield", "ANDROID", "4.4.2", 720L),
	  ANDROID_NVIDIA_SHIELD_K1("NVIDIA SHIELD Tablet K1", "NVIDIA", "SHIELD Tablet K1", "ANDROID", 
	      "6.0", 1263L),
	  ANDROID_MOTOROLA_MOTO_E("Motorola Moto E XT1021", "Motorola", "Moto E XT1021", "ANDROID", "4.4.3", 
	      736L),
	  ANDROID_MOTOROLA_GOOGLE_NEXUS("Motorola Google Nexus 6 XT1100 6.0.1", "Motorola", 
	      "Google Nexus 6 XT1100 6.0.1", "ANDROID", "6.0.1", 1221L),
	  ANDROID_MOTOROLA_MOTO_X_GHOST("Motorola Moto X Ghost XT1056", "Motorola", "Moto X Ghost XT1056", 
	      "ANDROID", "4.4.4", 1026L),
	  ANDROID_MOTOROLA_MOTO_G("Motorola Moto G XT1028 -US", "Motorola", "Moto G XT1028 -US", 
	      "ANDROID", "5.1", 1378L),
	  ANDROID_MOTOROLA_MOTO_G_2GEN("Motorola Moto G (2nd Gen.) XT1068", "Motorola", 
	      "Moto G (2nd Gen.) XT1068", "ANDROID", "6.0", 1409L),
	  ANDROID_MOTOROLA_DROID_MINI("Motorola Droid Mini", "Motorola", "Droid Mini", "ANDROID", "4.4.4", 
	      1394L),
	  ANDROID_MOTOROLA_DROID_RAZOR("Motorola DROID RAZR HD XT926", "Motorola", "DROID RAZR HD XT926", 
	      "ANDROID", "4.4.2", 814L),
	  ANDROID_MOTOROLA_DROID_ULTRA("Motorola Droid Ultra", "Motorola", "Droid Ultra", "ANDROID", 
	      "4.4.4", 1395L),
	  ANDROID_MOTOROLA_DROID_ULTRA_MAXX("Motorola Droid Ultra Maxx", "Motorola", "Droid Ultra Maxx", 
	      "ANDROID", "4.4.4", 1393L),
	  ANDROID_ONE_PLUS_ONE("OnePlus One A0001 CyanogenOS -US", "OnePlus", 
	      "One A0001 CyanogenOS -US", "ANDROID", "5.1.1", 1190L),
	  ANDROID_ONE_PLUS_TWO("OnePlus Two A2001", "OnePlus", "Two A2001", "ANDROID", "5.1.1", 1243L),
	  ANDROID_PANTECH_VEGA_IRON("Pantech Vega Iron IM-A870S", "Pantech", "Vega Iron IM-A870S", 
	      "ANDROID", "4.4.2", 1174L),
	  ANDROID_SMARTISAN_T1("Smartisan T1 SM701", "Smartisan", "T1 SM701", "ANDROID", "4.4.2", 959L),
	  ANDROID_SONY_XPERIA_TABLET("Sony Xperia Tablet Z2", "Sony", "Xperia Tablet Z2", "ANDROID", 
	      "6.0.1", 1389L),
	  ANDROID_SONY_XPERIA_M2("Sony Xperia M2 D2303", "Sony", "Xperia M2 D2303", "ANDROID", "4.4.4", 
	      1150L),
	  ANDROID_SONY_XPERIA_M4_AQUA("Sony Xperia M4 Aqua E2303", "Sony", "Xperia M4 Aqua E2303", 
	      "ANDROID", "5.0", 1625L),
	  ANDROID_SONY_XPERIA_E1("Sony Xperia E1 D2105", "Sony", "Xperia E1 D2105", "ANDROID", "4.4.2", 
	      1153L),
	  ANDROID_SONY_XPERIA_T("Sony Xperia T LT30p", "Sony", "Xperia T LT30p", "ANDROID", "4.3", 946L),
	  ANDROID_SONY_XPERIA_TX("Sony Xperia TX LT29i", "Sony", "Xperia TX LT29i", "ANDROID", "4.3", 
	      1151L),
	  ANDROID_SONY_XPERIA_Z("Sony Xperia Z SO-02E (Sony Yuga)", "Sony", "Xperia Z SO-02E (Sony Yuga)", 
	      "ANDROID", "4.4.2", 1239L),
	  ANDROID_SONY_XPERIA_Z1("Sony Xperia Z1 f Amami Maki SO-02F", "Sony", 
	      "Sony Xperia Z1 f Amami Maki SO-02F", "ANDROID", "4.4.2", 1021L),
	  ANDROID_SONY_XPERIA_Z1_SOL23("Sony Xperia Z1 SOL23 (Honami Anna)", "Sony", 
	      "Xperia Z1 SOL23 (Honami Anna)", "ANDROID", "4.4.2", 1134L),
	  ANDROID_SONY_XPERIA_Z1_COMPACT("Sony Xperia Z1 Compact D5503 (Sony Amami)", "Sony", 
	      "Xperia Z1 Compact D5503 (Sony Amami)", "ANDROID", "5.1.1", 1228L),
	  ANDROID_SONY_XPERIA_Z1_HONAMI("Sony Xperia Z1 C6903 (Honami)", "Sony", 
	      "Sony Xperia Z1 C6903 (Honami)", "ANDROID", "5.1.1", 1229L),
	  ANDROID_SONY_XPERIA_Z2("Sony Xperia Z2 D6503", "Sony", "Xperia Z2 D6503", "ANDROID", "5.1.1",
	      1227L),
	  ANDROID_SONY_XPERIA_Z3_PLUS("Sony Xperia Z3+ E6553", "Sony", "Xperia Z3+ E6553", "ANDROID", 
	      "5.0.2", 1219L),
	  ANDROID_SONY_XPERIA_Z3("Sony Xperia Z3 D6603", "Sony", "Xperia Z3 D6603", "ANDROID", "5.1.1",
	      1226L),
	  ANDROID_SONY_XPERIA_ZL("Sony Xperia ZL C6502", "Sony", "Xperia ZL C6502", "ANDROID", "5.1.1",
	      1135L),
	  ANDROID_SONY_XPERIA_ZR("Sony Xperia ZR C5502", "Sony", "Xperia ZR C5502", "ANDROID", "5.0.2",
	      1164L),
	  ANDROID_SONY_XPERIA_Z5("Sony Xperia Z5 E6653 6.0", "Sony", "Xperia Z5 E6653 6.0", "ANDROID", 
	      "6.0", 1388L),
	  ANDROID_SONY_XPERIA_Z5_E6653("Sony Xperia Z5 E6653 6.0.1", "Sony", "Xperia Z5 E6653 6.0.1", 
	      "ANDROID", "6.0.1", 1626L),
	  ANDROID_SONY_XPERIA_TSUBASA("Sony Xperia Tsubasa LT25i", "Sony", "Xperia Tsubasa LT25i", 
	      "ANDROID", "4.4.2", 1021L),
	  ANDROID_SONY_XPERIA_D5303("Sony Xperia D5303 T2 Ultra -US", "Sony", "Xperia D5303 T2 Ultra -US", 
	      "ANDROID", "5.0.2", 1095L),
	  ANDROID_SONY_TABLET_S("Sony Tablet S SGPT111US/S", "Sony", "Tablet S SGPT111US/S", 
	      "ANDROID", "4.0.3", 324L),
	  ANDROID_SONY_TABLET_Z("Sony Xperia Tablet Z", "Sony", "Xperia Tablet Z", "ANDROID", "5.1.1", 
	      1376L),
	  ANDROID_SPICE_DREAM("Spice Dream UNO Mi-498", "Spice", "Dream UNO Mi-498", "ANDROID", "5.1.1",
	      1122L),
	  ANDROID_TOSHIBA_THRIVE("Toshiba Thrive AT100", "Toshiba", "Thrive AT100", "ANDROID", "4.0.4", 
	      358L),
	  ANDROID_XIAOMI_MI_NOTE("Xiaomi MI NOTE LTE", "Xiaomi", "MI NOTE LTE", "ANDROID", "6.0.1", 1383L),
	  ANDROID_XIAOMI_MI_1S("Xiaomi MI 1S", "Xiaomi", "MI 1S", "ANDROID", "4.0.4", 401L),
	  ANDROID_XIAOMI_MI_3("Xiaomi MI 3 (Tegra 4 Powered)", "Xiaomi", "MI 3 (Tegra 4 Powered)", 
	      "ANDROID", "4.4.4", 1401L),
	  ANDROID_XIAOMI_MI_4C("Xiaomi MI 4c", "Xiaomi", "MI 4c", "ANDROID", "5.1.1", 1268L),
	  ANDROID_XIAOMI_MI_4I("Xiaomi MI 4i", "Xiaomi", "MI 4i", "ANDROID", "5.0.2", 1220L),
	  ANDROID_XIAOMI_MI_NOTE_PRO("Xiaomi MI Note Pro (Leo)", "Xiaomi", "MI Note Pro (Leo)", "ANDROID", 
	      "5.1.1", 1218L),
	  ANDROID_XIAOMI_REDMI_1S("Xiaomi Redmi 1S", "Xiaomi", "Redmi 1S", "ANDROID", "4.3", 861L),
	  ANDROID_XIAOMI_REDMI_2A("Xiaomi Redmi 2A", "Xiaomi", "Redmi 2A", "ANDROID", "4.4.4", 1265L),
	  ANDROID_XIAOMI_REDMI_3("Xiaomi Redmi 3", "Xiaomi", "Redmi 3", "ANDROID", "5.1.1", 1267L),
	  ANDROID_XIAOMI_REDMI_NOTE_3("Xiaomi Redmi Note 3", "Xiaomi", "Redmi Note 3", "ANDROID", 
	      "5.0.2", 1404L),
	  ANDROID_YOTA_PHONE_2("Yota Phone 2 YD201", "Yota", "Phone 2 YD201", "ANDROID", "4.4.3", 942L),
	  ANDROID_ZTE("ZTE Blade Apex 2", "ZTE", "Blade Apex 2", "ANDROID", "4.4.2", 890L),
	  ANDROID_ZTE_V5_RED_BULL("ZTE V5 Red Bull U9180", "ZTE", "V5 Red Bull U9180", "ANDROID", "4.3", 
	      891L),
	  IOS_IPHONE_3GS("Apple iPhone 3GS A1303 6.1.6", "Apple", "iPhone 3GS A1303", "IOS", "6.1.6", 532L),
	  IOS_IPHONE_4S_8_4("Apple iPhone 4S A1387 8.4.1", "Apple", "iPhone 4S A1387", "IOS", "8.4.1", 54L),
	  IOS_IPHONE_4S_8_3("Apple iPhone 4S A1387 8.3", "Apple", "iPhone 4S A1387", "IOS", "8.3", 1161L),
	  IOS_IPHONE_4S_9_2("Apple iPhone 4S A1387 9.2.1", "Apple", "iPhone 4S A1387", "IOS", "9.2.1", 
	      1115L),
	  IOS_IPHONE_6("Apple iPhone 6 A1586 9.2.1", "Apple", "IPHONE 6 A1586", "IOS", "8.2", 1109L), 
	  IOS_IPHONE_6S("Apple iPhone 6S A1688 9.2.1", "Apple", "Apple iPhone 6S A1688", "IOS", "9.2.1", 
	      1168L),
	  IOS_IPHONE_6_PLUS("Apple iPhone 6 Plus A1524 9.2.1", "Apple", "iPhone 6 Plus A1524", "IOS",
	      "9.2.1", 822L),
	  IOS_IPHONE_5("Apple iPhone 5 A1429 9.2.1", "Apple", "iPhone 5 A1429", "IOS", "9.2.1", 1160L),
	  IOS_IPHONE_5_8_4("Apple iPhone 5 A1429 8.4.1", "Apple", "iPhone 5 A1429", "IOS", "8.4.1", 810L),
	  IOS_IPHONE_5_8_2("Apple iPhone 5 A1429 8.2", "Apple", "iPhone 5 A1429", "IOS", "8.2", 899L),
	  IOS_IPHONE_5S("Apple iPhone 5S A1457 7.1", "Apple", "iPhone 5S A1457", "IOS", "7.1", 745L), 
	  IOS_IPHONE_5S_9("Apple iPhone 5S A1457 9.0.2", "Apple", "iPhone 5S A1457", "IOS", "9.0.2", 1113L),
	  IOS_IPHONE_5S_8_3("Apple iPhone 5S A1457 8.3", "Apple", "iPhone 5S A1457", "IOS", "8.3", 1159L),
	  IOS_IPHONE_5C("Apple iPhone 5C A1532 8.1", "Apple", "iPhone 5C A1532", "IOS", "8.1", 827L),
	  IOS_IPHONE_5C_7("Apple iPhone 5C A1532 7.1.2", "Apple", "iPhone 5C A1532", "IOS", "7.1.2", 552L),
	  IOS_IPHONE_5C_9("Apple iPhone 5C A1532 9.2.1", "Apple", "iPhone 5C A1532", "IOS", "9.2.1", 1114L),
	  IOS_IPAD_MINI_8("Apple iPad Mini A1432 8.0.2", "Apple", "iPad Mini A1432", "IOS", "8.0.2", 803L), 
	  IOS_IPAD_MINI_8_1("Apple iPad Mini A1432 8.1", "Apple", "iPad Mini A1432", "IOS", "8.1", 18L), 
	  IOS_IPAD_MINI_8_4("Apple iPad Mini A1432 8.4.1", "Apple", "iPad Mini A1432", "IOS", "8.4.1", 11L), 
	  IOS_IPAD_MINI_9("Apple iPad Mini A1432 9.2.1", "Apple", "iPad Mini A1432", "IOS", "9.2.1", 1117L),
	  IOS_IPAD_MINI_2("Apple iPad Mini 2 A1489 7.1.2", "Apple", "iPad Mini 2 A1489", "IOS", "7.1.2",
	      823L),
	  IOS_IPAD_MINI_2_9_2("Apple iPad Mini 2 A1489 9.2.1", "Apple", "iPad Mini 2 A1489", "IOS", "9.2.1",
	      1116L),
	  IOS_IPAD_MINI_2_8_4("Apple iPad Mini 2 A1489 8.4", "Apple", "iPad Mini 2 A1489", "IOS", "8.4",
	      1155L),
	  IOS_IPAD_MINI_3("Apple iPad Mini 3 A1599 9.2.1", "Apple", "iPad Mini 3 A1599", "IOS", "9.2.1",
	      1110L),
	  IOS_IPAD_MINI_3_8_1("Apple iPad Mini 3 A1599 8.1", "Apple", "iPad Mini 3 A1599", "IOS", "8.1",
	      1162L),
	  IOS_IPAD_2_A1395("Apple iPad 2 A1395 7.0.4", "Apple", "iPad 2 A1395", "IOS", "7.0.4", 62L),
	  IOS_IPAD_3("Apple iPad 3 A1416 8.2", "Apple", "iPad 3 A1416", "IOS", "8.2", 747L),
	  IOS_IPAD_4_A1459("Apple iPad 4 A1459 9.2.1", "Apple", "iPad 4 A1459", "IOS", "9.2.1", 1118L),
	  IOS_IPAD_4_A1458("Apple iPad 4 A1458 8.4", "Apple", "iPad 4 A1458", "IOS", "8.4", 1157L),
	  IOS_IPAD_4_A1458_8_4_1("Apple iPad 4 A1458 8.4.1", "Apple", "iPad 4 A1458", "IOS", "8.4.1", 52L),
	  IOS_IPOD_TOUCH("Apple iPod Touch 4Gen A1367 6.1.6", "Apple", "iPod Touch 4Gen A1367", "IOS", 
	      "6.1.6", 14L),
	  IOS_IPAD_AIR_A1474("Apple iPad Air A1474 7.0.3", "Apple", "iPad Air A1474", "IOS", "7.0.3", 576L),
	  IOS_IPAD_AIR_A1474_9("Apple iPad Air A1474 9.0.2", "Apple", "iPad Air A1474", "IOS", "9.0.2", 
	      1112L),
	  IOS_IPAD_AIR_A1474_8("Apple iPad Air A1474 8.3", "Apple", "iPad Air A1474", "IOS", "8.3", 1158L),
	  IOS_IPAD_AIR_A1474_8_1("Apple iPad Air A1474 8.1.3", "Apple", "iPad Air A1474", "IOS", "8.1.3",
	      1163L),
	  IOS_IPAD_AIR_2_A1566("Apple iPad Air 2 A1566 9.2.1", "Apple", "iPad Air 2 A1566", "IOS", "9.2.1",
	      1108L),
	  IOS_IPAD_PRO("Apple iPad Pro A1584 9.1", "Apple", "iPad Pro A1584", "IOS", "9.1", 1361L),
	  ANDROID_DEVICES("", "", "", "ANDROID", "", 0L), 
	  IOS_DEVICES("", "", "", "IOS", "", 0L), 
	  DEFAULT("", "", "", "", "", 0L);

	  private String deviceName;
	  private String brand;
	  private String model;
	  private String os;
	  private String osVersion;
	  private Long id;
	  private String udid;
	  private int deviceFarmPort;

	  /**
	   * Class constructor
	   *
	   * @param deviceName
	   *          Name of the device as it appears in TestDroid
	   * @param brand
	   *          Device Brand
	   * @param model
	   *          Device model
	   * @param os
	   *          Device os
	   * @param osVersion
	   *          Device OS version
	   * @param id
	   *          TestDroid Device id
	   */
	  private Device(final String deviceName, final String brand, final String model, final String os,
	      final String osVersion, final Long id) {
	    this.deviceName = deviceName;
	    this.brand = brand;
	    this.model = model;
	    this.os = os;
	    this.osVersion = osVersion;
	    this.id = id;
	  }

	  /**
	   * Class constructor
	   *
	   * @param deviceName
	   *          Name of the device as it appears in TestDroid
	   * @param brand
	   *          Device Brand
	   * @param model
	   *          Device model
	   * @param os
	   *          Device os
	   * @param osVersion
	   *          Device OS version
	   * @param id
	   *          TestDroid Device id
	   * @param udid
	   *          Device UDID
	   */
	  private Device(final String deviceName, final String brand, final String model, final String os,
	      final String osVersion, final Long id, final String udid, final int deviceFarmPort) {
	    this.deviceName = deviceName;
	    this.brand = brand;
	    this.model = model;
	    this.os = os;
	    this.osVersion = osVersion;
	    this.id = id;
	    this.udid = udid;
	    this.deviceFarmPort = deviceFarmPort;
	  }
	  
	  private static final Map<Long, Device> deviceMap;
	  static {
	    deviceMap = new HashMap<Long, Device>();
	    for (final Device v : Device.values()) {
	      deviceMap.put(v.id, v);
	    }
	  }

	  public static Device findByKey(final long i) {
	    return deviceMap.get(i);
	  }

	  public Long getDeviceId() {
	    return id;
	  }

	  public String getDeviceName() {
	    return deviceName;
	  }

	  public String getDeviceBrand() {
	    return brand;
	  }

	  public String getDeviceModel() {
	    return model;
	  }

	  public String getDeviceOs() {
	    return os;
	  }

	  public String getDeviceOsVersion() {
	    return osVersion;
	  }
	  
	  public String getDeviceUdid() {
	    return udid;
	  }
	  
	  public int getDeviceFarmPort() {
	    return deviceFarmPort;
	  }
	}
