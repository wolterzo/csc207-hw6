package edu.grinnell.csc207.wolterzo.layout;

public class TruncatedBlock
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
   * desired width
   */
  int newWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public TruncatedBlock(TextBlock tb, int width)
  {
    this.contents = tb;
    this.newWidth = width;
  } // TruncatedBlock(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  

  /**
   * Get the ith row of the block.
   */
  public String row(int i)
    throws Exception
  {
    if (i > this.height() || i < 0)
      {
        throw new Exception("Invalid row " + i);
      } // if invalid row
    else
      {
        String originalRow = this.contents.row(i);
        return originalRow.substring(0, this.newWidth);
      } // else
  } // row(int)

  /**
   * Determine how many rows are in the block
   */
  public int height()
  {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block
   */
  public int width()
  {
    return this.newWidth;
  } // width()

} // class TruncatedBlock
