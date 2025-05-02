package com.mycompany.mavenproject3;

import javax.swing.*;
import java.awt.*;

public class Mavenproject3 extends JFrame implements Runnable {
    private String text = "Menu yang tersedia: Americano | Pandan Latte | Aren Latte | Matcha Frappucino | Jus Apel";
    private int x;
    private int width;
    private BannerPanel bannerPanel;
    private JButton addProductButton;

    public Mavenproject3(String text) {
        this.text = text;
        setTitle("WK. STI Chill");
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel teks berjalan
        bannerPanel = new BannerPanel();
        add(bannerPanel, BorderLayout.CENTER);

        // Tombol "Kelola Produk"
        JPanel bottomPanel = new JPanel();
        addProductButton = new JButton("Kelola Produk");
        bottomPanel.add(addProductButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        addProductButton.addActionListener(e -> {
            new ProductForm().setVisible(true);
        });

        setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    } 

    class BannerPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics label) {
            super.paintComponent(label);
            label.setColor(Color.RED);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.drawString(text, x, getHeight() / 2);

            setVisible(true);

            Thread t = new Thread();
            t.start();
        }
    }

    @Override
    public void run() {
        width = getWidth();
        while (true) {
            x += 5;
            if (x > width) {
                x = -getFontMetrics(new Font("Arial", Font.BOLD, 18)).stringWidth(text);
            }
            bannerPanel.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Mavenproject3("Menu yang tersedia: Americano | Pandan Latte | Aren Latte | Matcha Frappucino | Jus Apel");
    }
}
