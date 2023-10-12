Task B: Create a README file that includes notes describing where in the code 
to find the changes you made for each of parts C to J. Each note should 
include the prompt, file name, line number, and change.

 - Location is: File was palced in branch -> working branch, added the 
Tasks by Letter to file 

Task C: Customize the HTML user interface for your customer’s application. The 
user interface should include the shop name, the product names, and the 
names of the parts.

 - Adjusted: Shopname and header to 'Mike's Skateboard Shop'
 - Adjusted: Part names

Task D: Add an “About” page to the application to describe your chosen 
customer’s company to web viewers and include navigation to and from the 
“About” page and the main screen.

 - Add: aboutUs.html page in templates
 - Add: Information about customers business
 - Add: AboutUsController.java
 - Add: Link on mainscreen to aboutus
 - Add: Link on aboutus to mainscreen
 - Adjust: About Us section of about us and added an image
 - Resource for Image is: 
https://pixabay.com/photos/skateboard-skateboarder-skae-2271295/
 
Task E: Add a sample inventory appropriate for your chosen store to the 
application. You should have five parts and five products in your sample 
inventory and should not overwrite existing data in the database.
 o Note: Make sure the sample inventory is added only when both the part 
and product lists are empty. When adding the sample inventory appropriate 
for the store, the inventory is stored in a set so duplicate items cannot 
be added to your products. When duplicate items are added, make a 
“multi-pack” part.

- Add five products to BootStrapData:
  - Skateboard
  - Kids Skateboard
  - Old School Skateboard
  - Longboard
  - Electric Skateboard
- Add five parts to BooStrap Data:
  - Wheels
  - Trucks
  - Bearings
  - Griptape
  - Decks

Task F: Add a “Buy Now” button to your product list. Your “Buy Now” 
button must 
meet each of the following parameters:

•   The “Buy Now” button must be next to the buttons that update and 
delete products.

•   The button should decrement the inventory of that product by one. It 
should not affect the inventory of any of the associated parts.

•   Display a message that indicates the success or failure of a purchase.

  - Add Buy now button on product table adjacent to update/delete in mainscreen
  - Add ConfirmationBuyController to contoller to controllers
  - Modied controller name to ConfirmBuyController
  - Add buyproducts and errorpage templates and controllers 
  - Added method to product.java that return boolean for inventory
  - Mapped endpoint in AddProductController, return confirmBuy page or errorPage depending on inventory value

Task G: Modify the parts to track maximum and minimum inventory by doing the 
following:

•   Add additional fields to the part entity for maximum and minimum 
inventory.

•   Modify the sample inventory to include the maximum and minimum fields.

•   Add to the InhousePartForm and OutsourcedPartForm forms additional 
text inputs for the inventory so the user can set the maximum and minimum 
values.

•   Rename the file the persistent storage is saved to.

•   Modify the code to enforce that the inventory is between or at the 
minimum and maximum value.

  - Add maxInv and minInv private fields in Part.java
  - Create new constructor in parts.java with maxInv and minInv
  - Create setters and getters -> setMaxInv getMaxInv, setMinInv getMaxInv
  - Create TH in mainscreen.html to dispay min and max
  - Add max and min values in inhouspart and outsourcepart 100 and 0 respectivlty
  - Rename DB to mikes_DB.mv.db from user home in directory
  - Rename spring.datesource in application.properties to match new DB -> mikes_DB.mv.db
  - Add table headers for maxInv and minInv in mainscreen.html
  - Add custom validator @ValidInventoryRange to check for min and max inventories, created InventoryInRangeValidator and ValidInventoryInRange UI

Task H: Add validation for between or at the maximum and minimum fields. The 
validation must include the following:

•   Display error messages for low inventory when adding and updating 
parts if the inventory is less than the minimum number of parts.

•   Display error messages for low inventory when adding and updating 
products lowers the part inventory below the minimum.

•   Display error messages when adding and updating parts if the inventory 
is greater than the maximum.

Task I:
- I.  Add at least two unit tests for the maximum and minimum fields to 
the PartTest class in the test package.
- Location is:

Task J: Remove the class files for any unused validators in order to clean 
your code.
- Files removed were:

