/**
 * ------------------------- Point.java -------------------------
 * Purpose:
 *      Stores x and y-coordinate of point
 * 
 * Functionality:
 *      - Returns x coordinate of point
 *      - Returns y coordinate of point
 * 
 * Assumptions:
 *      - None
 * 
 * Author(s):
 *      - Khushmeet Gobindpuri
 *      - Khushpreet Gobindpuri
 * -----------------------------------------------------------------
 */

public class Point
{
  private double x;
  private double y;

  /**
    * ------------------------- Point -------------------------
    * Purpose:
    *      Reads x-coordinates and y-coordinates for each
    *      point in the data file
    * 
    * Method Parameters:
    *      - x: x-coordinate of point
    *      - y: y-coordinate of point
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - x and y-coordinate of point are initialized
    * ---------------------------------------------------------
    */
  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }



  /**
    * ------------------------- getXCoord -------------------------
    * Purpose:
    *      Allows user to get x-coordinate of point
    * 
    * Method Parameters:
    *      - None
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - X-coordinate of point is returned
    * -------------------------------------------------------------
    */
  public double getXCoord()
  {
    return this.x;
  }



  /**
    * ------------------------- getYCoord -------------------------
    * Purpose:
    *      Allows user to get y-coordinate of point
    * 
    * Method Parameters:
    *      - None
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Y-coordinate of point is returned
    * -------------------------------------------------------------
    */
  public double getYCoord()
  {
    return this.y;
  }
}