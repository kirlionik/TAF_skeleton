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
package tests;

import configuration.AppConfig;
import org.exampleProject.qa.common.gui.models.SerpSnippet;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import steps.CommonStepDef;


import java.util.List;


/**
 * Created by Anton_Shapin on 5/23/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class testSoftAssertion extends CommonStepDef {
    @Test
    public void testSoftAssert() {
        homePage.open();
        homePage.changeLang();
        mainSearchFormPage.setSearchRequest("Syma");
        mainSearchFormPage.submit();
        List<SerpSnippet> snippets = serpPage.getSnippets();
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(snippets).as("Check the number of snippets").hasSize(500);
        softAssert.assertThat(serpPage.isButtomAction()).as("Check that Button 'Action' is present").isTrue();
        softAssert.assertThat(serpPage.isButtomBuyItNow()).as("Check that Button 'Buy It Now' is present").isTrue();
        softAssert.assertAll();
    }
}
