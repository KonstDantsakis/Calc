import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;

public class main  {

    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable()
        {

            public void run()
            {

                new Calculator();
            }
        });


    }


}
