package unittest;

import org.testng.annotations.Test;
import com.saas.app.reports.Report;

public class UnitTest {
//	WebElement element;
	
//	@Test
//	public void loggingTest() {
//		Log.initializeLog();
//		Log.trace("Trace message");
//		Log.debug("Debug message");
//		Log.info("Info message");
//		Log.warn("Warn message");
//		Log.error("Error message");
//		Log.fatal("Fatal message");
//	}

	@Test
	public void ReportClass() {
//		Log.initializeLog();
		Report.startTest("StartTest", "Report test started");
		Report.info("Info", "Info message");
		Report.pass("Pass", "Pass message", false);
//		Report.pass("PassScreenshot", "Pass message with screenshot", true);
		Report.fail("Fail", "Fail message", false);
//		Report.fail("FailScreenshot", "Fail message with Screenshot", true);
		Report.warn("Warn", "Warn message");
		Report.fatal("Fatal", "Fatal message");
		Report.endTest("endTest", "Report test ended");
		Report.flush();
		
	}
	
	
	
}
