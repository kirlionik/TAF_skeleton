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
package org.exampleProject.qa.common.gui.services.attachments.providers;

import org.exampleProject.qa.common.gui.services.webdriver.WrappedWebdriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.yandex.qatools.allure.annotations.Attachment;

@Service
@Lazy
public class AllureAttachmentsProvider implements AttachmentsProvider{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired @Lazy
    private WrappedWebdriver driver;

    @Override
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        LOG.debug("Attach screenshot to the Allure report");
        return driver.takeScreenshot();
    }
    @Override
    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String nameOfScreenshot) {
        LOG.debug("Attach screenshot to the Allure report");
        return driver.takeScreenshot();
    }

    @Override
    @Attachment(value = "PageTitle", type = "text/html")
    public String attachPageTitle() {
        return driver.getTitle();
    }

    @Override
    @Attachment(value = "{0}", type = "text/html")
    public String attachText(String nameOfAttachment,String textOfAttachment) {
        return textOfAttachment;
    }
}
