package edu.grinnell.csc207.wolterzo.layout;

public class RightJustified
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The original text block
   */
  TextBlock content;

  /**
   * The new width of the block
   */
  int entireWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public RightJustified(TextBlock tb, int width)
  {
    this.content = tb;
    this.entireWidth = width;
  } // RightJustified(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  
  
  /**
   * Returns the ith row of the block
   */
  public String row(int i)
    throws Exception
  {
    if (i > this.content.height() || i < 0)
      {
        throw new Exception("Invalid row " + i);
      } // if
    else
      {
        return TBUtils.spaces(this.entireWidth - this.content.width())
               + this.content.row(i);
      } // else
  } // row(int)

  /**
   * Determined the number of rows in the block.
   */
  public int height()
  {
    return this.content.height();
  } // height()

  /**
   * Determines the number of columns in the block
   */
  public int width()
  {
    return this.entireWidth;
  } // entireWidth

} // class RightJustified
