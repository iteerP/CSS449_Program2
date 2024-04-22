/**
 * ------------------------- PointSet.java -------------------------
 * Purpose:
 *      Performs closest-pair search algorithm on provided data
 * 
 * Functionality:
 *      - 
 * 
 * Assumptions:
 *      - Inputted .txt file's data is formatted correctly
 * 
 * Author(s):
 *      - Khushpreet Gobindpuri
 * -----------------------------------------------------------------
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PointSet
{
  private Point[] points;
  private int size;

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
      this.points = new Point[size];

      // Iterate over each point in provided data and create respective
      // point object and store in PointSet's points array
      for(int idx = 0; idx < this.size; ++idx)
      {
        String coordinates = sc.nextLine();

        // Create separate scanner to read x and y coordinate values
        Scanner scCoord = new Scanner(coordinates);
        double x = scCoord.nextDouble();
        double y = scCoord.nextDouble();

        // Check to see if coordinates were read correctly
        System.out.printf("Point %d Coordinates: (%.4f, %.4f)\n", idx+1, x, y);

        this.points[idx] = new Point(x, y);

        scCoord.close();
      }

      sc.close();

    } catch (FileNotFoundException e)
    {
      System.err.println("File could not be found");
    }
  }



  public void sortByX()
  {
    
  }
}
