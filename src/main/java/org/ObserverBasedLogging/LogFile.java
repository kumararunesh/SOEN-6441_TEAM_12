package org.ObserverBasedLogging;

import java.util.Observable;
import java.util.Observer;

public class LogFile implements Observer {
    private String d_msg;

    @Override
    public void update(Observable o, Object msg) {
        try {
            this.setMsg((String) msg);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
