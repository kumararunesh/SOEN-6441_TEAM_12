package org.ObserverBasedLogging;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LogWriter {
    public static Logger LOGGER;
    public LogWriter() {
 
    }
    public static void writeLog(String p_msg) throws Exception {
        LOGGER.severe(p_msg);
    }
}
