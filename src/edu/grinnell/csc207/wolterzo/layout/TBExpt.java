package edu.grinnell.csc207.wolterzo.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock hello = new TextLine("Hello");

    // Print out the block
    //TBUtils.print(pen, hello);

    TextBlock goodbye = new TextLine("Goodbye");
    TextBlock comp = new BoxedBlock(new VComposition(hello, goodbye));
    TBUtils.print(pen, comp);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
