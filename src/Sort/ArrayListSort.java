package Sort;

import java.util.ArrayList;

public class ArrayListSort {
    public static int FindPosicion(ArrayList<Integer> array,int Comparando){
        int len=array.size();
        int PositionReturn=-1;
        for(int i=0;i<len;i++){
            if(array.get(i)==Comparando){
                PositionReturn=i;
            }

        }
        return PositionReturn;
    }
}
