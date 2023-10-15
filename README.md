Task B: Create a README file that includes notes describing where in the code 
to find the changes you made for each of parts C to J. Each note should 
include the prompt, file name, line number, and change.

 - Location is: File was placed in branch -> working branch, added the 
Tasks by Letter to file 

Task C: Customize the HTML user interface for your customer’s application. The 
user interface should include the shop name, the product names, and the 
names of the parts.

 - Line 19 - Adjusted: Shopname and header to 'Mike's Skateboard Shop' in mainscreen
 - Line 32 - Adjusted: Part names

Task D: Add an “About” page to the application to describe your chosen 
customer’s company to web viewers and include navigation to and from the 
“About” page and the main screen.

 - In templates - Add: aboutUs.html page in templates
 - In aboutUs.html - Add: Information about customers business
 - In controllers - Add: AboutUsController.java
 - Line 101 - Add: Link on mainscreen to aboutus
 - Line 39 - Add: Link on aboutus to mainscreen
 - In aboutUs.html - Adjust: About Us section of about us and added an image
 - Resource for Image is: 
https://pixabay.com/photos/skateboard-skateboarder-skae-2271295/
 
Task E: Add a sample inventory appropriate for your chosen store to the 
application. You should have five parts and five products in your sample 
inventory and should not overwrite existing data in the database.
 Note: Make sure the sample inventory is added only when both the part 
and product lists are empty. When adding the sample inventory appropriate 
for the store, the inventory is stored in a set so duplicate items cannot 
be added to your products. 

- Line 48 -52 - Add five products to BootStrapData:
  - Skateboard
  - Kids Skateboard
  - Old School Skateboard
  - Longboard
  - Electric Skateboard
- Line 41- 45 - Add five parts to BootStrap Data:
  - Wheels
  - Trucks
  - Bearings
  - Griptape
  - Decks
- Line 61-93 - Add addPartIfNotExsists in BootStrapData for parts

Task F: Add a “Buy Now” button to your product list. Your “Buy Now” 
button must 
meet each of the following parameters:

The “Buy Now” button must be next to the buttons that update and 
delete products.

The button should decrement the inventory of that product by one. It 
should not affect the inventory of any of the associated parts.

Display a message that indicates the success or failure of a purchase.

  - Line 90-91 - Add Buy now button on product table adjacent to update/delete in mainscreen
  - In controllers - Add ConfirmationBuyController to contoller to controllers
  - In controllers - Modifed controller name to ConfirmBuyController
  - In templates - Add buyproducts and errorpage templates and controllers 
  - Line 111-117 - Added method to product.java that return boolean for inventory
  - Line 172 - 182 - Mapped endpoint in AddProductController, return confirmBuy page or errorPage depending on inventory value

Task G: Modify the parts to track maximum and minimum inventory by doing the 
following:

Add additional fields to the part entity for maximum and minimum 
inventory.

Modify the sample inventory to include the maximum and minimum fields.

Add to the InhousePartForm and OutsourcedPartForm forms additional 
text inputs for the inventory so the user can set the maximum and minimum 
values.

Rename the file the persistent storage is saved to.

Modify the code to enforce that the inventory is between or at the 
minimum and maximum value.

  - Line 40-41 - Add maxInv and minInv private fields in Part.java
  - Line 64-67 - Create new constructor in parts.java with maxInv and minInv
  - Create setters and getters -> setMaxInv (Line 110-113) getMaxInv (Line 114-117), setMinInv (Line 102-105) getMinInv (Line 106-109)
  - Line 39-40 - Create TH in mainscreen.html to dispay min and max
  - Add max and min values in inhouspart (Line 17-20) and outsourcepart (Line 17-20) 500 and 0 respectivly
  - In user Folder - Rename DB to mikes_DB.mv.db from user home in directory
  - Line 6 - Rename spring.datesource in application.properties to match new DB -> mikes_DB.mv.db
  - Line 49-50 - Add table headers for maxInv and minInv in mainscreen.html
  - Line 145-153 - Add custom validRangeLimit() to Part.java to validate inventory range
  - Add thePart.validRangeLimit() to InhousePartServiceImpl.java (Line 54) and OutsourcesPartServiceImpl.java (Line 52)

Task H: Add validation for between or at the maximum and minimum fields. The 
validation must include the following:

Display error messages for low inventory when adding and updating 
parts if the inventory is less than the minimum number of parts.

Display error messages for low inventory when adding and updating 
products lowers the part inventory below the minimum.

Display error messages when adding and updating parts if the inventory 
is greater than the maximum.

  - In validators - add custom validator @ValidInventoryRange to check for max inventories, generates error message when adding parts
  - In validators - Add custom validator @ValidMinInventoryrange for check for min inventories, generates error message when adding parts
  - Line 22 - @ValidMinInventoryRange is set to zero, if inventory is less that min num parts there is an error message
  - Task F only requires that the inventory is decrementred by one and does nothing with the associated parts, no requirement in tasks to make it functions this way, therefore same errorPage is applicable

Task I: Add at least two unit tests for the maximum and minimum fields to 
the PartTest class in the test package.

  - Line 161 -175 - Add two test to PartTest.java -> @Test void getMin() and @Test void getMax()

Task J: Remove the class files for any unused validators in order to clean 
your code.
  - In validators - delete DeletePartValidator -> zero usages


Corrections as Per Evaluator:

  - Aspect #B - add code line changes to README.md
  - Aspect #G - Line 26-29 - add max and min fields to Inhouse Part Detail - so user can change values
  - Aspect #G - Line 28-30 - add max and min fields to Outsourced Part Detail - so user can change values
  - Aspect #H - Fixed ability to update parts through the addition of minInv and maxInv solved through Aspect#G