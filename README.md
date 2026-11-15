# Online Flip 7

An online version of the card game "Flip 7"

## The Problem

I want to create an online version of the card game Flip 7, a card game where each player draws cards throughout multiple rounds until they reach 200 points. My siblings and I play the game often, but we also tend to lose cards around the house, so I'd love to have an online version that doesn't risk getting lost.

## How It Works

- Initialize all main class files (Player, Card, Main)
- Scan user's input to get the number of players, their names, and keep track of starting score
- Add all the cards types in the game
- Create methods for each action card and ensure they act immediately when a player draws one
- Continously check whether a player is still in the game or has become inactive; only active players may play
- Reset player's cards each round, but only reset the deck when it is empty
- Check win condition of any player that has a total of 200 points spanning all rounds and end game when win condition is met

![System diagram](SystemDiagram.drawio.png)

## Tech Stack

- **Language:** Java
- **Libraries:** Java.util, Java.io

## Setup

```bash
git clone https://github.com/insertCreativity1/CS193-Final-Project
cd CS193-Final-Project
```

## Usage

```
java Main.java
```

## Roadmap

Features you haven't built yet but plan to (pull these from your
"Schedule" quadrant in the Eisenhower Matrix).

- [ ] Graphics
- [ ] Additional action cards

## Author

Minhah Ali 
https://github.com/insertCreativity1
