package engine.utils;

import org.apache.log4j.Logger;


public class LoggerUtil {
    private static Logger Log = Logger.getLogger(LoggerUtil.class.getName());

    public static void startTestSuite(String testSuiteName){

        Log.info("****************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+testSuiteName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("****************************************************************************************");

    }
    public static void endTestCase(){
        Log.info("XXXXXXXXXXXXXXXXXXXXXXX     "+"END OF RUNNING TEST CASE"+"          XXXXXXXXXXXXXXXXXXXXXX");

    }

    public static void endTestSuite() {

        Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void startTestCase (String testCaseName){
        Log.info("****************************************************************************************");

        Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+testCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

        Log.info("****************************************************************************************");
    }

    public static void info(String message) {

        Log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }
}
