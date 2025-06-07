Here's a clean, translated, and restructured version of your README in English, with improved formatting and organization for better readability:

---

# 🎮 Bomberman Clone – OOP Java Project

This project is a Java-based recreation of the classic NES game [Bomberman](https://www.youtube.com/watch?v=mKIOVwqgSXM), created as a large assignment for an Object-Oriented Programming (OOP) course.

<p align="center"><img src="res/demo.png" alt="Bomberman Demo" width="400"/></p>

## 🚀 Starter Project

You can use the following starter code to begin development:

* [Starter Project 1](https://github.com/bqcuong/bomberman-starter/tree/starter-project-1): Includes a working base and structure, with core game mechanics left for you to implement.

---

## 🧩 Game Objects Overview

Game entities are categorized into two main types:

### Dynamic Objects

* **Bomber**: The main character. Can move in four directions via keyboard input.
* **Enemy**: Moves automatically, either randomly or intelligently. Two types are required:

  * `Balloom`: Moves randomly at a fixed speed.
  * `Oneal`: Smarter enemy, can chase the player and changes speed.
* **Bomb**: Placed by the Bomber. Blocks movement for all entities except the Bomber immediately after placement. Explodes after 2 seconds, creating a central flame and flames in four directions.

### Static Objects

* **Grass**: Walkable and bomb-placeable tile.
* **Wall**: Indestructible and blocks movement.
* **Brick**: Destructible tile that may hide portals or items. Blocks movement and bomb placement until destroyed.
* **Portal**: Hidden behind bricks. Becomes visible when the brick is destroyed. Moves to the next level if all enemies are defeated.

### Items (Hidden Behind Bricks)

* **Speed Item** ![](res/sprites/powerup_speed.png): Increases Bomber's speed.
* **Flame Item** ![](res/sprites/powerup_flames.png): Increases bomb explosion range.
* **Bomb Item** ![](res/sprites/powerup_bombs.png): Increases the number of bombs that can be placed at once.

---

## 🎮 Gameplay Mechanics

* **Objective**: Eliminate all enemies and reach the portal to advance to the next level.
* **Game Over**: Occurs if Bomber touches an enemy or flame.
* **Explosion Logic**:

  * Bombs explode after 2 seconds, creating flames.
  * Flames extend in 4 directions (up, down, left, right) and are blocked by bricks, walls, or bombs.
  * Bricks stop the flame at their location and are destroyed.
  * Walls block flame completely.
  * Flames trigger nearby bombs instantly.

---

## 🔧 Project Requirements

### ✅ Mandatory Tasks (+8 pts)

1. **Level Loader** – Load level map from configuration file
2. **Bomber Movement** – Controlled via keyboard
3. **Enemy AI Movement** – Balloom and Oneal
4. **Collision Handling** – Between all entities
5. **Bomb Explosions** – With proper flame mechanics
6. **Item & Portal Handling** – Use items and move through portal

### 🔄 Optional Bonus – Custom Implementation (+3 pts)

* Build the game without using the starter project (code must differ by more than 80%)

### 🚀 Optional Features (+4 pts max)

* Advanced enemy pathfinding (+0.5 pts)
* Additional enemy types (+0.25 pts each)
* AI-controlled Bomber (auto-play) (+1 pt)
* Sound effects and background music (+1 pt)
* Online multiplayer (via server-client system) (+1 pt)
* Other creative features (graded case-by-case)

---

## 📂 Level Configuration Format

Download an example level file: [Level1.txt](https://raw.githubusercontent.com/bqcuong/bomberman-starter/starter-project-1/res/levels/Level1.txt)

* **First Line**: `<Level Number> <Rows> <Columns>`
* **Following Lines**: Map grid using characters:

| Symbol | Meaning         |
| ------ | --------------- |
| `#`    | Wall            |
| `*`    | Brick           |
| `x`    | Portal (hidden) |
| `p`    | Bomber          |
| `1`    | Balloom         |
| `b`    | Bomb Item       |
| `f`    | Flame Item      |
| `s`    | Speed Item      |
| Other  | Grass           |

---

## 🛠️ Implementation Guidelines

### 1. Level Loader

* Edit the `FileLevelLoader` class.
* Read level file into a 2D map array (`_map`), and set `_level`, `_width`, `_height`.

### 2. Bomber Movement

* Edit methods `calculateMove()`, `canMove()`, and `move()` in the `Bomber` class.
* Handle collision detection and character alignment to the tile center.

### 3. Enemy Movement

* Similar to Bomber movement but uses an AI strategy (e.g., `AILow` for random movement).
* Customize `AI.calculateDirection()` to return valid movement directions.

### 4. Collision Handling

* Implement `collide(Entity e)` for:

  * **Brick**: Destroyed by flames
  * **Bomb**: Triggers nearby bombs to explode
  * **Bomber**: Dies on contact with enemies or flames
  * **Enemy**: Dies on flame collision

### 5. Bomb Explosion

* Use `Bomb` class to control timing via `_timeToExplode`.
* After countdown, render central and directional flames.
* Check collisions with all entities in flame range.

### 6. Item and Portal Use

* Use `Bomber.collide()` to pick up items.
* Check if all enemies are eliminated before allowing portal access.

---

## 📚 Notes

* **Tile vs Pixel Coordinates**:

  * Tile: Grid-based (integers), used for map and static objects.
  * Pixel: Display-based (float), used for moving objects.
  * Use `Coordinates.tileToPixel()` and `Coordinates.pixelToTile()` for conversion.

* **Animation & Input Handling**:

  * `Keyboard` class handles input.
  * Set `_moving` and `_direction` to update animation frames.

---

## 🧪 Reference & Credits

* Based on [carlosflorencio/bomberman](https://github.com/carlosflorencio/bomberman)
* Java graphics built with **Java Swing**
* Inspired by the classic **NES Bomberman**

---


