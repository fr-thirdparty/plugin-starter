package com.voc.fr.plugin;

/**
 * @author Wu Yujie
 * @email coffee377@dingtalk.com
 * @time 2019/09/06 00:06
 */
public class Columns {


    /**
     * 该方法用来将列号字符串转换成具体的数字
     *
     * @param column:ABCD列名称
     * @return integer：将字母列名称转换成数字
     **/
    public static int colStr2Num(String column) {
        int num;
        int result = 0;
        int length = column.length();
        for (int i = 0; i < length; i++) {
            char ch = column.charAt(length - i - 1);
            num = ch - 'A' + 1;
            num *= Math.pow(26, i);
            result += num;
        }
        return result;
    }

    public static String colIndex2Str(int columnIndex) {
        if (columnIndex <= 0) {
            return null;
        }
        StringBuilder columnStr = new StringBuilder();
        columnIndex--;
        do {
            if (columnStr.length() > 0) {
                columnIndex--;
            }
            columnStr.insert(0, ((char) (columnIndex % 26 + (int) 'A')));
            columnIndex = (columnIndex - columnIndex % 26) / 26;
        } while (columnIndex > 0);
        return columnStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(colStr2Num("A"));//1
        System.out.println(colStr2Num("B"));//2
        System.out.println(colStr2Num("AA"));//27
        System.out.println(colStr2Num("AB"));//28

        System.out.println(colIndex2Str(28));//AB
        System.out.println(colIndex2Str(29));//AC
    }

}
