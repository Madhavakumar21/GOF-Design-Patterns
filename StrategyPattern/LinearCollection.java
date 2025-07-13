/**
 * @file    MemSpace.java
 * @date    2025-06-07
 * @author  Madhavakumar D
 * @brief   Singleton Pattern
 * 
 * @details 
 *      Contains the basic implementation of Singleton Pattern.
 *      
 *      Problem Statement:
 *          We want to develop a Custom Heap in our application and have implemented a class called MemSpace 
 *          which will allocate 500 MB of space in RAM for us to store data. In our application logic, 
 *          we have 2 methods called createSpace() & getSpace(). The 1st method should be called only once 
 *          (at the start of the program). The second method can be called at any time (whenever we need a reference 
 *          to the object). Here, if we accidentally call the createSpace() method twice, 2 MemSpace objects 
 *          will be created, totaling 1 GB of RAM. This can be a fatal point of failure in our application. 
 *          Which Design Pattern can be used to avoid this?
 *      Solution:
 *          Singleton Pattern
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
