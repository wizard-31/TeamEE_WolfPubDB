package main.java.wolfpub.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrintUtil {

    public static ArrayList<String[]> rsToList(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int noCols = rsmd.getColumnCount();
        ArrayList<String[]> rsAsString = new ArrayList<>();

        String[] headers = new String[noCols];
        for(int i = 1; i <= noCols; i++)
            headers[i - 1] = rsmd.getColumnLabel(i);
        rsAsString.add(headers);

        while(rs.next()) {
            String[] addToList = new String[noCols];
            for(int i = 1; i <= noCols; i++)
                addToList[i - 1] = rs.getString(i);
            rsAsString.add(addToList);
        }
//        System.out.println("rs list has " + rsAsString.size() + " rows");
        return rsAsString;
    }

    public static int getColSize(ArrayList<String[]> rsList, int colNo) {
        int size = 4;
        for(String[] arr : rsList) {
            if(arr[colNo] != null && size < arr[colNo].length())
                size = arr[colNo].length();
        }
        return size + 2;
    }

    public static void printResultSet(ArrayList<String[]> rsList) {

        int noCols = rsList.get(0).length;
        int[] colSizes = new int[noCols];

        int totalLen = 0;
        for (int i = 0; i < noCols; i++) {
            colSizes[i] = getColSize(rsList, i);
            totalLen += colSizes[i] + 2;
        }

        System.out.println();
        boolean headersPrinted = false;
        for(String[] starr : rsList) {

            if(!headersPrinted) {
                for(int i = 0; i < totalLen; i++) System.out.print("-");
                System.out.println();
            }

            for (int i = 0; i < noCols; i++) {
                int spacingSize = colSizes[i] - (starr[i] == null ? 5 : starr[i].length() + 1);
                StringBuilder spaces = new StringBuilder();
                for(int j = 0; j < spacingSize; j++) spaces.append(" ");
                System.out.print("| " + spaces + starr[i] + " ");
            }

            System.out.print("|\n");
            if(!headersPrinted) {
                headersPrinted = true;
                for(int i = 0; i < totalLen; i++) System.out.print("-");
                System.out.println();
            }
        }
        for(int i = 0; i < totalLen; i++) System.out.print("-");
        System.out.println();
        return;
    }
}