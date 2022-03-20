public class Merge extends Sorter
{

    @Override
    public void sort(int[] heights, Panel panel)
    {

        mergesort(heights, panel);
        panel.repaint();
        finished(panel);

    }

    public void mergesort(int[] heights, Panel panel )
    {
        int length = heights.length;
        if(length<=1) // base case
            return ;
        int mid = length/2;
        int[] left = new int[mid];
        int [] right= new int [length-mid];
        int  i =0; // left arr
        int j =0; // right arr
        for(; i<length; i++)
        {
            if(i<mid)
            {

                left[i] = heights[i];

            }else
            {

                right[j] = heights[i];
                j++;

            }
        }

        mergesort(left,panel);

        mergesort(right,panel);

        merge(left,right,heights,panel);
    }


    void merge(int[] left , int[] right , int[] arr, Panel panel)
    {
        int leftSize = arr.length/2;
        int rightSize = arr.length-leftSize ;
        int i =0, l=0, r =0;


        while(l<leftSize&& r<rightSize)
        {
            if(left[l]<right[r] )
            {
                arr[i] = left[l] ;
                i++;
                l++;
                panel.repaint();
                /*try
                {
                    Thread.sleep(panel.delay);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }*/

            }else
            {
                arr[i] = right[r] ;
                i++;
                r++;
                panel.repaint();
               /* try
                {
                    Thread.sleep(panel.delay);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }*/

            }

        }
        while(l<leftSize)
        {
            arr[i] = left[l];
            l++;
            i++;
            panel.repaint();
            /*try
            {
                Thread.sleep(panel.delay);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }*/
        }
        while(r<rightSize)
        {
            arr[i] = right[r];
            i++;
            r++;
            panel.repaint();
            /**/
        }
        panel.repaint();

    }

}
