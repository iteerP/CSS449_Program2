/**
 * ------------------------- Point.java -------------------------
 * Purpose:
 *      
 * 
 * Functionality:
 *      - 
 * 
 * Assumptions:
 *      - 
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

  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  public double getXCoord()
  {
    return this.x;
  }

  public double getYCoord()
  {
    return this.y;
  }
}



class PointXComparator implements java.util.Comparator<Point>
{
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



class PointYComparator implements java.util.Comparator<Point>
{
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
