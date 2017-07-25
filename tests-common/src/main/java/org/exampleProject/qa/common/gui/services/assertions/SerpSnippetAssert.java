package org.exampleProject.qa.common.gui.services.assertions;
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
import org.assertj.core.api.AbstractAssert;
import org.exampleProject.qa.common.gui.models.SerpSnippet;

import java.util.List;

/**
 * Created by Anton_Shapin on 5/23/17.
 */

public class SerpSnippetAssert extends AbstractAssert<SerpSnippetAssert, List<SerpSnippet>> {
    public SerpSnippetAssert(List<SerpSnippet> actual) {
        super(actual, SerpSnippetAssert.class);
    }

    public static SerpSnippetAssert assertThat(List<SerpSnippet> actual) {
        return new SerpSnippetAssert(actual);
    }

    public SerpSnippetAssert containsStringInTitle(String title) {
        for(SerpSnippet snippet :actual)
            if (!snippet.getTitle().toLowerCase().contains(title.toLowerCase())) {
                failWithMessage("Snippet with text <%s> does not contains text <%s>", snippet.getTitle(), title);
            }
        return this;
    }

}
