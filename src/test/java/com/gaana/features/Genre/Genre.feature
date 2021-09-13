#Author: arpit.prajapati

Feature: Test Scenarios for validating Hamburger functionality

	@Gaana @Regression
 Scenario Outline: Verify the Genre functionality for non-loggedIn user
 
 Given user opens the application "genrePage"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on first "Songs" and verifies the song page is opening successfully
 Then user clicks on first "Albums" and verifies the album page is opening successfully
 Then user clicks on first "Artists" and verifies the artist page is opening successfully
 
 Examples:
    |Alphabet   |
  	|A  |

  @Gaana @Regression
 Scenario Outline: Verify the Genre 'View All' functionality for non-loggedIn user
 
 Given user opens the application "genrePage"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on "View All" link for the "Songs"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Albums"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Artists"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 
 
 Examples:
    |Alphabet   |
  	|E |


@Gaana @Regression
 Scenario Outline: Verify the Genre functionality for GaanaPlus user
 
 Given user opens the application "genrePage"
 Then user logins with "<loginType>"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on first "Songs" and verifies the song page is opening successfully
 Then user clicks on first "Albums" and verifies the album page is opening successfully
 Then user clicks on first "Artists" and verifies the artist page is opening successfully
 
 Examples:
    |Alphabet   |loginType|
  	|H  |GaanaPlus|

  @Gaana @Regression
 Scenario Outline: Verify the Genre 'View All' functionality for GaanaPlus user
 
 Given user opens the application "genrePage"
 Then user logins with "<loginType>"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on "View All" link for the "Songs"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Albums"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Artists"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 
 
 Examples:
    |Alphabet   |loginType|
  	|N  |GaanaPlus|


		
@Gaana @Regression
 Scenario Outline: Verify the Genre functionality for non-GaanaPlus user
 
 Given user opens the application "genrePage"
 Then user logins with "<loginType>"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on first "Songs" and verifies the song page is opening successfully
 Then user clicks on first "Albums" and verifies the album page is opening successfully
 Then user clicks on first "Artists" and verifies the artist page is opening successfully
 
 Examples:
    |Alphabet   |loginType|
  	|S  |NonGaanaPlus|


  @Gaana @Regression
 Scenario Outline: Verify the Genre 'View All' functionality for non-GaanaPlus user
 
 Given user opens the application "genrePage"
 Then user logins with "<loginType>"
 Then user clicks on character "<Alphabet>" on the genre page
 Then user clicks on the first genre under character "<Alphabet>"
 Then user verifies that the first genre page opens successfully
 Then user verifies that the "Songs,Albums,Artists" are displayed on the genre page
 Then user clicks on "View All" link for the "Songs"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Albums"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 Then user clicks on "View All" link for the "Artists"
 Then user clicks on first item on the genre list details page and verifies the page is opening successfully
 
 
 Examples:
   |Alphabet   |loginType|
  	|W  |NonGaanaPlus|


		
		