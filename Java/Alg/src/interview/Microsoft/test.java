package interview.Microsoft;

import java.lang.Math;
class test
{
    public static void main (String[] args) {
        int[] plantHeight = {3,2,1,2,3,2,1,5,4,3,2,1,5,4};
        int numOfPlants = plantHeight.length;
        int res = numberOfDays(plantHeight,numOfPlants);
        System.out.println(res);
    }

    public static int numberOfDays(int[] plantHeight,int numOfPlants) {

        int[] p = new int[numOfPlants];
        int[] m = new int [numOfPlants];
        int[] f = new int [numOfPlants];
        p[0] = -1;
        m[0] = 0;
        f[0] = 0;// 表示不会被移除
        for(int i = 1 ;i < numOfPlants;i++){
            if(p[i] == -1) continue;
            int j = i-1;
            int max = 0;
            while(j >= 0){
                if(plantHeight[j] < plantHeight[i]){
                    p[i] = j;
                    m[i] = max;
                    f[i] = max+1;
                    break;
                } else {
                    max = Math.max(f[j],max);
                    j = p[j];
                }
            }
            if(j==-1)p[i] = j;
        }

        int res = 0;
        for(int k = 0; k < numOfPlants;k++){
            res = Math.max(res,f[k]);
        }
        return res;
    }

}