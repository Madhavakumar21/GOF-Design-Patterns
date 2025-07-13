package StrategyPattern;


public class SortAscendingStrategy implements ISortStrategy {

    @Override
    public boolean compare(int a, int b) {
        return a > b;
    }

}
