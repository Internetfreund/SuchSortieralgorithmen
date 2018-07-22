package algorithm;
import java.util.Arrays;
import algorithm.Sort;

public class Arraysort
{

    public static void main(String[] args)
    {   
        //testarrayy
        int[] array = {2,3,1,6,8,3,42,14};
        System.out.println(Arrays.toString(array));
        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

}
