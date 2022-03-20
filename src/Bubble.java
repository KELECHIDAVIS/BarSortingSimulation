public class Bubble extends Sorter
{
    public void sort(int[] heights, Panel panel )
    {
        for(int i =0; i<heights.length-1; i++)
        {
            if(panel.sorter!=null)
            {
                if(heights[i]>heights[i+1])
                {
                    swap(heights, i , i+1);
                    panel.repaint();
                    try
                    {
                        Thread.sleep(panel.delay);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                }
            }

        }



    }
}
