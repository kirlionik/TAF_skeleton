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
package org.exampleProject.qa.common.gui.services.attachments;

import org.exampleProject.qa.common.gui.services.attachments.providers.AttachmentsProvider;
import org.exampleProject.qa.common.gui.services.attachments.providers.AllureAttachmentsProvider;
import org.exampleProject.qa.common.gui.services.attachments.providers.ReportPortalAttachmentsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@Lazy
public class AttachmentsImpl implements Attachments {
    private Set<AttachmentsProvider> attachmentProviders = new HashSet<>();

    @Autowired
    @Lazy
    AllureAttachmentsProvider allureAttachments;

    @Autowired @Lazy
    ReportPortalAttachmentsProvider reportPortalAttachments;

    @Autowired
    boolean reportPortalProviderEnabled;

    @PostConstruct
    public void init() {
        attachmentProviders.add(allureAttachments);
        if (reportPortalProviderEnabled) {
            attachmentProviders.add(reportPortalAttachments);
        }
        attachmentProviders = Collections.unmodifiableSet(attachmentProviders);
    }

    @Override
    public void attachPageTitle() {
        attachmentProviders.stream().forEach(provider->provider.attachPageTitle());
    }

    @Override
    public void attachScreenShot() {
        attachmentProviders.stream().forEach(provider->provider.attachScreenshot());
    }

    @Override
    public void attachScreenShot(String nameOfScreenshot) {
        attachmentProviders.stream().forEach(provider->provider.attachScreenshot(nameOfScreenshot));
    }

    @Override
    public void attachPageText(String nameOfAttachment,String textOfAttachment) {
        attachmentProviders.stream().forEach(provider->provider.attachText(nameOfAttachment,textOfAttachment));
    }
}
