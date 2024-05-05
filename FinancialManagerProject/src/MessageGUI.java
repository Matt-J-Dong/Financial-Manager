
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MessageGUI {
    private JFrame subFrame;
    private JList<String> sourceList;
    private DefaultListModel<String> listModel;

    public MessageGUI() {
        subFrame = new JFrame("Messages");
        subFrame.setSize(300, 135);
        subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        subFrame.getContentPane().setLayout(null);
        
        

        subFrame.setVisible(true);
    }

	public MessageGUI(String message) {
		JLabel messageLabel = new JLabel(message);
        messageLabel.setBounds(105, 46, 61, 16);
        subFrame.getContentPane().add(messageLabel);
	}
}
