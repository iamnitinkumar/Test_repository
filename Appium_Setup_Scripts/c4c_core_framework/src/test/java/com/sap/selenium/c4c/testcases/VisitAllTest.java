package com.sap.selenium.c4c.testcases;

import java.util.logging.Level;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.nw.performance.supa.automation.Supa;
import com.sap.selenium.c4c.components.PerformanceRunner;

@RunWith(Suite.class)
@SuiteClasses({ VisitTest.class })
public class VisitAllTest {
	
	private static final int SUPA_PROXY_PORT = 9090;
	private static int warmupIterations;
	private static int iterations;
	private static Supa supa;
	
	protected static String[] getSupaConfig() {
		String[] config = new String[] {
			"branch.0.name=",
			"branch.0.http.message.ignore.urls.containing=/sap/ap/ui/repository",
			"branch.0.browser.process=" + PerformanceRunner.getProperty("supaBrowser"),
			"branch.0.supa.proxy.port=" + SUPA_PROXY_PORT,
			"branch.0.delayed.browser.pid.calculation=true",
			"branch.0.data.provider=com.sap.nw.performance.supa.core.dataprovider.BrowserCpuTimeProvider",
			"branch.0.scenario.url = " + PerformanceRunner.getProperty("aut"),
			"branch.1.data.provider = com.sap.nw.performance.supa.core.dataprovider.abap.stad.StadDataProvider",
			"branch.1.component.position = 195,232",
			"branch.1.component.class = com.sap.nw.performance.supa.gui.config.landscape.model.components.AbapSystem",
			"branch.1.component.id = BackendCI",
			"branch.1.component.name = BackendCI",
			"branch.1.abap.hostname = ldci" + PerformanceRunner.getProperty("BackendSystem") + ".wdf.sap.corp",
			"branch.1.abap.sid = " + PerformanceRunner.getProperty("BackendSystem"),
			"branch.1.abap.snr = 00",
			"branch.1.stad.user.connection = " + PerformanceRunner.getProperty("BackendUser"),
			"branch.1.stad.user.connection.password = " + PerformanceRunner.getProperty("BackendPassword"),
			"branch.1.stad.user.connection.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.1.stad.user.read = " + PerformanceRunner.getProperty("PerformanceUser"),
			"branch.1.stad.user.read.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.1.name = BackendCI",
			/*"branch.2.data.provider = com.sap.nw.performance.supa.core.dataprovider.abap.stad.StadDataProvider",
			"branch.2.component.position = 195,232",
			"branch.2.component.class = com.sap.nw.performance.supa.gui.config.landscape.model.components.AbapSystem",
			"branch.2.component.id = BackendAI01",
			"branch.2.component.name = BackendAI01",
			"branch.2.abap.hostname = ldai01" + PerformanceRunner.getProperty("BackendSystem") + ".wdf.sap.corp",
			"branch.2.abap.sid = " + PerformanceRunner.getProperty("BackendSystem"),
			"branch.2.abap.snr = 00",
			"branch.2.stad.user.connection = " + PerformanceRunner.getProperty("BackendUser"),
			"branch.2.stad.user.connection.password = " + PerformanceRunner.getProperty("BackendPassword"),
			"branch.2.stad.user.connection.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.2.stad.user.read = " + PerformanceRunner.getProperty("PerformanceUser"),
			"branch.2.stad.user.read.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.2.name = BackendAI01",
			"branch.3.data.provider = com.sap.nw.performance.supa.core.dataprovider.abap.stad.StadDataProvider",
			"branch.3.component.position = 195,232",
			"branch.3.component.class = com.sap.nw.performance.supa.gui.config.landscape.model.components.AbapSystem",
			"branch.3.component.id = BackendAI02",
			"branch.3.component.name = BackendAI02",
			"branch.3.abap.hostname = ldai02" + PerformanceRunner.getProperty("BackendSystem") + ".wdf.sap.corp",
			"branch.3.abap.sid = " + PerformanceRunner.getProperty("BackendSystem"),
			"branch.3.abap.snr = 00",
			"branch.3.stad.user.connection = " + PerformanceRunner.getProperty("BackendUser"),
			"branch.3.stad.user.connection.password = " + PerformanceRunner.getProperty("BackendPassword"),
			"branch.3.stad.user.connection.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.3.stad.user.read = " + PerformanceRunner.getProperty("PerformanceUser"),
			"branch.3.stad.user.read.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.3.name = BackendAI02",*/
			"branch.2.data.provider = com.sap.nw.performance.supa.core.dataprovider.abap.stad.StadDataProvider",
			"branch.2.component.position = 195,232",
			"branch.2.component.class = com.sap.nw.performance.supa.gui.config.landscape.model.components.AbapSystem",
			"branch.2.component.id = BackendAI03",
			"branch.2.component.name = BackendAI03",
			"branch.2.abap.hostname = ldai03" + PerformanceRunner.getProperty("BackendSystem") + ".wdf.sap.corp",
			"branch.2.abap.sid = " + PerformanceRunner.getProperty("BackendSystem"),
			"branch.2.abap.snr = 00",
			"branch.2.stad.user.connection = " + PerformanceRunner.getProperty("BackendUser"),
			"branch.2.stad.user.connection.password = " + PerformanceRunner.getProperty("BackendPassword"),
			"branch.2.stad.user.connection.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.2.stad.user.read = " + PerformanceRunner.getProperty("PerformanceUser"),
			"branch.2.stad.user.read.client = " + PerformanceRunner.getProperty("BackendClient"),
			"branch.2.name = BackendAI03",
			"data.provider=com.sap.nw.performance.supa.core.manager.BranchManager,com.sap.nw.performance.supa.core.dataprovider.ScreenshotDataProvider",
			"supa.http.port=8090",
			"supa.server.hostname=localhost",
			"data.logdir=" + PerformanceRunner.getProperty("user.dir").replace('\\', '/') + "/target/supa",
			"scenario.name=CODPerformance"
		};
		return config;
	}
	
	@BeforeClass
	public static void startSupa() throws Exception {
		try {
			warmupIterations = Integer.parseInt(PerformanceRunner.getProperty("supaWarmupIterations"));
			iterations = Integer.parseInt(PerformanceRunner.getProperty("supaIterations"));
		} catch (Exception e) {
			warmupIterations = 1;
			iterations = 0;
		}		
		
		PerformanceRunner.setIterations(iterations);
		PerformanceRunner.setWarmupIterations(warmupIterations);
		
		if (iterations > 0) {
			supa = new Supa(getSupaConfig());
			supa.setLogLevel(Level.INFO);
		}		
		
		PerformanceRunner.setSupa(supa);
	}
	
	
	@AfterClass
	public static void finishSupa() throws Exception {
		if (iterations > 0) {
			System.out.println("SUPA Result Dir: " + supa.getResultDirectory());
			supa.writeExcelReport();
			supa.finish();
		}	
	}

}
