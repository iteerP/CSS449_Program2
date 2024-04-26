/**
 * ------------------------- PointXComparator.java -------------------------
 * Purpose:
 *      Comparator used to sort point object array by x-coordinate
 * 
 * Functionality:
 *      - Compares x-coordinates of two points
 * 
 * Assumptions:
 *      - None
 * 
 * Author(s):
 *      - Khushmeet Gobindpuri
 *      - Khushpreet Gobindpuri
 * -------------------------------------------------------------------------
 */
class PointXComparator implements java.util.Comparator<Point>
{
  /**
    * ------------------------- compare -------------------------
    * Purpose:
    *      Compares x-coordinates of two passed in point objects
    * 
    * Method Parameters:
    *      - p1: Point one
    *      - p2: Point two
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Returns -1 if p1 x-coordinate is lower than p2
    *        x-coordinate, returns 1 otherwise
    * -----------------------------------------------------------
    */
  @Override
  public int compare(Point p1, Point p2)
  {
    if(p1.getXCoord() < p2.getXCoord())
    {
      return -1;
    } else
    {
      return 1;
    }
  }
}