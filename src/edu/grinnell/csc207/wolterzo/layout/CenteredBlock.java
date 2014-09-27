package edu.grinnell.csc207.wolterzo.layout;

public class CenteredBlock
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * original TextBlock
   */
  TextBlock contents;

  /**
   * width that the textBlock will be centered in
   */
  int entireWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public CenteredBlock(TextBlock tb, int width) throws Exception
  {
    if (width < tb.width())
      {
        throw new Exception("Invalid width " + width);
      } // if invalid width
    else
      {
        this.contents = tb;
        this.entireWidth = width;
      } // else
  } // CenteredBlock(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  

  /**
   * Returns the ith row of the CenteredBlock. If the original text cannot 
   * be perfectly centered, there will be one more space after the original 
   * row than after. 
   * @param i, an int
   * @exception if given an i bigger than the height
   * @return the given row, a String
   */
  public String row(int i)
    throws Exception
  {
    if (i > this.contents.height() || i < 0)
      {
        throw new Exception("Invalid row " + i);
      } // if invalid row
    else
      {
        //StringBuffer result = new StringBuffer();
        int numStartSpace = (this.entireWidth - this.contents.width()) / 2;
        int numEndSpace =
            this.entireWidth - this.contents.width() - numStartSpace;
        return TBUtils.spaces(numStartSpace) + this.contents.row(i)
               + TBUtils.spaces(numEndSpace);
      } // else
  } // row(int)

  /**
   * Determine the number of rows in the block
   */
  public int height()
  {
    return this.contents.height();
  } // height()

  /**
   * Determine the number of columns in the block
   */
  public int width()
  {
    return this.entireWidth;
  } // width();

} // class CenteredBlock
