package com.tools;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class keylisten {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (line.equalsIgnoreCase("quit") == false) {
            line = in.readLine();

        }




        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        System.out.println("Got key event!");
                        return false;
                    }
                });

        in.close();
    }
}
