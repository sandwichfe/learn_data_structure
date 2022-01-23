package com.lww.t01_稀疏数据_sparesAraary;

/**
 * @author lww
 * @version 1.0
 * @description: 稀疏数组的使用
 * @date 2022/1/23 20:54
 */
public class SparseArray {
    /**
     * 稀疏数组的应用
     *  用于将二维数组例如五子棋棋盘等等 有大量重复在元素在里面时 可转换为稀疏数组
     *  保存在磁盘上 以此节约空间
     *  在需要用时在恢复为正常二维数组
     *                                                                              行  列   值
     * 0	0	0	0	0	0	0	0	0	0	0                                   11	11	3     //第一行记录 有几列几行 有效记录值有几个
     * 0	0	0	0	0	6	0	0	0	0	0                                   1	5	6
     * 0	0	0	0	8	0	0	0	0	0	0                                   0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0                                   0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	100	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     */

    /**
     * 以下假如为一个11*11的棋盘二维数组
     * 0：表示没有棋子  1为黑棋   2为白棋
     */
    /*** 行 */
    private static final int ROW = 11;
    /*** 列 */
    private static final int COLUMNS = 11;
    private static int[][] chessArray = new int[ROW][COLUMNS];

    public static void main(String[] args) {
        chessArray[2][4] = 8;
        chessArray[1][5] = 6;
        chessArray[8][1] = 100;
        showArray(chessArray);
        System.out.println("xishu");
        int[][] sparseArray = toSparseArray(chessArray);
        showArray(sparseArray);
        System.out.println("huanyuan");
        showArray(spareToNormalArray(sparseArray));
    }

    /**
     * 将普通二维数组转换为稀疏数组
     *
     * @param array 目标数组
     * @return 转换后的稀疏数组
     */
    public static int[][] toSparseArray(int[][] array) {
        // 1. 算出目标数组有多少个有效值  也就是不为重复元素需要被记录的值
        int sum = 0;
        for (int[] arr : array) {
            for (int a : arr) {
                if (a != 0) {
                    sum++;
                }
            }
        }
        /**
         * 根据num数初始化稀疏数组
         * 因为稀疏数组的一维是 固定三个元素
         * 第一行永远都是记录原数组为 几成几排列 然后有效数有几个
         * 下面的行是记录有效数的位置  有几个数就记录几行  行数就为有效数+1
         * 所有此稀疏数组初始化大小就为 int[sum+1][3]
         */
        int[][] spareArray = new int[sum + 1][3];
        //设置第零行的值
        spareArray[0][0] = ROW;
        spareArray[0][1] = COLUMNS;
        spareArray[0][2] = sum;
        // 从第一行开始记录有效值
        int row = 1;
        // 将每一个有效值进行记录转换
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    spareArray[row][0] = i;
                    spareArray[row][1] = j;
                    spareArray[row][2] = array[i][j];
                    row++;
                }
            }
        }
        return spareArray;
    }


    /**
     * 将稀疏数组还原成普通数组    直接遍历赋值即可
     *
     * @param spareArray
     * @return
     */
    public static int[][] spareToNormalArray(int[][] spareArray) {
        int row = spareArray[0][0];
        int column = spareArray[0][1];
        int[][] array = new int[row][column];
        for (int i = 1; i < spareArray.length; i++) {
            int rowIndex = spareArray[i][0];
            int columnIndex = spareArray[i][1];
            int value = spareArray[i][2];
            array[rowIndex][columnIndex] = value;
        }
        return array;
    }


    /**
     * 打印输入一个二维数组
     *
     * @param array
     */
    public static void showArray(int[][] array) {
        //int [][] arr = {{11,45,48},{88,44},{15,47,85,232}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }
    }


}
