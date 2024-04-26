/**
 * ------------------------- PointSet.java -------------------------
 * Purpose:
 *      Performs closest-pair search algorithm on provided data
 * 
 * Functionality:
 *      - Reads points from provided data file
 *      - Stores x-coordinates and y-coordinates of all points
 *      - Sorts points based on x-coordinates and/or y-coordinates
 *      - Finds distance between closest pair of points
 * 
 * Assumptions:
 *      - Inputted .txt file's data is formatted correctly
 * 
 * Author(s):
 *      - Khushmeet Gobindpuri
 *      - Khushpreet Gobindpuri
 * -----------------------------------------------------------------
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class PointSet
{
  private int size;
  private Point[] pointsXSorted;
  private Point[] pointsYSorted;
  private double minDistance;

  /**
    * ------------------------- PointSet -------------------------
    * Purpose:
    *      Reads x-coordinates and y-coordinates for each
    *      point in the data file
    * 
    * Method Parameters:
    *      - fileName: Name of data file (hardcoded
    *        to program2data.txt)
    * 
    * Pre-conditions:
    *      - Inputted .txt file's data is formatted correctly
    * 
    * Post-conditions:
    *      - Point coordinates are read from file, sorted,
    *        and stored in respective sorted arrays
    * ------------------------------------------------------------
    */
  public PointSet(String fileName)  
  {
    try
    {
      File file = new File(fileName);
      Scanner sc = new Scanner(file);
      
      // Read dataset size and initialize size field
      int size = Integer.parseInt(sc.nextLine());
      this.size = size;

      // Initialize points array field
      Point[] points = new Point[size];

      // Iterate over each point in provided data and create respective
      // point object and store in PointSet's points array
      for(int idx = 0; idx < this.size; ++idx)
      {
        String coordinates = sc.nextLine();

        // Create separate scanner to read x and y coordinate values
        Scanner scCoord = new Scanner(coordinates);
        double x = scCoord.nextDouble();
        double y = scCoord.nextDouble();

        // // Check to see if coordinates were read correctly
        // System.out.printf("Point %d Coordinates: (%.4f, %.4f)\n", idx+1, x, y);

        points[idx] = new Point(x, y);

        scCoord.close();
      }

      // Initialize sorted points arrays to Point arrays sorted
      // by X values and sorted by Y values (non-descending)
      this.pointsXSorted = sortByX(points);
      this.pointsYSorted = sortByY(points);

      sc.close();

    } catch (FileNotFoundException e)
    {
      System.err.println("File could not be found");
    }
  }



  /**
    * ------------------------- sortByX -------------------------
    * Purpose:
    *      Sorts elements of points array by x-coordinate
    *      from lowest to highest
    * 
    * Method Parameters:
    *      - points: Array containing a list of point objects
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Point objects in passed in points array are
    *        sorted by x-coordinate, from lowest to highest
    * -----------------------------------------------------------
    */
  private Point[] sortByX(Point[] points)
  {
    Point[] sortedByX = points.clone();
    Arrays.sort(sortedByX, new PointXComparator());
    return sortedByX;
  }



  /**
    * ------------------------- sortByY -------------------------
    * Purpose:
    *      Sorts elements of points array by y-coordinate
    *      from lowest to highest
    * 
    * Method Parameters:
    *      - points: Array containing a list of point objects
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Point objects in passed in points array are
    *        sorted by y-coordinate, from lowest to highest
    * -----------------------------------------------------------
    */
  private Point[] sortByY(Point[] points)
  {
    Point[] sortedByY = points.clone();
    Arrays.sort(sortedByY, new PointYComparator());
    return sortedByY;
  }



  /**
    * ------------------------- dist ----------------------------
    * Purpose:
    *      Calculates the distance between two points using
    *      the Euclidean distance formula
    * 
    * Method Parameters:
    *      - p1: Point one
    *      - p2: Point two
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Distance between two passed in points is calculated
    *        and returned
    * -----------------------------------------------------------
    */
  private double dist(Point p1, Point p2)
  { 
    double deltaX = p2.getXCoord() - p1.getXCoord(); 
    double deltaY = p2.getYCoord() - p1.getYCoord();
    return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
  }



  /**
    * ------------------------- bruteForce -------------------------
    * Purpose:
    *      Calculates the closest distance between three pairs
    *      of points
    * 
    * Method Parameters:
    *      - p1: Point one
    *      - p2: Point two
    *      - p3: Point three
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Closest distance between three pairs of points
    *        is calculated and returned
    * --------------------------------------------------------------
    */
  private double bruteForce(Point p1, Point p2, Point p3)
  {
    double d1 = dist(p1, p2); 
    double d2 = dist(p2, p3);
    double d3 = dist(p1, p3);

    return Math.min(d1, Math.min(d2,d3));
  }



  /**
    * ------------------------- findClosestPair -------------------------
    * Purpose:
    *      Starts recursive function, closestPair(left, right), with
    *      initial values left=0 and right=pointsArr.length-1
    * 
    * Method Parameters:
    *      - None
    * 
    * Pre-conditions:
    *      - None
    * 
    * Post-conditions:
    *      - Distance between two closest points is calculated
    *        and returned
    * -------------------------------------------------------------------
    */
  public void findClosestPair()
  {
    this.minDistance = closestPair(0, (this.pointsXSorted.length - 1));
    System.out.printf("Closest distance between two points is: %.4f", this.minDistance);
  }



  /**
    * ------------------------- closestPair -------------------------
    * Purpose:
    *      Recursively calculates the distance between the closest
    *      pair of points
    * 
    * Method Parameters:
    *      - left: Value of leftmost index of subarray
    *      - right: Value of rightmost index of subarray
    * 
    * Pre-conditions:
    *      - left is less than right
    * 
    * Post-conditions:
    *      - Distance between two closest points is calculated
    *        and returned
    * ---------------------------------------------------------------
    */
  private double closestPair(int left, int right)
  {
    int n = ((right - left) + 1);
    double minDistance;

    if(n == 2)
    {
      minDistance = dist(this.pointsXSorted[right], this.pointsXSorted[left]);
      System.out.printf("D[%d,%d]: %.04f\n", left, right, minDistance);
      return minDistance;
    } else if (n == 3)
    {
      minDistance = bruteForce(this.pointsXSorted[left], this.pointsXSorted[left+1], this.pointsXSorted[right]);
      System.out.printf("D[%d,%d]: %.04f\n", left, right, minDistance);
      return minDistance;
    }

    int mid = left + (right - left) / 2;
    double leftDist = closestPair(left, mid);
    double rightDist = closestPair(mid + 1, right);
    minDistance = Math.min(leftDist, rightDist);

    double low = this.pointsXSorted[mid].getXCoord() - minDistance;
    double high = this.pointsXSorted[mid].getXCoord() + minDistance;

    // Filtering out Points in range of current minDistance
    ArrayList<Point> inRange = new ArrayList<>();
    for(Point p : this.pointsYSorted)
    {
      if((p.getXCoord() >= low) && (p.getXCoord() <= high))
      {
        inRange.add(p);
      }
    }

    for(int i = 0; i < inRange.size(); ++i)
    {
      for(int j = 1; (j <= 7) && ((i + j) < inRange.size()); ++j)
      {
        minDistance = Math.min(minDistance, dist(inRange.get(i), inRange.get(i + j)));
      }
    }

    System.out.printf("D[%d,%d]: %.4f\n", left, right, minDistance);
    return minDistance;
  }
}