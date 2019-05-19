package com.xu.day25__Thread;

import java.awt.*;
import java.awt.event.*;

/**
 * 一处编译，到处调试。根本没用
 * 适配器：没有抽象方法的抽象类
 */
public class Demo9_GUI {

    public static void main(String[] args) {
        Frame f = new Frame("biao ti");
        f.setSize(400, 600);
        f.setLocation(500, 50);

        //f.setIconImages(Toolkit.getDefaultToolkit().createImage(""));
        Button b = new Button("an niu yi");
        f.add(b);
        f.setLayout(new FlowLayout());

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        b.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });

        b.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode()+"="+e.getKeyChar());
            }
        });

        //ActionListener
        f.setVisible(true);
    }
}
