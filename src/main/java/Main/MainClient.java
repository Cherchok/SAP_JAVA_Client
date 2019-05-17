package Main;

import sap.SAPdata;

import javax.swing.*;
//import java.util.List;
//import java.util.Map;

public class MainClient {

    // Наименование таблицы
    private static String p1 = "T001";
    // Количество строк "200"
    private static String p2 = "100";
    // Язык "R"
    private static String p3 = "R";
    // Условие выборки "MATNR >= '000000000100000029' AND MATNR <= '000000000300000042'"
    private static String p4 = "";
    // Сортировка "<AENAM MATKL ERNAM BISMT bbbbb LAEDA VPSTA LVORM MATNR MTART"
    private static String p5 = "";
    // Группировка-агрегирование
    private static String p6 = "";
    // Список полей "MATKL ERNAM BISMT KKKKK LAEDA AENAM VPSTA GGGG LVORM MATNR MTART"
    private static String p7 = "";
    // Именование полей (true) - словестные (false) - технические
    private static boolean p8 = false;

    public static void main(String[] argv) {

        SwingUtilities.invokeLater(() -> {
            try {
                SAPdata sapData = new SAPdata(p1, p2, p3, p4, p5, p6, p7, p8);

                // returns sap table UI
                sapData.getFrame();
                sapData.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                sapData.setLocationRelativeTo(null);
                sapData.setVisible(true);

//                //returns sap data Map
//                Map<String, List<String>> dataMap = sapData.getData();
//                for (String k : dataMap.keySet()) {
//                    System.out.println(k + ": " + dataMap.get(k));
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
