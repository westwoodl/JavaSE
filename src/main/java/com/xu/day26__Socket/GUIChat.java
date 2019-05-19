package com.xu.day26__Socket;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * 图形化界面聊天
 */
public class GUIChat extends Frame {
    private TextField tf;
    private Button send;
    private Button log;
    private Button clear;
    private Button shake;
    private TextArea viewArea;
    private TextArea sendArea;
    private DatagramSocket socket;

    public GUIChat() {
        southPanel();
        centerPanel();
        event();
        init();
    }

    private void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (IOException ex) { ex.printStackTrace(); }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewArea.setText("");
            }
        });

        shake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send(new byte[]{-1}, tf.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sendArea.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    try {
                        send();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void shake() {
        int x = this.getX();
        int y = this.getY();

        for(int n=0;n<10;n++) {
            if(n%2==0)
                this.setLocation(x+5, y-3);
            else
                this.setLocation(x-5, y+3);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void send(byte[] arr,String ip) throws IOException {
        DatagramPacket packet = new DatagramPacket(
                arr, arr.length, InetAddress.getByName(ip), 9999);
        socket.send(packet);
    }

    private void send() throws IOException {
        String message = sendArea.getText();
        String ip = tf.getText();

        send(message.getBytes(), ip);

        viewArea.append(new Date() + " you said to " + ip + " :\r\n" + message + "\r\n\r\n");
        sendArea.setText("");

    }

    class Receive extends Thread {
        @Override
        public void run() {
            try(DatagramSocket socket = new DatagramSocket(9999)){
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                while (true) {
                    socket.receive(packet);
                    byte[] arr = packet.getData();
                    int len = packet.getLength();

                    if(arr[0]==-1&&len==1) {
                        shake();
                        continue;
                    }
                    String message = new String(arr, 0, len);
                    viewArea.append(new Date() + " " + packet.getAddress() + "said to you" + " :\r\n" + message + "\r\n\r\n");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    private void init(){
        this.setLocation(500, 50);
        this.setSize(400, 600);

        try {
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Receive().start();

        this.setVisible(true);
    }

    private void southPanel(){
        Panel south = new Panel();
        tf = new TextField(15);
        send = new Button("Send");
        log = new Button("Log");
        clear = new Button("Clear");
        shake = new Button("Shake");

        tf.setText("127.0.0.1");

        south.add(tf);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);

        south.setVisible(true);
        this.add(south, BorderLayout.SOUTH);
    }
    private void centerPanel() {
        Panel center = new Panel();

        viewArea = new TextArea();

        sendArea = new TextArea(5, 1);

        center.setLayout(new BorderLayout());
        center.add(viewArea, BorderLayout.CENTER);
        center.add(sendArea, BorderLayout.SOUTH);

        viewArea.setEditable(false);
        viewArea.setBackground(Color.WHITE);
        sendArea.setFont(new Font("XXX", Font.PLAIN, 15));
        center.setVisible(true);

        this.add(center, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new GUIChat();
    }
}
