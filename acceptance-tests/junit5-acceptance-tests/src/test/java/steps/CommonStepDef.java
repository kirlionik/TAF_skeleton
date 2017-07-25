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
package steps;

import configuration.AppConfig;
import org.exampleProject.qa.common.gui.containers.DataContainer;
import org.exampleProject.qa.common.gui.services.pages.HomePageObject;
import org.exampleProject.qa.common.gui.services.pages.MainSearchFormPageObject;
import org.exampleProject.qa.common.gui.services.pages.ProductCardPageIObject;
import org.exampleProject.qa.common.gui.services.pages.SerpPageObject;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

/**
 * Created by Anton_Shapin on 5/23/17.
 */
@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class CommonStepDef {
    @Value("${site.url:localhost}")
    protected String siteUrl;

    @Autowired
    @Lazy
    public WebDriver driver;

    @Autowired
    @Lazy
    public DataContainer dataContainer;

    //Page Objects
    @Autowired
    @Lazy
    protected MainSearchFormPageObject mainSearchFormPage;

    @Autowired
    @Lazy
    protected ProductCardPageIObject productCardPage;

    @Autowired
    @Lazy
    protected SerpPageObject serpPage;

    @Autowired
    @Lazy
    protected HomePageObject homePage;
}
