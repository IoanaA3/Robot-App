package com.example.pip_robot;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.io.ObjectInputStream;

public class CommandSender extends AsyncTask<String,Void,Void> {

    Socket socket;
    PrintWriter printWriter;
    ObjectInputStream ob;
    @Override
    protected Void doInBackground(String... data)
    {
        // establish a connection
        String command = data[0];
        try {

            socket = new Socket(ConnectActivity.IP, ConnectActivity.PORT); //Server IP and PORT
            printWriter = new PrintWriter(socket.getOutputStream());
            ob = new ObjectInputStream(socket.getInputStream());
            Hashtable hs  = (Hashtable) ob.readObject();

            printWriter.write(command+"\n"); // Send Data
            printWriter.flush();
            System.out.println("ok\n");
            System.out.println("medaj " + hs);

            printWriter.close();
            ob.close();
            socket.close();
        }
        catch(UnknownHostException e){
            System.err.println("Don't know about host: ");
        }catch (IOException e){
            System.err.println("Couldn't get I/O for the connection to: ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
