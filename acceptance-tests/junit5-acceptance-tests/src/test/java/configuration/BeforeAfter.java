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
package configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anton_Shapin on 5/24/17.
 */
public class BeforeAfter {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeforeAfter.class);

    private static int count = 0;
    private static int failedTests = 0;
    private static int passedTests = 0;

    @BeforeEach
    public void setScenarioInfoIntoLog(TestInfo testInfo){
        setIdIntoLog(testInfo);
        setScenarioName(testInfo);
    }

    @AfterEach
    public void logCountOfTest(TestInfo testInfo){

    }

    public void setScenarioName(TestInfo testInfo) {
        MDC.put("scenarioName", testInfo.getDisplayName());
    }

    public void setIdIntoLog(TestInfo testInfo) {
        final Pattern testCaseIdPattern = Pattern.compile("@TestCaseId\\(\"+?([^\"]+)\"+?\\)");
        for (String tag : testInfo.getTags()) {
            Matcher matcher = testCaseIdPattern.matcher(tag);
            if (matcher.matches()) {
                final String testCaseId = matcher.group(1);
                MDC.put("testCaseId", testCaseId);
            }
        }
    }
}
