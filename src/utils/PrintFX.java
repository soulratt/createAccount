package utils;

import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class manage ticket print
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.1
 */
public class PrintFX {

    private static final Logger LOGGER = LogManager.getLogger("PrintFX");
    
    public void print(final Node node) {
        Printer printer = Printer.getDefaultPrinter();
        LOGGER.debug("Get default printer");
        // Paper paper = PrintHelper.createPaper("10x15", 210, 210, Units.MM);
        PageLayout pageLayout = printer.createPageLayout(Paper.NA_LETTER, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        LOGGER.debug("Set page layout");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean success = job.printPage(pageLayout, node);
            if (success) {
                job.endJob();
                LOGGER.debug("End print job");
            }
        }
    }
}
