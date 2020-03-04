package Sort;

import java.util.ArrayList;

public class ArrayListSort {
    /**
     * Finds the position of an in into an Integer arrayList a return its or return -1 if dont fit with any
     * @param array The arrayList which will be tacked
     * @param Comparando The int that will be finding in the array
     * @return A int with the position
     */
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
