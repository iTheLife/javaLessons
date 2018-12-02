package lesson4.homework;

import javax.swing.*;
import java.awt.*;

public class MessageWindow extends JFrame {
    private JTextArea jta;
    private JTextField jtf;

    class MyHintTextField extends JTextField{
        String hint;

        public MyHintTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(getText().isEmpty()){
                g.drawString(hint,4,16);
            }
        }
    }

    public MessageWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Application");
        setBounds(1200, 500, 400, 400);
        setVisible(true);

        JPanel upperPannel = new JPanel(new BorderLayout());
        jta = new JTextArea(10, 20);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        upperPannel.add(jsp, BorderLayout.CENTER);
        add(upperPannel);
        JPanel lowerPannel = new JPanel(new BorderLayout());
        JButton jb1 = new JButton("Send");
        jb1.addActionListener(e-> sendMsg());
        lowerPannel.add(jb1,BorderLayout.EAST);
        jtf = new MyHintTextField("Введите слово");
        jtf.setPreferredSize(new Dimension(320, 10));
        jtf.addActionListener(e-> sendMsg());
        lowerPannel.add(jtf,BorderLayout.WEST);
        add(lowerPannel, BorderLayout.SOUTH);
        jtf.grabFocus();

    }
    public void sendMsg() {
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
