/**
 * ------------------------- Main.java -------------------------
 * Purpose:
 *      Main driver for closest-pair searching algorithm
 * 
 * Functionality:
 *      - Executes and tests PointSet class
 * 
 * Assumptions:
 *      - Inputted .txt file's data is formatted correctly
 * 
 * Author(s):
 *      - Khushmeet Gobindpuri
 *      - Khushpreet Gobindpuri
 * -------------------------------------------------------------
 */

public class Main
{
  /**
    * ------------------------- main -------------------------
    * Purpose:
    *      Tests implementation of closest-pair search
    *      algorithm in PointSet class
    * 
    * Method Parameters:
    *      - args (not used in program)
    * 
    * Pre-conditions:
    *      - Inputted .txt file's data is formatted correctly
    * 
    * Post-conditions:
    *      - Finds closest pair of points in provided data
    * --------------------------------------------------------
    */
  public static void main(String[] args)
  {
    // Read in file data through PointSet constructor
    PointSet ds = new PointSet("program2trivialdata.txt");

    // Find closest pair in provided data
    ds.findClosestPair();
  }
}