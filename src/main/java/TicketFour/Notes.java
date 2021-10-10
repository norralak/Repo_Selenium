package TicketFour;

public class Notes {
    /**
     * Advanced XPath When Direct XPath Does Not Work
     *
     * Reach the element via the parent tag
     * (//tag[@attribute = 'attrName'])[indexIfNotUnique](//childTag)[indexIfNotUnique]
     *
     * Following Siblings
     * //tag[@attribute = 'attrName']/following-sibling::siblingTagName
     *
     * Preceding Siblings
     * //tag[@attribute = 'attrName']/preceding-sibling::(siblingTagName)[indexIfNotUnique]
     *
     * Following
     * //tag[text()='textVal']/following::anotherTag[conditions] somewhere below
     *
     * Preceding
     * //tag[text()='textVal']/preceding::anotherTag[conditions] somewhere
     *
     * Ancestor
     * //tag[text()='textVal']/ancestor::anotherTag[conditions] find an ancestor
     *
     * Descendant
     * //tag[text()='textVal']/descendant::anotherTag[conditions] somewhere below
     */

    /**
     * Actions Class
     * moveToElement()
     * click()
     * sendKeys()
     * dragAndDrop()
     * contextClick()
     * doubleClick()
     *
     * Actions newAct = new Actions(driver);
     * newAct.moveToElement(WebElement).build().perform();
     *
     * When an Actions method is doing more than one thing, we need to use .build().perform()
     * If it is just one then use .perform()
     *
     */

    /**
     * Cucumber: Test Case Format
     * Uses Gherkin to write Scenarios (Tests)
     * Very intuitive compared to TestNG
     * Kind of like an Abstracted TestNG
     *
     * Let's create a package with classes that contains methods and variables related to the webpage
     * ex: Driver, Actions methods, WebElements etc.
     *
     */
}
