package algorithm;

/**
 * Musterloesung der Klasse <code>Sort</code> der ASB-Programmieraufgabe
 * <i>Bubble- und Quicksort</i>. Die Klasse stellt alle geforderten statischen
 * Methoden zur Verfuegung.
 */
public class Sort {
    /**
     * Sortiert das Feld <code>list<code> in aufsteigender Reihenfolge 
     * unter Verwendung des BubbleSort-Algorithmus.
     * 
     * @param list - Die zu sortierende Liste.
     */
    public static void bubbleSort(int[] list) {
        bubbleSort(list,0,list.length-1);
    }
    
    /**
     * Sortiert den Feldabschnitt list[leftIdx - rightIdx] in aufsteigender
     * Reihenfolge unter Verwendung des BubbleSort-Algorithmus.
     * 
     * @param list     - Die zu sortierende Liste.
     * @param leftIdx  - Index, ab dem sortiert werden soll.
     * @param rightIdx - Index, bis zu dem sortiert werden soll.
     */
    public static void bubbleSort(int[] list, int leftIdx, int rightIdx) {
        checkIndices(list.length, leftIdx, rightIdx);
        for(int i =rightIdx; i > leftIdx; i--)
            bubbleUp(list,leftIdx,i);
    }
    
    /**
     * Laesst das groesste Element des Feldabschnitts <code>list
     * [leftIdx bis i]</code> an die Position <code>i</code> aufsteigen.
     * 
     * @param list    - Liste in der das groesste Element hoch <i>bubbelt</i>.
     * @param leftIdx - Der linke Feldindex.
     * @param i       - Der rechte Feldindex.
     */
    public static void bubbleUp(int[] list, int leftIdx, int i) {
        checkIndices(list.length, leftIdx, i);
        while(leftIdx < i) {
            if(list[leftIdx] > list[leftIdx+1])
                swap(list,leftIdx+1,leftIdx);
            ++leftIdx;
        }
    }
    
    /**
     * Sortiert das Feld <code>list<code> in aufsteigender Reihenfolge 
     * unter Verwendung des QuickSort-Algorithmus.
     * 
     * @param list - Die zu sortierende Liste.
     */
    public static void quickSort(int[] list) {
        quickSort(list,0,list.length-1);
    }
    
    /**
     * Sortiert das Feld <code>list<code> in aufsteigender Reihenfolge 
     * unter Verwendung des QuickSort-Algorithmus.
     * 
     * @param list     - Die zu sortierende Liste.
     * @param leftIdx  - Index, ab dem sortiert werden soll.
     * @param rightIdx - Index, bis zu dem sortiert werden soll.
     */
    public static void quickSort(int[] list, int leftIdx, int rightIdx) {
        checkIndices(list.length,leftIdx,rightIdx);
        if(leftIdx < rightIdx) {
            int pivotIdx = divide(list,leftIdx,rightIdx);
            if(pivotIdx > 0)
                quickSort(list,leftIdx, pivotIdx-1);
            if(pivotIdx < rightIdx)
                quickSort(list,pivotIdx+1,rightIdx);
        }
    }
    
    /**
     * Wahl des letzten Element des Feldabschnitts <code>list[rightIdx]</code>
     * als Pivot- Element. Aufteilung des Feldabschnitts <code>list[leftIdx bis
     * rightIdx]</code> in zwei Teile, wobei alle Elemente des linken Teils
     * kleiner und alle Elemente des rechten Teils groesser oder gleich dem
     * Pivot-Element sind. <br />
     * 
     * @param list     - Die zu sortierende Liste.
     * @param leftIdx  - Index, ab dem sortiert werden soll.
     * @param rightIdx - Index, bis zu dem sortiert werden soll.
     * @return Index des Pivot-elements.
     */
    public static int divide(int[] list, int leftIdx, int rightIdx) {
        checkIndices(list.length,leftIdx,rightIdx);
        int pivot = list[rightIdx];
        int l = leftIdx;
        int r = rightIdx-1;
        do {
            while(l < list.length-1 && list[l] < pivot)
                ++l;
            while(r > 0 && list[r] >= pivot)
                --r;
            if(l < r)
                swap(list,l,r);
        } while(l < r);
        swap(list,l,rightIdx);
        return l;
    }
    
    /**
     * Tauscht zwei Elementen in einem <code>int</code>-Array.
     * 
     * @param list - Das <code>int</code>-Array.
     * @param i    - Index des Quellelements.
     * @param j    - Index des Zielelements.
     */
    public static void swap(int[] list, int i, int j) {
        checkIndices(list.length, i, j);
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
    
     /**
     * Stringumwandlung des uebergebenen <code>int</code>-Arrays.
     * 
     * @param list  - Das <code>int</code>-Array.
     * @param start - Index Arraybeginn
     * @param end   - Index Arrayende
     * @return Stringrepraesentation der Liste.
     */
    public static String toString(int[] list, int start, int end) {
        checkIndices(list.length, start, end);
        String res = "[ ";
        for(int i=start; i <= end; i++)
            res += list[i] + " ";
        res += "]";
        return res;
    }
    
     /**
     * Stringumwandlung aller Feldelemente des uebergebenen <code>int</code>
     * -Array.
     * 
     * @param list - Das <code>int</code>-Array.
     * @return Stringrepraesentation der Liste.
     */
    public static String toString(int[] list) {
        return toString(list,0,list.length-1);
    }
    
     /**
     * Hilfsmethode zur Ueberwachung der Bereichsgrenzen
     * 
     * @param length - Array-Laenge
     * @param start  - Index Array-Beginn
     * @param end    - Index Array-Ende
     */
    private static void checkIndices(int length, int leftIdx, int rightIdx) {
        if(leftIdx < 0 || leftIdx >= length)
            throw new IllegalArgumentException(String.format(
                "Leftindex = {%d} liegt ausserhalb der Arraygrenzen!",leftIdx));
        else if(rightIdx < 0 || rightIdx >= length)
            throw new IllegalArgumentException(String.format(
                "Rightindex = {%d} liegt ausserhalb der Arraygrenzen!",rightIdx));
    }
}
