#Brick_Destroy Lee Jason 20184290
##Key Changes
###Maintenance
- Apply Model View Controller (MVC) design pattern
  - Breakdown existing classes such as GameFrame into GameFrameModel, GameFrameView and GameFrameController.
  - MVC design pattern was chose because it helps separates the display(view) from the data and allow modification in each data without affecting others
  - This makes developing the Graphical User Interface easier and faster as making changes in the GUI will unlikely to cause any error in other classes
- Apply Template design pattern
  - Implemented in Ball class and Brick class
  - Template design pattern helps prevent duplication of codes between the abstract class and concrete class
- Adding meaningful javadoc
  - A javadoc is created under the file named "javadoc"
  - The javadoc gives others an easier and faster way to understand the code written
- Improving encapsulation
  - Important data of each class are set private or protected
  - Class from outside can only access these variable through getter and setter
  - These helps to prevent these data from being modified easily and hiding important data from other class
- Organising files in meaningful way
  - Files related to each other are organized in the same package with relevant name
  - For example, GameFrameModel, GameFrameController and GameFrameView are stored under GameFrame package
  - This helps the developer to navigate through the project easily to find the file they are searching for
- Breaking down large classes in meaningful way
  - Stage class is broken down into 2 classes, Stage class and Wall class
  - Wall class is responsible for grouping all the bricks created to be display in the game
  - Stage class is responsible for getting all components needs in the game such as player, ball and wall
  - Breaking down Stage class supports the idea of single responsibility
###Extension
- Creating info page
  - An info page is created to give the player a better understanding on how to play the game
  - This info page can be accessed by clicking the info button in the main menu
- Creating score system
  -A scoring system will keep track of the player's score
  - Player gain score by breaking the bricks in the game
  - This system helps to motivate the player to keep playing the game
- Creating high score system
  - A high score list will be shown to the player to motivate and challenge them to continue playing the game
  - This high score list can be accessed by clicking the high score button in the main menu
- Player's reward
  - When player completes a stage without losing any ball, player will get a reward
  - Player's rectangle width and movement speed will increase permanently
  - This hopes to challenge user to play at their best
- Player's penalty
  - When player completes a stage with only one ball left, player will get a penalty
  - Player's rectangle width and movement speed will decrease permanently
  - This hopes to challenge user to play at their best
- Game over loop
  - Player's will be asked either to play the game again or exit the game when game ends
  - This allows the player to better understand want to do when game ends compared to the original version

