package com.ebay.tests;

import com.ebay.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    // @BeforeMethod
    @BeforeMethod
    public void setUp(Method method) {
        app.init();
        logger.info("Start test " + method.getName());
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        app.stop();
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("=============================================");
    }

}
