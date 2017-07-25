package org.exampleProject.qa.common.gui.services.webdriver;
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
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Anton_Shapin on 5/23/17.
 */
@Component
@Lazy
public class LocalStorageJS {
    @Autowired
    WrappedWebdriver driver;

    private JavascriptExecutor jsExecutor;

    @PostConstruct
    public void init() {
        this.jsExecutor = (JavascriptExecutor) driver.getWrappedDriver();
    }

    /**
     * Get local storage size
     * @return length
     */
    public Long getLocalStorageLength() {
        return (Long) jsExecutor.executeScript("return window.localStorage.length;");
    }

    /**
     * Set item in LocalStorage
     * @param item - item name
     * @param value - item value
     */
    public void setItemInLocalStorage(String item, String value) {
        jsExecutor.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", item, value));
    }

    /**
     * Clear LocalStorage
     */
    public void clearLocalStorage() {
        jsExecutor.executeScript("window.localStorage.clear();");
    }

    /**
     * Remove item from LocalStorage
     * @param item - item name
     */
    public void removeItemFromLocalStorage(String item) {
        jsExecutor.executeScript(String.format(
                "window.localStorage.removeItem('%s');", item));
    }

    /**
     * Is item present in LocalStorage
     * @param item - item name
     * @return true - if present<br/>false - if doesn`t present
     */
    public boolean isItemPresentInLocalStorage(String item) {
        return jsExecutor.executeScript(String.format(
                "return window.localStorage.getItem('%s');", item)) != null;
    }

    /**
     * Get item value from LocalStorage
     * @param key - item name
     * @return - item value
     */
    public String getItemFromLocalStorage(String key) {
        return (String) jsExecutor.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }

    /**
     *
     * @param key
     * @return
     */
    public String getKeyFromLocalStorage(int key) {
        return (String) jsExecutor.executeScript(String.format(
                "return window.localStorage.key('%s');", key));
    }
}
