public class StatsCalculatorTester {
    public static void main(String[] args) {
        double[ ] data1 = {10.0, 20.0, 5.0, 15.0, 25.0, 30.0, 8.0};
//create a StatsCalculator object
        double[ ] data = {1,2,3,4,5,6};

//create a StatsCalculator object
        StatsCalculator myCalculator = new StatsCalculator(data);

        myCalculator.print();
        myCalculator.sortData();
        myCalculator.printSorted();
        myCalculator.printFiveNumberSummary();
        System.out.println("\nThe mean is " + myCalculator.calculateMean());
    }
}
