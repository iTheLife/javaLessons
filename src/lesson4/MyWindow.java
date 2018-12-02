package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyWindow extends JFrame {
    private JTextField jtf;
    private JTextArea jta;

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

    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Application");
        setBounds(1200, 500, 400, 400);
        setLayout(new BorderLayout());

        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");

        jb1.setPreferredSize(new Dimension(100, 20));
        jb2.setPreferredSize(new Dimension(100, 20));

        add(jb1);
        add(jb2);

        jb1.addActionListener(e -> System.out.println("CLICKED!!!"));

        jtf = new MyHintTextField("Введите слово");
        jta = new JTextArea(10, 20);

        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);
        add(jtf);


        jb2.addActionListener(e -> sendMsg());

        jtf.addActionListener(e -> sendMsg());

//        for (int i =0; i<50; i++){
//            JButton jb = new JButton("#"+i);
//            jb.addActionListener(e-> System.out.println("X"));
//            add(jb);
//        }
        JPanel upperPannel = new JPanel(new BorderLayout());
        upperPannel.add(jb1, BorderLayout.WEST);
        upperPannel.add(jb2, BorderLayout.EAST);
        upperPannel.add(jtf, BorderLayout.CENTER);
        upperPannel.add(jsp, BorderLayout.SOUTH);
        add(upperPannel, BorderLayout.NORTH);

        JButton jbWarning = new JButton("Warning");
        //jbWarning.addActionListener(e -> JOptionPane.showMessageDialog(null, "WARNING!!!"));
        //jbWarning.addActionListener(e -> JOptionPane.showInputDialog(null, "Here is you value",10));
        jbWarning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showOptionDialog(null, "msg", "title", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            }
        });
        jbWarning.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jbWarning.setBackground(new Color((int) ((float) e.getX() / (float) jbWarning.getWidth() * 255f), 0, 0));
            }
        });

        Font font = new Font("Arial", Font.PLAIN, 24);
        jta.setFont(font);
        add(jbWarning, BorderLayout.SOUTH);
        JList<String> jls = new JList<>(new DefaultListModel<>());
        jls.setPreferredSize(new Dimension(100, 1));
        add(jls, BorderLayout.EAST);
        ((DefaultListModel<String>) jls.getModel()).addElement("A");
        ((DefaultListModel<String>) jls.getModel()).addElement("B");
        ((DefaultListModel<String>) jls.getModel()).addElement("C");

        JLabel jll = new JLabel("Hello Java");
        add(jll, BorderLayout.WEST);

        setVisible(true);
    }

    public void sendMsg() {
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
