## LPOO_<12><02> - Dungeon Boy

### PROJECT DESCRIPTION
Dungeon Boy is a game in which the player goes through different levels and maps and faces different enemies until reaching the final boss. It has 2 playing modes, the Survival mode in which the player has to survive through some tough fights with enemies, The Player vs Player mode (PVP) consists in a mode where the player can face a player 2, and the winner will be crowned on the best results out of 5 intense rounds!

This project was developed by João Duarte (201707984), Miguel Tavares(202002811) and Inês Garcia (202004810) for LDTS 2021-22.


### IMPLEMENTED FEATURES

- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Intro Menu, Main Menu with mode selection screens, Instructions,  Shop(when dead) and ESC.
- **Keyboard control** - The keyboard inputs are received and interpreted according to the current game state.
- **Player control** - The player may move and attack the enemies with the keyboard control.
- **Collisions detection** - Collisions between the player and the enemies are verified.
- **Hit Points** - If the player collides or is attacked by an enemie, loses hit points. 
- **Diferent enemies** - The player will face different enemies throughout the game.
- **Different modes** - The player can choose between the Survival Mode and the Player vs Player mode.
- **Shop interaction and money management** - The player may buy new items in the in game shop, which consist of new weapons and potions, shop is only available after dying on Survival mode.
- **Catching HP Potions** - If the player goes to the position of a potion, this one is going to be collected, adding 10 health points to his total HP.
- **Lives** - In the beggining of the game, the player is given 3 lives (displayed in health on the screen).
- **Dying** - A player dies if his health reaches 0, or less.


### PLANNED FEATURES


- **Player control** - The player may move and attack the enemies with the keyboard control.
- **Collisions detection** - Collisions (still need to be implemented)
- **Diferent enemies** - The player will face different enemies throughout the game.  (still need to be implemented)
- **Shop interaction and money management** - (still need to be implemented)
- **Catching HP Potions** - If the player goes to the position of a potion, this one is going to be collected, adding 10 health points to his total HP. (still need to be implemented)
- **Final Boss** - (still need to be implemented)


### DESIGN

- **Problem in Context.** 

This game uses many classes, and we tried to connect many of them to the Game class, such as Arena, HP, BadGuy, Player and Wall.
We mainly tried to create this classes objects on Game/Arena.


- **The Pattern.** 

We adopted the Builder creational design pattern to construct complex objects step by step.
It was clearly used on our creation of the BadGuy (enemys), along with our Arena class which used the Builder on creating the players, and enemys(eggman's)


- **Implementation.** 

Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.

- **Consequences.** 

The main pros of using this design pattern are: 
 - We could construct objects step-by-step, defer construction steps or run steps recursively.
 - We could reuse the same construction code when building various representations of products.
 - We could isolate complex construction code from the business logic of the product, Single Responsibility Principle. 

But however, the complexity of the code increased since we had to create multiple new classes.


#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:



#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

- João Duarte - %
- Miguel Tavares - %
- Inês Garcia - %
