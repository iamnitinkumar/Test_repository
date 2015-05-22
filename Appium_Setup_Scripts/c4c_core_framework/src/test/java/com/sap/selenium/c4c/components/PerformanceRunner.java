package com.sap.selenium.c4c.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import com.sap.nw.performance.supa.automation.Supa;

public class PerformanceRunner extends BlockJUnit4ClassRunner {
	private static Supa supa;
	private static final int SUPA_DELAY = 20;
	private static Properties properties;
	private static int warmupIterations = 1;
	private static int iterations = 0;
	
	public PerformanceRunner(Class<?> klass) throws InitializationError, FileNotFoundException, IOException {
		super(klass);
		System.out.println("in Performance runner");
	}

	@Override
	public int testCount() {
		return super.testCount() * warmupIterations + iterations;
	}

	@Override
    public void runChild(FrameworkMethod method, RunNotifier notifier) {
    	try {
    		if (iterations > 0) {
				supa.setEnabled(false);
    		}
			for(int i = 1; i <= warmupIterations; i++) {
				System.out.println("Warmup Iteration: " + i);
		    	super.runChild(method, notifier);
			}
			if (iterations > 0) {
				supa.setEnabled(true);
			}
			
			for(int i = 1; i <= iterations; i++) {
				System.out.println("Iteration: " + i);
				
				super.runChild(method, notifier);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void startMeasurement(String step) {
    	if (supa != null) {
    		try {
				supa.startMeasurement(step);
			} catch (Exception e) {
			}
    	}
    }

    public static void stopMeasurement() {
    	if (supa != null) {
    		try {
				supa.stopMeasurement(SUPA_DELAY);
			} catch (Exception e) {
				try {
					supa.resetDataProviders();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
    	}
    }
    
    public static void resetDataProviders() {
    	if (supa != null) {
    		try {
				supa.resetDataProviders();
			} catch (Exception e) {
			}
    	}   	
    }
    
    public static void setSupa(Supa newSupa) {
    	supa = newSupa;
    }
    
    public static String getProperty(String key) {
    	if (properties == null) {
			properties = new Properties();
		    try {
				properties.load(new FileInputStream("performance.properties"));
			} catch (Exception e) {
			}
    	}

    	String value = System.getProperty(key);
    	if (value == null) {
    		value = properties.getProperty(key);
    	}
    	return value;
    }

	public static void setIterations(int newIterations) {
		iterations = newIterations;
	}

	public static void setWarmupIterations(int newWarmupIterations) {
		warmupIterations = newWarmupIterations;
	}

}
