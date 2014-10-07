package logger;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.ErrorCode;

/**
* This is a customized log4j appender, which will create a new file for every
* run of the application.
*
*/
public class NewLogForEachRunFileAppender extends FileAppender {

	public NewLogForEachRunFileAppender() {
	}
	
	public NewLogForEachRunFileAppender(Layout layout, String filename,
	        boolean append, boolean bufferedIO, int bufferSize)
	        throws IOException {
	    super(layout, filename, append, bufferedIO, bufferSize);
	}
	
	public NewLogForEachRunFileAppender(Layout layout, String filename,
	        boolean append) throws IOException {
	    super(layout, filename, append);
	}
	
	public NewLogForEachRunFileAppender(Layout layout, String filename)
	        throws IOException {
	    super(layout, filename);
	}
	/**
	 * activateOptions - Overrides FileAppender class to create new file for each run
	 */
	public void activateOptions() {
		if (fileName != null) {
		    try {
		        fileName = getNewLogFileName();
		        setFile(fileName, fileAppend, bufferedIO, bufferSize);
		    } catch (Exception e) {
		        errorHandler.error("Error while activating log options", e,
		                ErrorCode.FILE_OPEN_FAILURE);
		    }
		}
	}
	/**
	 * getNewLogFileName - Create a name of the log file name
	 * @return - name of the log file to create for the run
	 */
	private String getNewLogFileName() {
		if (fileName != null) {
		    String newFileName = fileName+"_"+System.currentTimeMillis()+".log";
		    return newFileName;
		}
		return null;
	}
}
