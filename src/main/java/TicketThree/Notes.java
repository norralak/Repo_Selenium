package TicketThree;

public class Notes {
    /**
     * XPath is another type of locator
     * Chropath creates a unique xpath to find a WebElement
     * By.xpath("//xpath//to//element")
     *
     * Absolute XPath
     *      starts with /
     *      tells the route of the element from the root tag
     *      not reliable because if the DOM changes, the absolute XPath may not work
     *      rarely used
     *
     * Relative xpath
     *      used the most in automation
     *      starts with //
     *      find the WebElement using their attributes/text
     *
     *      A) Simple XPath (Direct XPath)
     *          Using attributes
     *              //tag[@name='attributeValue']
     *          Using text
     *              //tag[text()='textVal']
     *          Partial Attribute Value
     *              //tag[contains(@attributeName, 'partialAttrVal')]
     *          Partial Text Value
     *              //tag[contains(text(), 'textValue')]
     *          Starting Portion of Attribute
     *              //tag[starts-with(@attrName, 'partialAttrVal')]
     *          Starting Portion of Text
     *              //tag[starts-with(text(), 'partialText')]
     *          not() Method
     *              //button[not(), @disabled] --> Will return XPath that does not contain disabled button
     *              //tag[not(text()='textVal')]
     *          and/or
     *              //tag[text()='textValue' and @attrName='attributeValue']
     *              //tag[text()='textValue' or @attrName='attributeValue']
     *          To find something regardless of tag
     *              //*[text()='webElement textValue'] Use asterisk
     *      B) Advanced XPath (Indirect XPath)
     */
    /**
     * Dropdowns
     *      Select tag
     *          Pass the dropdown WebElement to Select object.
     *              Select dropD = new Select(DropDownWebElement);
     *              dropD.selectByVisibleText('textOfDesiredDropDownOption');
     *              or to select by value (in DOM) dropD.selectByValue(dropDownValueAttrValue);
     *              or to select by index dropD.selectByIndex(index);
     */
}
