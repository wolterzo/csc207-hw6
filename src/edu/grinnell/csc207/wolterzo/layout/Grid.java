package edu.grinnell.csc207.wolterzo.layout;

public class Grid
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * single character in the grid
   */
  char ch;
  /**
   * number of columns in the grid
   */
  int width;
  /**
   * number of rows in the grid
   */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Grid(int width, int height, char ch)
  {
    this.width = width;
    this.height = height;
    this.ch = ch;
  } // Grid(int, int, char)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  

  /**
   * get the ith row of the grid
   * @throws Exception 
   */
  public String row(int i)
    throws Exception
  {
    if (i > this.height)
      {
        throw new Exception("Invalid row " + i);
      } // if
    else
      {
        StringBuffer result = new StringBuffer();
        int width = this.width;
        for (int j = 0; j < width; j++)
          {
            result.append(this.ch);
          } // for
        return result.toString();
      } // else
  } // row(int)

  /**
   * Determine how many rows are in the block
   */
  public int height()
  {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block
   */
  public int width()
  {
    return this.width;
  } // width()
} // class Grid
