package helper;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ColoredConsoleHandler extends ConsoleHandler {

    @Override
    public void publish(LogRecord record) {
        String message = getFormatter().format(record);
        String coloredMessage = addColor(record.getLevel(), message);
        System.out.println(coloredMessage);
    }

    private String addColor(Level level, String message) {
        String colorCode;
        switch (level.getName()) {
            case "SEVERE":
                colorCode = "\u001B[31m"; // Red
                break;
            case "WARNING":
                colorCode = "\u001B[33m"; // Yellow
                break;
            case "INFO":
                colorCode = "\u001B[36m"; // SkyBlueGreen
                break;
            default:
                colorCode = "\u001B[0m"; // Reset color
                break;
        }
        return colorCode + message + "\u001B[0m"; // Reset color at the end
    }
}
