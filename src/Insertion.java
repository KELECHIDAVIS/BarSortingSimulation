public class Insertion extends Sorter
{
    @Override
    public void sort(int[] heights, Panel panel)
    {
        for(int i =1; i<heights.length; i++)
        {
            int temp = heights[i];
            int  j = i-1;
            while(j>=00 &&heights[j] >temp&&sorting)
            {
                if(panel.sorter!=null){


                heights[j+1] = heights[j];
                panel.repaint();
                    try
                    {
                        Thread.sleep(panel.delay/8);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                j--;
                }else
                {
                    sorting = false;
                }
            }
            if(!sorting)
                break;
            heights[j+1] = temp;
            panel.repaint();
            try
            {
                Thread.sleep(panel.delay);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
        finished(panel);
    }
}
