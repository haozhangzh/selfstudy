package org.algorithm.quicksort;

public class QuickSort {

	public static void sort(int[] array,int low,int hight){
		int l = low;
		int h = hight;
		// boundary value
		int bv = array[low];
		
		while(l<h){
			while(l<h && array[h]>=bv)
				h--;
			/**
			 * 高位执行交换可保证高位不比 bv小，但是由于存在位置交换，
			 * 所以在 l++ ~ h 区间可能出现不比bv小的数。
			 * 例如
			 * 原数组：3，2，1，5，2，5，4
			 * 经过一遍高位换位之后数组变成 
			 *        2，2，1，5，3，5，4
			 * 3右边的数不小于3，但不是有序，给递归留下必要的证据，左边存在大于3的数       
			 */
			if(l<h){
				int temp = array[h];
				array[h] = array[l];
				array[l] = temp;
				l++;
			}
			while(l<h && array[l]<=bv)
				l++;
			if(l<h){
				int temp = array[l];
				array[l] = array[h];
				array[h] = temp;
				h--;
			}
		}
       if(l>low) sort(array,low,l-1);
       if(h<hight)sort(array,l+1,hight);
	}
	
	public static void print(int[] array){
		for(int i = 0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
	public static void main(String[] args){
		int[] array = {34,12,56,234,56,23,12,78,32,12,1,4,23,651,35,45,0,1,45,1};
		sort(array,0,array.length-1);
		print(array);
	}
}
