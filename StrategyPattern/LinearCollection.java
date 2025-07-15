/**
 * @file    LinearCollection.java
 * @date    2025-07-15
 * @author  Madhavakumar D
 * @brief   Strategy Pattern
 * 
 * @details 
 *      Contains the basic implementation of Strategy Pattern.
 *      
 *      Problem Statement:
 *          We want to implement a custom data-structure called LinearCollection, 
 *          which will act as a wrapper class that encapsulates Array related methods with an array. 
 *          One such method that we are going to implement is sort(). But our requirement is to 
 *          develop the data-structure generically that it can contain any type of values. 
 *          So, our sort() method now needs to use different algorithm/approach to sort for 
 *          different types of values. But we cannot predict and implement all algorithms 
 *          before-hand by overloading the same method. We need a way to dynamically inject our 
 *          "Sorting Behaviour" into the class at RunTime. 
 *          WHICH DESIGN PATTERN CAN BE USED HERE?
 *      Solution:
 *          Strategy Pattern
 */

package StrategyPattern;


import java.util.logging.Logger;


public class LinearCollection {

    private static Logger LOGGER = Logger.getLogger(LinearCollection.class.getName());

    private int[] data;
    private ISortStrategy sortStrategy;


    public LinearCollection(int[] data, ISortStrategy sortStrategy) {
        this.data = data;
        this.sortStrategy = sortStrategy;
    }

    public void sort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (sortStrategy.compare(data[j], data[j + 1])) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}
