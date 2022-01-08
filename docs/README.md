
# LDTS_T12_G02 - Dungeon Boy

## Game Description


The Dungeon Boy is a Dungeon-Crawler like based game in which the player goes through different levels and maps and faces different enemies until reaching the final boss. It has 2 playing modes, the Survival mode in which the player has to survive through some tough fights with enemies, and try not to die along the way (at least not too many times).
The Player vs Player mode (PVP) consists in a mode where the player can face a player 2, and the winner will be crowned on the best results out of 5 intense rounds.

This project was developed by João Duarte (201707984), Miguel Tavares(202002811)   and Inês Garcia ( 202004810) for LDTS 2021-22.

**NOTE** : This game is still on development and could suffer some changes!

### GAME SUMMARY

The game starts with a black terminal with the name of the game, and some commands.

![image](https://user-images.githubusercontent.com/52889593/148138582-3bba6e0e-ec13-4da5-8398-d42c02853e32.png)

If we press ENTER, we are carried into the main menu, where we can select which game mode to play 

![image](https://user-images.githubusercontent.com/52889593/148138743-0b59bb66-2572-413a-b573-dadb35796689.png)

Survival Mode: We can now play against 4 different Enemies which will try to kill us!

![image](https://user-images.githubusercontent.com/52889593/148377444-c903cf90-61a6-4f22-985e-bb82b08d00ab.png)

If we die, we go straight to the shop, where we can gear up with Weapons and Health Potions and try our luck again!

![image](https://user-images.githubusercontent.com/52889593/148377558-fc3af7d6-02b2-4b05-8afd-a58bebee20d7.png)

PvP Mode: Play against your friend, best of 5 rounds wins! Good luck!

![image](https://user-images.githubusercontent.com/52889593/148138866-38876123-19e6-4a9c-9567-150c9f001c57.png)



### IMPLEMENTED FEATURES

- **Connected Menus** - The user has the capability of browsing through the different menus including in game ones. (Ex: Intro Menu, Main Menu with mode selection screens, Instructions,  Shop(when dead) and ESC.
- **Keyboard control** - The keyboard inputs are received and interpreted according to the current game state.
- **Player control** - The player may move and attack the enemies with the keyboard control.
- **Collisions detection** - Collisions between the player and the enemies are verified.
- **Hit Points** - If the player collides or is attacked by an enemie, loses hit points. 
- **Diferent enemies** - The player will face different enemies throughout the game.
- **Different modes** - The player can choose between the Survival Mode and the Player vs Player mode.
- **Shop interaction and money management** - The player may buy new items in the in game shop, which consist of new weapons and potions, shop is only available after dying on Survival mode.
- **Catching Coins** - If the player goes to the position of a coin, this one is going to be collected, adding some money to our inventory which can be used in the Shop.
- **Lives** - In the beggining of the game, the player is given 3 lives (displayed in health on the screen).
- **Dying** - A player dies if his health reaches 0, or less.
- **Inventory** - Inventory to store our items that we bought from the shop.


### PLANNED FEATURES - Still being implemented!


- **Collisions detection** - Enemies colisions with walls still being implemented
- **Coin Catching / Draw** - Still not fully implemented
- **Diferent enemies** - The player will face different enemies throughout the game.  (still need to be implemented)
- **Final Boss** - (still need to be implemented)
- **Inventory** - There will be an inventory to store our items that we bought from the shop.
- **Arena Transition** - Player can pass to another new Arena

## Design

### The Pattern.

We adopted the Builder creational design pattern to construct complex objects step by step.
It was clearly used on our creation of the BadGuy (enemys), along with our Arena class which used the Builder on creating the players, and enemys(eggman's)

There are still other patterns that we are willing to use on the further development of the game such as: 
- State Pattern  - Will be used to define the moving states of our enemies constantly without having to wait for our player to move so they move as well, they just enter a state where they keep moving around, same as the final boss too, and also when we enter new maps/arena on the next level.
 
- Factory method - Creating an interface that receives information from the other subclasses, such as game, arena, walls etc..


- **Implementation.** 

We stil have not implemented fully the patterns, and still are designing the UML diagrams in order to improve the overall game quality.

- **Consequences.** 

The main pros of using the Builder design pattern are: 
 - We could construct objects step-by-step, defer construction steps or run steps recursively.
 - We could reuse the same construction code when building various representations of products.
 - We could isolate complex construction code from the business logic of the product, Single Responsibility Principle. 

But however, the complexity of the code increased since we had to create multiple new classes.

For the State pattern:

### PROS:
- We get the Open/Closed principle and Single responsability principle 

### CONS:
- We could have a hard time trying to implement it. (CON)

For the Factory method pattern:
### PROS:
- We get the Open/Closed principle and Single responsability principle 


### Observers and listeners
#### Problem in Context:  
Our game is controlled by the keyboard, many are the ways to receive input from the keyboard, in this game we used the KeyStroke, and KeyType functions from lanterna, which after defining the key we wanted to use, if a condition was verified it would receive an input from a specific key and use it to a defined action.
We used it to respond to terminal messages such as "Press Enter to start the game", and after pressing the desired key it would take us for another menu.
After that we would setup the arrow keys to navigate through the menu, and also the actual gameplay too.

#### The Pattern:

#### Implementation:

#### Consequences:



### Different types of commands

#### The Pattern:

#### Implementation:

#### Consequences:

### GUI
#### Problem in Context:
Initially we were thinking in using java GUI in order to make the game more pleasant, however after discussing with the teachers, even though it would be better visually, it was not the main concern on making this project, and not the main concern on evaluation for the game. 
This game was developed and more focused on the code itself and how we would manage to get out of some tricky situations with some clever implementations.
Being said, we used only lanterna capabilitys on this game, which are reduced and with lower graphics designs.

#### Consequences: 
- Not Visually appealing


## Known Code Smells And Refactoring Suggestions

So far, we found some code smells which after detection we tried to eliminate them.
However since the game its still not completed we cannot make sure there aren't more of them since we didnt focus on finding them (yet)
We found the following code smells: 

**Bloaters - Large Class** - After starting developing the game we found out that we were using too many code inside the Game class, so we divided the game into more classes such as arena, walls, coins etc... 

**Object-Orientation Abusers - If Statements** - We came to the conclusion that we were using too many if/else if/else conditions in order to get the game terminal running and then getting the menu running as well, so we corrected what we could and replaced them with switch-cases, but tried to reduce the number of times we used them too so we would have a improved code organization.

**Dispensables - Comments** - Yes, of course, comments! We used a lot of comments on the 1st stage of the game so everyone in the project could understand what was going on, and prevent some headaches on the colleagues, we still have some of them at the code, which we will delete later on, but we indeed have deleted already some of them.

**Dispensables -  Duplicate Code** - It happened a few times on some implementations, but after a few checks we manage to fix it.

**Dispensables -  Dead Code** - We came across with some dead code along the way, variables that were never used, functions.. 

## Testing

### Screenshot of coverage report
To be completed..

### Link to mutation testing report
To be completed..

## Self-evaluation

- João Duarte - %
- Miguel Tavares - %
- Inês Garcia - %
