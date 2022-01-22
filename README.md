## LPOO_<12><02> - Dungeon Boy

### PROJECT DESCRIPTION
Dungeon Boy is a game in which the player goes through different levels and maps and faces different enemies until reaching the final boss. It has 2 playing modes, the Survival mode in which the player has to survive through some tough fights with enemies, The Player vs Player mode (PVP) consists in a mode where the player can face a player 2, and the winner will be crowned on the best results out of 5 intense rounds!

This project was developed by João Duarte (201707984), Miguel Tavares(202002811) and Inês Garcia (202004810) for LDTS 2021-22.

**NOTE** : This game is still on development and could suffer some changes!

### GAME SUMMARY

The game starts with a black terminal with the name of the game, and some commands.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/148138582-3bba6e0e-ec13-4da5-8398-d42c02853e32.png"/>
</p>
<p align="center">
  <b><i>Img 1. Sneak peak into DungeonBoy game</i></b>
</p>
<br>
<br />


If we press ENTER, we are carried into the main menu, where we can select which game mode to play 

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/148138743-0b59bb66-2572-413a-b573-dadb35796689.png"/>
</p>
<p align="center">
  <b><i>Img 2. Main Menu!</i></b>
</p>
<br>
<br />


Survival Mode: We can now play against 4 different Enemies which will try to kill us!


<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/148377444-c903cf90-61a6-4f22-985e-bb82b08d00ab.png"/>
</p>
<p align="center">
  <b><i>Img 3. Survival Mode!</i></b>
</p>
<br>
<br />


If we die, we go straight to the shop, where we can gear up with Weapons and Health Potions and try our luck again!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/148377558-fc3af7d6-02b2-4b05-8afd-a58bebee20d7.png"/>
</p>
<p align="center">
  <b><i>Img 4. Shop</i></b>
</p>
<br>
<br />


PvP Mode: Play against your friend, best of 5 rounds win! Good luck!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/148138866-38876123-19e6-4a9c-9567-150c9f001c57.png"/>
</p>
<p align="center">
  <b><i>Img 5. PvP Mode </i></b>
</p>
<br>
<br />



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
- **Inventory** - Inventory to store our items that we bought from the shop or picked on the map
- **Arena Transition** - Player can pass to another new Arena

### PLANNED FEATURES - Still being implemented!

- **Diferent enemies** - The player will face different enemies throughout the game.  (still need to be implemented)
- **Final Boss** - (still need to be implemented)



### DESIGN

- **Problem in Context.** 

In order to represent the different states which the enemys could be, it was necessary to use a state pattern, so we could implement a pattern that meets our requirements

#### THE ENEMIES ACTIONS SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

- **The Pattern.** 

So we used the state pattern to satisfy the conditions above.
This pattern allowed us to switch between multiple states from runtime of the different subclasses from an abstract one. With this method we were able to simplify the understanding of each enemy and mainly simplify the transitions between each state. When we didnt have any of this implementations there was a function that retrieved all the data and determined randomly each enemy's movement, but only when our character moved too.

- **Implementation.** 

The idea was on having an abstract class which has the objective of drawing the state received by the BadGuyController, which updates the new enemy's state, calculates if its inside the defined bounds (inside the walls) and draws a new position on the terminal.

![image](https://user-images.githubusercontent.com/52889593/149636099-da4eef6e-edf8-452c-a59d-f432d05ad7c4.png)

- **Consequences.** 

The State pattern has the following consequences:

It localizes state-specific behavior and partitions behavior for different states. The State pattern puts all behavior associated with a particular state into one object.
It makes state transitions explicit - Introducing separate objects for different states makes the transitions more explicit
State objects can be shared. If State objects have no instance variables—that is, the state they represent is encoded entirely in their type—then contexts can share a State object.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

So far, we found some code smells which after detection we tried to eliminate them.
However since the game its still not completed we cannot make sure there aren't more of them since we didnt focus on finding them (yet)
We found the following code smells: 

**Bloaters - Large Class** - After starting developing the game we found out that we were using too many code inside the Game class, so we divided the game into more classes such as arena, walls, coins etc... 

**Object-Orientation Abusers - If Statements** - We came to the conclusion that we were using too many if/else if/else conditions in order to get the game terminal running and then getting the menu running as well, so we corrected what we could and replaced them with switch-cases, but tried to reduce the number of times we used them too so we would have a improved code organization.

**Dispensables - Comments** - Yes, of course, comments! We used a lot of comments on the 1st stage of the game so everyone in the project could understand what was going on, and prevent some headaches on the colleagues, we still have some of them at the code, which we will delete later on, but we indeed have deleted already some of them.

**Dispensables -  Duplicate Code** - It happened a few times on some implementations, but after a few checks we manage to fix it.

**Dispensables -  Dead Code** - We came across with some dead code along the way, variables that were never used, functions.. 



### TESTING

- Screenshot of coverage report.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/149919998-fe23c526-51fb-4647-8f11-8e5801f407c1.png"/>
</p>
<p align="center">
  <b><i>Img 6. Code coverage report (so far!)</i></b>
</p>



- Link to mutation testing report.

### SELF-EVALUATION

- João Duarte - %
- Miguel Tavares - %
- Inês Garcia - %
