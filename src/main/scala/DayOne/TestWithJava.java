package DayOne;

import java.util.ArrayList;

public class TestWithJava {
    static boolean checkArray(int[] a,int arr_size,int sum){
        int l,r;
        l=0;
        r= arr_size-1;
        while(l<r) {
            if(a[l]+a[r] ==sum) return true;
            else if(a[l]+a[r]<sum) l+=1;
            else r-=1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(checkArray(arr,7,400));

    }
}
