package lesson1.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButton1Action implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
    }
}
