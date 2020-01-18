package com.roombooking.server;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ServerLogWriter {

    private FileHandler fileHandler;

    public ServerLogWriter() {
        Logger serverResponses = Logger.getLogger(RoomsController.class.getName());
        try {
            PrintWriter writer = new PrintWriter("./serverOutput.dat");
            writer.print("");
            writer.close();

            // Write to file in desired format.
            fileHandler = new FileHandler("serverOutput.dat", false);
            fileHandler.setFormatter(new SimpleFormatter() {
                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format("%1$tF %1$tT %2$-4s - %3$s %n", new Date(lr.getMillis()), lr.getLevel().getLocalizedName(), lr.getMessage());
                }
            });

            // Add logs to handler
            serverResponses.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileHandler != null) {
                fileHandler.flush();
            }
        }
    }
}
