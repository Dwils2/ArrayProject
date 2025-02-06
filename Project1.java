import itsc2214.ArrayInt;
import java.util.Random;
/**
 * This project is running through an array of ints.
 * 
 * @author Dylan Wilson
 * @version Jan 07, 2025
 */
public class Project1 implements ArrayInt {
    private int[] array;
    private int size;
    private final int capacity;
    
    /**
     * Creates a project1 with a set capacity.
     * 
     * @param capacity - limit of numbers in array.
     */
    public Project1(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }
    /**
     * Finds the minimum of the array.
     * 
     * @return - the minimum value.
     */
    public int getMinimum() {
        if (isEmpty()) return Integer.MIN_VALUE;
        int min = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
    /**
     * Finds the maximum of the array.
     * 
     * @return - the maximum value.
     */
    public int getMaximum() {
        if (isEmpty()) return Integer.MAX_VALUE;
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }
    /**
     * Finds the average of the array.
     * 
     * @return - average of all numbers in array.
     * @throws IllegalStateException - throws if array is empty.
     */
    public double getAverage() {
        if (isEmpty()) throw new IllegalStateException("Array is empty");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        return (double) sum/size;
    }
    /**
     * Finds the range of the array.
     * 
     * @return - the range of the function.
     */
    public int getRange() {
        return getMaximum() - getMinimum();
    }
    /**
     * Generates the size of the array.
     * 
     * @return - returns the size of the array.
     */
    public int size() {
        return size;
    }
    /**
     * Finds the capacity of the array.
     * 
     * @return - returns the capacity.
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Adds a value to the array.
     * 
     * @param value - the number being added to array.
     * @throws IllegalStateException - throws when array is full.
     */
    public void addValue(int value) {
        if (isFull()) throw new IllegalStateException("Array is full");
        array[size++] = value;
    }
    /**
     * Finds a specific value.
     * 
     * @param index - the index of the value.
     * @return - returns the value the user asked for.
     */
    public int getValue(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Invalid index");
        return array[index];
    }
    /**
     * Sets a value at a specific index.
     * 
     * @param index - the position of the value.
     * @param value - the number being added.
     * @return value - returns the value being added.
     */
    public int setValue(int index, int value) {
        if (index >= size) throw new IndexOutOfBoundsException("Invalid index");
        array[index] = value;
        return value; // Arbitrary return value
    }
    /**
     * Adds random numbers to the array.
     * 
     * @param n - the total amount of numbers to generate.
     * @throws IllegalStateException - throws when array is full.
     */
    public void addRandom(int n) {
        if ((size + n) > capacity) throw new IllegalStateException("Not enough space in array");
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            addValue(random.nextInt(100)); // Adding random numbers in range 0-99
        }
    }
    /**
     * Removes a value at a specified posistion.
     * 
     * @param index - the index of the value being removed.
     */
    public void removeValueAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Invalid index");
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    /**
     * Determines if the array is empty.
     * 
     * @return - returns true or false if array is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Determines if the array is full.
     * 
     * @return - returns true or false if the array is full.
     */
    public boolean isFull() {
        return size == capacity;
    }
    /**
     * Checking if the array has duplicates.
     * 
     * @return - true for duplicates and false for none.
     */
    public boolean hasDuplicates()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (array[i] == array[j]) return true;
            }
        } return false;
    }   
}