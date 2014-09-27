package edu.grinnell.csc207.wolterzo.layout;

public class BlockPair
    implements TextBlock
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * The original text block
   */
  TextBlock content;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BlockPair(TextBlock tb)
  {
    this.content = tb;
  } // BlockPair(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+  

  /**
   * Returns the ith row of the TextBlock. 
   * @param i, an integer. The index of the desired row.
   * @return String
   * @throws Exception if i is an invalid row.
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
        return this.content.row(i) + this.content.row(i);
      } // else 
  } // row(int)

  /**
   * Determine the number of rows in the block
   * @return an int
   */
  public int height()
  {
    return this.content.height();
  } // height()

  /**
   * Determine the number of columns in the block. 
   * @return an int
   */
  public int width()
  {
    return this.content.width() * 2;
  } // width()

} // class BlockPair
