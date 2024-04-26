/**
 * ------------------------- PointYComparator.java -------------------------
 * Purpose:
 *      Comparator used to sort point object array by y-coordinate
 * 
 * Functionality:
 *      - Compares y-coordinates of two points
 * 
 * Assumptions:
 *      - None
 * 
 * Author(s):
 *      - Khushmeet Gobindpuri
 *      - Khushpreet Gobindpuri
 * -------------------------------------------------------------------------
 */
class PointYComparator implements java.util.Comparator<Point>
{
  /**
    * ------------------------- compare -------------------------
    * Purpose:
    *      Compares y-coordinates of two passed in point objects
    * 
    * Method Parameters:
    *      - p1: Point one
    *      - p2: Point two
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Returns -1 if p1 y-coordinate is lower than p2
    *        y-coordinate, returns 1 otherwise
    * -----------------------------------------------------------
    */
  @Override
  public int compare(Point p1, Point p2)
  {
    if(p1.getYCoord() < p2.getYCoord())
    {
      return -1;
    } else
    {
      return 1;
    }
  }
}