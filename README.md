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


Survival Mode: We can now play against 6 different Enemies which will try to kill us!
Quick Reminder! Everytime we die, our health gets a penalty each round! Starting HP's: 100, 75, 50. Be carefull!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151533580-d891aa4f-c2ce-495b-8191-e2959bbacfbf.png"/>
</p>
<p align="center">
  <b><i>Img 3. Survival Mode!</i></b>
</p>
<br>
<br />

On this level, we managed to retrieve 3 coins and if we die, we go straight to the shop, where we can gear up with Weapons and Health Potions and try our luck again!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151533718-1371d29e-1f69-43e6-a97c-596cde03c28a.png"/>
</p>
<p align="center">
  <b><i>Img 4. Shop</i></b>
</p>
<br>
<br />

We just bought a Sword for only 2 coins! That's amazing!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151533927-2e64acca-03df-4612-9650-531779b5bd9e.png"/>
</p>
<p align="center">
  <b><i>Img 5. Sword Bought </i></b>
</p>
<br>
<br />

You can check now that we are using a Sword instead of our own Fists!
Sword will deal more damage, and also has more range!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151534119-1a0daf4a-5f14-4693-8f9f-f27252da3064.png"/>
</p>
<p align="center">
  <b><i>Img 6. Sword Switch </i></b>
</p>
<br>
<br />


Inventory! We created an inventory which will store information about what we are carrying in our bag!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151536524-73312078-cdc3-4261-b896-2e0d34123127.png"/>
</p>
<p align="center">
  <b><i>Img 7. Sword Switch </i></b>
</p>
<br>
<br />



PvP Mode: Play against your friend, best of 5 rounds win! Good luck!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151534363-7594fa9a-c8ec-4dc1-bebb-bb9cc11e2f32.png"/>
</p>
<p align="center">
  <b><i>Img 8. PvP Mode </i></b>
</p>
<br>
<br />

Player 1: Yellow, can change between weapons using the 'c' key, and attack using "Space bar" key
Player 2: Red, can change between weapons using the 'q' key, and attack using "Tab" key

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151534852-414aa931-5989-4ef1-b4f6-3c5ed27a59e4.png"/>
</p>
<p align="center">
  <b><i>Img 9. PvP Mode </i></b>
</p>
<br>
<br />

In this example, the Player 2 won! Congrats!

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151535021-328beb54-1218-451e-be88-c00ed18118fa.png"/>
</p>
<p align="center">
  <b><i>Img 10. PvP Mode </i></b>
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
- **PvP Mode** - 2 Players can face each other using different weapons
- **Diferent enemies** - The player will face different enemies throughout the game.  (still need to be implemented)
- **Coin Catch from enemies** - To help the player along the map, we implemented a feature that everytime a enemy dies, it will leave a coin for us to pick
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

We found some code smells which after detection we tried to eliminate them.
Since we are still some newbie developers, there might be some code smells that we actually couldn't smell. But we've made a strong effort! 

We found the following code smells: 

**Bloaters - Large Class** - After starting developing the game we found out that we were using too many code inside the Game class, so we divided the game into more classes such as arena, walls, coins, hp and so on.
We managed to split the program in many separate classes that together make a whole!

**Object-Orientation Abusers - If Statements** - We came to the conclusion that we were using too many if/else if/else conditions in order to get the game terminal running and then getting the menu running as well, so we corrected what we could and replaced them with switch-cases, but tried to reduce the number of times we used them too so we would have a improved code organization. Sometimes we used operators such has && and we really had to keep the if/elses statements.

**Dispensables - Comments** - Yes, of course, comments! We used a lot of comments on the 1st stage of the game so everyone in the project could understand what was going on, and prevent some headaches on the colleagues, along the development we went and deleted some more comments so make the code "cleaner". But there are some that we believe that are important to keep.

**Dispensables -  Duplicate Code** - It happened a few times on some implementations, mostly on coin,wall, badguy, player classes since we implemented an Element abstract class. It made us realize that we had a lot of duplicate code.

**Dispensables -  Dead Code** - We came across with some dead code along the way, variables that were never used, functions, such has get_wall_width, set_wall_widths basically some getters and setters that we make on default and sometimes they arent even acessed 

**Bloaters - Data Clumps** - On this final delivery we have came across some data clumps, being said, we found many variables that were being used very similarly. Specially on the position class, since we had to implement positions for everyone! 
Enemys, players, boss, player2 all needed positions.


### TESTING

- Screenshot of coverage report.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151680695-ca30be9c-35ba-4025-853f-f05fe85de67b.png"/>
</p>
<p align="center">
  <b><i>Img 11. Code coverage report (so far!)</i></b>
</p>

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/52889593/151680687-28ff7e3b-9946-4558-9e66-197a1a6b37e7.png"/>
</p>
<p align="center">
  <b><i>Img 12. Code coverage report on state files </i></b>
</p>


<a href="https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1202/blob/58a1887c3f3d7419fff7c83e9eadd64393fd2fc7/index.html"> Link to mutation testing report. </a>


### SELF-EVALUATION

- João Duarte - 33.3%
- Miguel Tavares - 33.3%
- Inês Garcia - 33.3%

