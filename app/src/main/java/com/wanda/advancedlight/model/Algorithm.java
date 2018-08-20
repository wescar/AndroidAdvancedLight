package com.wanda.advancedlight.model;

/**
 * 算法
 * Created by PC on 2018/8/16.
 */

public class Algorithm{

    /**
     * 冒泡排序
     * @param aar
     */
    public static void BubbleSort(int[] aar){
        int temp;
        for (int i=0;i<aar.length-1;i++){
            for (int j=aar.length-1;j>i;j--){
                if (aar[j]<aar[j-1]){
                    temp = aar[j];
                    aar[j]=aar[j-1];
                    aar[j-1]=temp;
                }

            }
        }

    }

    /**
     * 选择排序
     * @param array
     * @param length
     */
    public static void SelectionSort(int array[],int length){

        for (int i=0;i<length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<length;j++){
                if (array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = array[i];
                array[i]= array[minIndex];
                array[minIndex] = temp;

            }

        }

    }

    /**
     * 插入排序
     * @param array
     * @param length
     */

    public static void InsertionSort(int array[] , int length){
        int temp;
        for (int i=0;i<length-1;i++){
            for (int j= i+1;j>0;j--){
                if (array[j]<array[j-1]){
                    temp = array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }else {
                    break;
                }

            }
        }

    }
}
