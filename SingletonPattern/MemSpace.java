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
 *          will be created, totalling 1 GB of RAM. This can be a fatal point of failure in our application. 
 *          Which Design Pattern can be used to avoid this?
 *      Solution:
 *          Singleton Pattern
 */

package SingletonPattern;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MemSpace {

    private static Logger LOGGER = Logger.getLogger(MemSpace.class.getName());

    private byte[] customHeap;
    private static MemSpace instance;


    private MemSpace() {
        this.customHeap = new byte[500000000];
    }

    public static MemSpace getSpace() {
        if(instance == null) {
            instance = new MemSpace();
        }
        return instance;
    }

    public void storeObject(Serializable obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            byte[] serialized = baos.toByteArray();
            System.arraycopy(serialized, 0, this.customHeap, 0, serialized.length);
        } catch(IOException e) {
            LOGGER.log(Level.SEVERE, "Exception when serializing the given object: " + e.getStackTrace());
        }
    }
}

