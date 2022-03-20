public abstract class Sorter
{
    boolean sorting = true;
    public abstract  void sort(int[] heights, Panel panel ) ;
    public void swap(int[] arr, int i, int j )
    {
        int dummy=arr[i] ;
        arr[i] = arr[j];
        arr[j]  = dummy ;
    }
    public void finished(Panel panel)
    {
        System.out.println("finished");
        panel.sorter = null;

    }


}
