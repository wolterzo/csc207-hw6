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

    
    // Create a blocks to use
    TextLine hello = new TextLine("Hello");
    TextBlock goodbye = new TextLine("Goodbye");
    
    //Test Grid
    TextBlock block1 = new BoxedBlock(new Grid(6, 8, '8'));
    pen.println("Grid:");
    TBUtils.print(pen, block1);
    
    //Test TruncatedBlock
    TextBlock block2 = new TruncatedBlock(block1, 4);
    pen.println();
    pen.println("Truncated Grid:");
    TBUtils.print(pen, block2);
    
    //Test CenteredBlock
    TextBlock block3 = new BoxedBlock(new CenteredBlock(hello, 12));
    pen.println();
    pen.println("CenteredBlock:");
    TBUtils.print(pen, block3);
        
    //Test RightJustified
    TextBlock block4 = new BoxedBlock (new RightJustified(new VComposition(hello, goodbye), 20));
    pen.println();
    pen.println("RightJustified:");
    TBUtils.print(pen, block4);
    
    //Test BlockPair
    TextBlock block5 = new BoxedBlock(new BlockPair(block3));
    pen.println();
    pen.println("BlockPair:");
    TBUtils.print(pen, block5);
    
    //Test setContents
    hello.setContents("Incredible, truly.");
    pen.println();
    pen.println("UPDATED RightJustified");
    TBUtils.print(pen, block4);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])
} // class TBExpt
