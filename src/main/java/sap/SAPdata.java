package sap;


import client.MapElements;
import client.MapElementsArray;
import client.WebData;
import client.WebDataImplService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class SAPdata extends JFrame {
    private static String tabName;
    private static String rowQuan;
    private static String lang;
    private static String condition;
    private static String order;
    private static String group;
    private static String fields;
    private static int rows;
    private static boolean naming;
    private Map<String, List<String>> data = new LinkedHashMap<>();


    // constructors
    public SAPdata(String tableName, String rowQuantity, String language, String where, String orderBy, String groupBy,
                   String fieldNames, boolean namingOfFields) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = where;
        order = orderBy;
        group = groupBy;
        fields = fieldNames;
        naming = namingOfFields;

    }

    public SAPdata(String tableName, String rowQuantity, String language, String where, String orderBy, String groupBy,
                   String fieldNames) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = where;
        order = orderBy;
        group = groupBy;
        fields = fieldNames;
        naming = false;

    }

    SAPdata(String tableName, String rowQuantity, String language, String where, String orderBy, String groupBy) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = where;
        order = orderBy;
        group = groupBy;
        fields = "";
        naming = false;

    }

    SAPdata(String tableName, String rowQuantity, String language, String where, String orderBy) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = where;
        order = orderBy;
        group = "";
        fields = "";
        naming = false;

    }

    SAPdata(String tableName, String rowQuantity, String language, String where) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = where;
        order = "";
        group = "";
        fields = "";
        naming = false;
    }

    SAPdata(String tableName, String rowQuantity, String language) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = language;
        condition = "";
        order = "";
        group = "";
        fields = "";
        naming = false;
    }

    SAPdata(String tableName, String rowQuantity) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = rowQuantity;
        lang = "E";
        condition = "";
        order = "";
        group = "";
        fields = "";
        naming = false;
    }

    SAPdata(String tableName) {

        //set title to frame
        super(tableName);

        // set params
        tabName = tableName;
        rowQuan = Integer.toString(rows);
        lang = "E";
        condition = "";
        order = "";
        group = "";
        fields = "";
        naming = false;
    }

    public Map<String, List<String>> getData() {
        return data;
    }

    // call sap interface
    public void getFrame() {
        JTable table = new JTable();
        table.setAutoCreateRowSorter(true);

        // model of filling table
        DefaultTableModel tableModel = new DefaultTableModel();

        // get map for table
        WebData wd = new WebDataImplService().getWebDataImplPort();
        MapElementsArray webMap = wd.getWebMapa(tabName, rowQuan, lang, condition, order, group, fields)
                .getRealMap();

        for (MapElements mapEl : webMap.getItem()) {
            data.put(mapEl.getKey(), mapEl.getValue());
        }

        for (String k : data.keySet()) {
            Object[] obj = data.get(k).toArray();

            // get quantity of rows in table
            rows = obj.length;
            if (naming) {
                wd.getFieldName().indexOf(k);
                String rep = wd.getRepText().get(wd.getFieldName().indexOf(k));
                tableModel.addColumn(rep, obj);
            } else
                tableModel.addColumn(k, obj);

        }

        // interface settings for table
        table.setModel(tableModel);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        Font font = new Font("", Font.PLAIN, 15);
        table.setFont(font);
        table.setRowHeight(20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // !!!! to enable scrolls

        // set width of columns
        int columnNumber = 0;
        for (String leng : wd.getColumnLeng()) {
            int length = Integer.parseInt(leng) * 10;
            int columnLeng = table.getColumnModel().getColumn(columnNumber).getWidth();
            if (length > columnLeng) {
                table.getColumnModel().getColumn(columnNumber).setMinWidth(length);
            } else
                table.getColumnModel().getColumn(columnNumber).setMinWidth(columnLeng);
            columnNumber++;
        }

        wd.clear();
        // enable scrolls (horizontal and vertical) for table. It possible only when "JTable.AUTO_RESIZE_OFF"!!!!!!
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.CENTER);

        // set button and panel of buttons
        JButton findAllButton = new JButton("find all");
        JPanel buttons = new JPanel(new GridLayout(0, 3));
        buttons.setMaximumSize(new Dimension(300, 100));
        buttons.add(findAllButton);

        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.PAGE_AXIS));
        controls.add(buttons);
        controls.add(Box.createVerticalGlue());

        this.add(controls, BorderLayout.EAST);
        this.setSize(900, 400);
    }
}