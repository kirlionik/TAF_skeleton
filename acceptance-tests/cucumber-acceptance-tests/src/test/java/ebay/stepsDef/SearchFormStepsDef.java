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
package ebay.stepsDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;


public class SearchFormStepsDef extends AbstractStepsDef{
    /**
     * Submit Search Form by special search request
     * @param request
     * @throws Throwable
     */
    @When("^I perform search by request \"([^\"]*)\"$")
    public void iPerformSearchByRequest(String request) throws Throwable {
        mainSearchFormPage.setSearchRequest(request);
        mainSearchFormPage.submit();
    }
}
