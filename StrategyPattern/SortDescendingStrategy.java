package StrategyPattern;


public class SortDescendingStrategy implements ISortStrategy {

    @Override
    public boolean compare(int a, int b) {
        return a < b;
    }

}
