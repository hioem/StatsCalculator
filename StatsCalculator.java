import java.util.Arrays;
/**
 * @file StatsCalculator.java
 * @author Matthew Hioe
 * @date 3/16/23
 * @description starts out with a default constructor, but then creates an array based on the tester file in a constructor, also creates a 5 number summary
 */
public class StatsCalculator{
    //private arrays
    private double[] values;
    private double[] sorted;
    /**
     * @descripton StatsCalculator() - default with length of 20
     */

    public StatsCalculator() {
        values=new double[20];
    }
    /**
     * @param value which sets the array
     * @description this sets the value of that array to the array in the class, so it can be used.
     */
    public StatsCalculator(double[] value){
        values=value;
    }
    /**
     * @description sorts the data in numerical order
     */
    public void sortData(){
        sorted=values;
        Arrays.sort(sorted);

    }

    /**
     * @description finds the max in the array
     * @returns the max in the values array as a double
     */
    public double calculateMax() {
        double max=values[0];
        for (int i=0;i<values.length;i++){
            if (max<values[i]) {
                max=values[i];
            }
        }
        return max;
    }
    /**
     * @description uses a for loop to min the min in the array
     * @returns the min in the values array as a double
     */
    public double calculateMin() {
        double min = values[0];
        for (int i=0;i<values.length;i++){
            if (min>values[i]){
                min=values[i];
            }
        }
        return min;
    }
    /**
     * @description sorts the array and finds the first quartile; accounts for if the length of the array is odd or even
     * @returns the first quartile value in the "sorted" array
     */
    public double calculateFirstQuartile(){
        sortData();
        double[] first;
        first = new double[sorted.length/2];
        int i=0;
        while(i<first.length){
            first[i] = sorted[i];
            i++;
        }
        if(first.length%2==1) {
                return first[first.length/2];
            }
        else{
                return (first[first.length/2]+first[first.length/2-1])/2.0;
        }
    }
    /**
     * @description sorts the array and finds the third quartile; accounts for if the length of the array is odd or even
     * @returns the third quartile value in the "sorted" array (was a little more complicated than I thought it would be(Gracie helped me a litte...))
     */
    public double calculateThirdQuartile(){
        sortData();
        double [] second;
        if (sorted.length%2!=1) {
            second=new double [sorted.length/2];
            int last=0;
            for(int i=sorted.length/2;i<sorted.length-1;i++){
                second[last]=sorted[i];
                last++;
            }
            if(second.length%2==1){
                return second[second.length/2];
            }
            else{
                return (second[second.length/2]+second[second.length/2-1])/2.0;
            }
        } else  {
            second=new double[sorted.length/2];
            int last1=0;
            for(int i =sorted.length/2+1;i<sorted.length;i++){
                second[last1]=sorted[i];
                last1++;
            }
            if(second.length%2==1) {
                return second[second.length/2];
            }
            else{
                return (second[second.length/2]+second[second.length/2-1])/2;
            }
        }
    }
    /**
     * @descripton finds the median from the sorted array.
     * @return the median
     */
    public double calculateMedian(){
        sortData();
        int num=0;
        if (sorted.length%2==1) {
            return sorted[sorted.length/2];
        }
        else{
            return (sorted[sorted.length/2-1] + sorted[sorted.length/2])/2.0;

        }
    }

    /**
     * @description the sum of the whole array
     * @returns sum
     */
    public double calculateSum(){
        double sum=0;
        for (int i=0;i<values.length;i++){
            sum=sum+values[i];
        }
        return sum;
    }

    /**
     * @description it will calculate the mean of the array
     * @return it'll return the mean of the array
     */
    public double calculateMean(){
        return calculateSum()/values.length;
    }

    /**
     * @description prints out the entire array without any order
     */
    public void print(){
        for (int i=0;i<values.length-1;i++){
            System.out.print(values[i]+" ");
        }
        System.out.println();
    }
    /**
     * @description sorts all the data in numerical order
     */
    public void printSorted(){
        for (int i=0; i<sorted.length-1;i++){
            System.out.print(values[i]+" ");
        }
        }
    /**
     * @description what this does is print the 5 number summary which includes the printing of the mean, median, first and third quartile, and the min and max.
     */
    public void printFiveNumberSummary(){
        System.out.println();
        System.out.println("This is the 5 number summary: ");
        System.out.println("\tMin: " + calculateMin());
        System.out.println("\tFirst Q: " + calculateFirstQuartile());
        System.out.println("\tMed: " + calculateMedian());
        System.out.println("\tThird Q: " + calculateThirdQuartile());
        System.out.println("\tMax: " + calculateMax());
    }
}
