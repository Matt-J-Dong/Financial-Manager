
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MessageGUI {
    private JFrame subFrame;

    public MessageGUI() {
        subFrame = new JFrame("Messages");
        subFrame.setSize(300, 135);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        subFrame.getContentPane().setLayout(null);
        String message = "Error-Task Not Possible";
        JLabel messageLabel = new JLabel(message);
        messageLabel.setBounds(70, 46, 162, 16);
        subFrame.getContentPane().add(messageLabel);

        subFrame.setVisible(true);
    }

}
