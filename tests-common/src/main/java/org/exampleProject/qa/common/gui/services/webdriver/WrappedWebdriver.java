/*
* Copyright 2002 - 2017 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.exampleProject.qa.common.gui.services.webdriver;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static java.lang.String.valueOf;

/**
 * Created by Anton_Shapin
 */

public class WrappedWebdriver implements WebDriver {
    private static final String LOG_EXECUTION_TIME = "{} Execution_Time(ms):; {}; Page_URL:; {};";

    private WebDriver driver;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public WrappedWebdriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWrappedDriver(){
        return driver;
    }

    @Override
    public void get(String s) {
        LOG.debug("Opening url: {}", s);
        long startTime = System.currentTimeMillis();
        try {
            driver.get(s);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Open_Page",getExecutionTime(startTime), s);
        }
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        LOG.debug("Finding elements by: {}", by);
        long startTime = System.currentTimeMillis();
        try {
            return driver.findElements(by);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Find_Elements",getExecutionTime(startTime), driver.getCurrentUrl());
        }
    }

    @Override
    public WebElement findElement(By by) {
        LOG.debug("Finding element by: {} ", by);
        long startTime = System.currentTimeMillis();
        try {
            return driver.findElement(by);
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Find_Element",getExecutionTime(startTime), driver.getCurrentUrl());
        }
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        LOG.debug("Driver close");
        long startTime = System.currentTimeMillis();
        try {
            driver.close();
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Driver_Close",getExecutionTime(startTime), "");
        }
    }


    @Override
    public void quit() {
        LOG.debug("Driver quit");
        long startTime = System.currentTimeMillis();
        try {
            driver.quit();
        }finally {
            LOG.info(LOG_EXECUTION_TIME, "Driver_Quit",getExecutionTime(startTime), "");
        }
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    /**
     * Take screenshot of the page
     * @return byte array
     */
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Get execution time of action
     * @param startTime - start time
     * @return execution time im ms
     */
    private String getExecutionTime(long startTime){
        return valueOf(System.currentTimeMillis() - startTime);
    }

}
