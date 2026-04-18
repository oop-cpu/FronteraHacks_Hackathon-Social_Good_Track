import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame("App");
        SwingUtilities.invokeLater(()->{
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);

            
        });
        frame.setLayout(new BorderLayout());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}