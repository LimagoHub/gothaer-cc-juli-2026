package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Fenster  extends Frame  {


    public Fenster()  {

        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener((e)-> System.out.println("Button clicked"));
        add(button);
        setVisible(true);

    }

    private void beenden() {
        dispose();
    }

    public static void main(String[] args) {

        new Fenster();
    }

   private class MyWindow extends WindowAdapter {
        public void windowClosing(WindowEvent e) {

            beenden();
        }
   }
}
