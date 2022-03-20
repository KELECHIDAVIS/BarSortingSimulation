public class Selection extends Sorter
{
    int i =0;
    @Override
    public void sort(int[] heights , Panel panel)
    {
        for(int i=0; i<heights.length-1; i++)
        {
            if(panel.sorter!=null)
            {
                int min = i;

                for(int j=i+1; j<heights.length; j++)
                {
                    if(heights[j] <heights[min] )
                    {
                        min = j ;
                    }
                }
                if(i!=min)
                {
                    swap(heights, i, min);
                    panel.repaint();
                    try
                    {
                        Thread.sleep(panel.delay*5); // because selection is a little faster we have to slow it down for the animation
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

        }
        finished(panel);
    }

}
