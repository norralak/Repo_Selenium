package TicketTwo;

public class Notes {
    /**
     * Web Elements
     * Text Box/Input Box --> Type, clear, click on
     * Buttons & Radio Buttons --> Click
     * Check Box --> Click (Check and Uncheck)
     * Drop Down --> Click/Type
     * Hyperlinks/Links --> Click to go to another webpage (See below)
     * Link Text (The actual text associated with the link) --> Click
     * Image --> Click
     * Alerts
     * Frames
     */

    /**
     * DOM - Document Object Model is an API for programs to change webpages
     * <= REMEMBER: Interface are just abstract classes that cannot have an instance =>
     * DOM is an interface that allows programs or users to access and change the page
     * Core DOM - standard model for all document types
     * XML DOM - standard model for XML documents
     * HTML DOM - standard model for HTML documents
     *
     * Front-End Code --> DOM --> Creates Website/Webpage
     * Right-click --> Inspect --> DOM (SOURCE)
     * <tag> Opening and closing tags. Tag names cannot have spaces. </tag>
     * <html>
     *     <head>
     *         Something Here... Title Back/Forward URL
     *     </head>
     *     <body>
     *         Most of the page's contents
     *         <p attribute1 = "Norralak", attribute2 = "Angie" >
     *             Paragraph tag here.
     *             Attribute names cannot have spaces.
     *             They may or may not have a value.
     *             This and the above are the text values of the <p> tag
     *             If there is a tag inside another tag, the outer tag is the parent
     *             The inner is the child. If they're in the same tag, they are sibling tags
     *             Preceding/Following siblings => The sibling before and after
     *             Following Tag => The tag after inside or outside (no relation)
     *             Preceding Tag => Tag before the given tag no relation
     *             Descendant tags => Tags in the family chain appearing after the tag
     *             Ancestor => Tags preceding in the family chain
     *     </body>
     * </html>
     * Chropath Plugin/Extension used for web automation in Google Chrome
     */

    /**
     * Locators: Routes that reach/find the desired webElement
     * Datatype of Locator is the class By (Abstract class)
     * To interact with webElement:
     * Find the unique address of the element in the DOM
     * Depending on the type of address/info we use specific methods in the By class to create a locator
     * Use locator to find element using findElement()
     */

    /**
     * Types of Addresses
     * 1. id Attribute (if id Attribute is present it will be unique, thus the best thing to use to locate an element) => By locator = By.id("idValue);
     *      Can use Chropath to check if ID is unique =>Type the following into Chropath selector //*[@id='idValue']
     * 2. name Attribute
     *      Not always unique. Check in Chropath to see if unique => //*[@name='nameValue']
     * 3. if findElement() is found, then WebElement will be returned. Else, NoSuchElement exception
     * 4. Least preferred find by className Attribute
     *      Chropath //*[@class='classValue'] check if unique
     *      By.className('classValue');
     * 5. linkText & partialLinkText
     *      Always 'a' tag
     *      href attribute contains the URL of page that link redirects to
     *      Chropath -> //a[text()='linkTextValue']
     *      By.linkText('linkTextVal');
     *      partialLinkText
     *      Chropath -> //a[contains(text(), 'partialLinkTextValue')] check if unique
     *      By.partialLinkText('partialLinkTextVal');
     * 6. tagName
     *      Chropath -> //tagName
     *      By.tagName('tagNameValue');
     *
     * Interact
     *      click() -> To click
     *      sendKeys() -> input as string, types in your string to the element
     */

    /**
     * EnabledDisplaySelected
     *      Locate and store WebElement
     *      WebElement.isDisplayed() to verify if it is displayed or not
     *      Use Assert.assertTrue() this case for test verification
     *      isEnabled() to verify if it is enabled
     *      isSelected() verify if it is selected
     */

    /**
     * GetTextAttribute
     *      WebElement.getText() returns String of text associated with the given WebElement
     *      getAttribute("AttributeName") returns Attribute value as a string
     */
}
