import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Panel extends GamePanel
{
    int barSize =5;
    int minHeight = 10;
    int minorSpacing =10, majorSpacing = 25;
     int delay = 3;
    int[] heights = new int[Main.width /barSize];
    JFrame frame = new JFrame();
    JFrame speedFrame = new JFrame();
    JSlider slider = new JSlider(0,150,delay);
    JButton shuffle = new JButton("Shuffle");
    JButton bubble = new JButton("Bubble Sort");
    JButton selection = new JButton("Selection Sort");
    JButton insertion = new JButton("Insertion Sort");
    JButton merge = new JButton("Merge Sort");
    Sorter sorter ;
    Panel()
    {

        init();

        this.start();
    }
    private void initButton()
    {
        shuffle.setFocusable(false);
        bubble.setFocusable(false);
        selection.setFocusable(false);
        insertion.setFocusable(false);
        merge.setFocusable(false);
        shuffle.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                sorter = null;
                shuffle(heights);

            }
        });
        bubble.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sorter = new Bubble();
            }
        });
        selection.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sorter = new Selection();
            }
        });
        insertion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sorter = new Insertion();
            }
        });
        merge.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sorter = new Merge();
            }
        });

        frame.add(bubble);
        frame.add(selection);
        frame.add(insertion);
        frame.add(merge);
        frame.add(shuffle);



    }
    private void initSlider()
    {
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(minorSpacing);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(majorSpacing);

        slider.setPaintLabels(true);
        slider.setSize(215, 20);
        speedFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-(Main.width/2)-slider.getWidth(),Toolkit.getDefaultToolkit().getScreenSize().height/2-Main.height/2);
        speedFrame.add(slider);
    }


    private void init()
    {
        for(int i=0; i<heights.length; i++)
        {
            heights[i] = (int)((Math.random()*(Main.height-minHeight))+minHeight);

        }
        this.setBackground(Color.black);
        initSlider();
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2+Main.width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-Main.height/2);
        frame.setLayout(new GridLayout(5,1));
        initButton();
        speedFrame.setVisible(true);
        speedFrame.pack();
        frame.setVisible(true);
        frame.pack();

    }

    public void shuffle(int[] arr)
    {

        for(int i =0; i<arr.length; i++)
        {
            int s = i+ (int)(Math.random()*(arr.length-i));
            int dummy = arr[s];
            arr[s] = arr[i];
            arr[i] = dummy;
        }

    }

    @Override
    public void update()
    {
        slider.enable();
        enableButtons();
        delay=slider.getValue();
        if(sorter!= null)
        {
            slider.disable();
            disableButtons();
            sorter.sort(heights, this );
        }

    }
    void disableButtons()
    {
        bubble.disable();
        insertion.disable();
        selection.disable();
        merge.disable();
    }
    void enableButtons()
    {
        bubble.enable();
        insertion.enable();
        selection.enable();
        merge.enable();
    }




    @Override
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D j = (Graphics2D) g;

        for(int i =0; i<heights.length; i++)
        {
            j.setColor(Color.white);
            j.setStroke(new BasicStroke(1));
            j.fillRect(i*barSize,Main.height-heights[i] , barSize   , heights[i]);
            j.setStroke(new BasicStroke(2));
            j.setColor(Color.black);
            j.drawRect(i*barSize,Main.height-heights[i] , barSize   , heights[i]);

        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}
