package org.exampleProject.qa.common.gui.services.pages;
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
import org.exampleProject.qa.common.gui.annotations.PageObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Anton_Shapin on 5/23/17.
 */
@PageObject
public class HomePageObject extends AbstractPageObject {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${site.url:localhost}")
    protected String siteUrl;

    public void open(){
        LOG.info("Open main page");
        driver.get(siteUrl);

    }
    public void changeLang(){
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"gh-eb-Geo\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"gh-eb-Geo-a-en\"]")).click();
    }
}