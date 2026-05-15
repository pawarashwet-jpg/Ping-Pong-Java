\# Multithreaded Pong Engine (Java)

<img width="1476" height="811" alt="image" src="https://github.com/user-attachments/assets/70f9b02f-8564-4cd5-af96-6c041bd425c0" />


A modular, object-oriented 2D Pong game built from scratch using Java Swing and AWT. This project focuses on clean architecture, decoupling game logic from rendering, and efficient event handling.



\## 🚀 Technical Highlights



\* \*\*Multithreaded Game Loop:\*\* Implemented a dedicated `gameThread` using `Runnable` to handle physics updates and rendering at a consistent 100 FPS.

\* \*\*Decoupled Architecture:\*\* Separated concerns into specialized classes:

&#x20;   \* `CollisionManager`: Handles physics and scoring logic (Static utility).

&#x20;   \* `Pads` \& `Ball`: Encapsulated game objects with their own update and draw methods.

&#x20;   \* `Score`: Manages UI-specific rendering for the game state.

\* \*\*Event Handling:\*\* Centralized input through `GameFrame` to solve focus-contention issues common in Swing components.

\* \*\*Custom Collision Physics:\*\* Developed a robust collision system that prevents "hitbox sticking" using forced coordinate offsets.



\## 🛠️ Tech Stack

\* \*\*Language:\*\* Java 8+

\* \*\*Library:\*\* Swing / AWT (Graphics2D)

\* \*\*Concurrency:\*\* Java Threads


\## 📂 Project Structure

```text

src/com/pawar/pingpong/

├── Pings.java             # Main Entry Point

├── GameFrame.java         # Main Window \& Input Handling

├── Ball.java              # Ball Physics \& Rendering

├── Pads.java              # Paddle Logic \& Movement

├── Score.java             # Scoreboard Rendering

└── CollisionManager.java  # Physics Engine

