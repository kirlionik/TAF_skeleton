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
import lombok.val;
import one.util.streamex.StreamEx;
import org.exampleProject.qa.common.gui.models.SerpSnippet;
import org.exampleProject.qa.common.gui.annotations.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Anton_Shapin on 5/23/17.
 */
@PageObject
public class SerpPageObject extends AbstractPageObject{
    @FindBy(xpath = "//*[@id='ListViewInner']/li")
    List<WebElement> snippetList;

    @FindBy(xpath = "//*[@id='cbelm']//a[text()='Auction']")
    List<WebElement> buttomAction;

    @FindBy(xpath = "//*[@id='cbelm']//a[text()='Buy It Now']")
    List<WebElement> buttomBuyItNow;

    public List<SerpSnippet> getSnippets(){
        return StreamEx.of(snippetList)
                .map(this::toSnippet)
                .toList();

    }
    public SerpSnippet toSnippet(WebElement webElement){
        val title = webElement.findElement(By.xpath(".//h3")).getText();
        return new SerpSnippet(title);
    }

    public boolean isButtomAction(){
        if(buttomAction.size()==1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isButtomBuyItNow(){
        if(buttomBuyItNow.size()==1){
            return true;
        }else{
            return false;
        }
    }
}
