import React from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function Play({ gameState, setGameState }: PlayProps) {
    return (
        <div>
            <p>{gameState.players[0].name} vs {gameState.players[1].name}</p>

            <div id = "player2vakjes">
                <button class="kalaha"> kalaha: {gameState.players[1].pits[6].nrOfStones} </button> 
                <button class="vakje"> {gameState.players[1].pits[5].nrOfStones} </button>
                <button class="vakje"> {gameState.players[1].pits[4].nrOfStones} </button>
                <button class="vakje"> {gameState.players[1].pits[3].nrOfStones} </button>
                <button class="vakje"> {gameState.players[1].pits[2].nrOfStones} </button>
                <button class="vakje"> {gameState.players[1].pits[1].nrOfStones} </button>
                <button class="vakje"> {gameState.players[1].pits[0].nrOfStones} </button>
            </div>

            <div id = "player1vakjes">
                <button class="vakje"> {gameState.players[0].pits[0].nrOfStones} </button>
                <button class="vakje"> {gameState.players[0].pits[1].nrOfStones} </button>
                <button class="vakje"> {gameState.players[0].pits[2].nrOfStones} </button>
                <button class="vakje"> {gameState.players[0].pits[3].nrOfStones} </button>
                <button class="vakje"> {gameState.players[0].pits[4].nrOfStones} </button>
                <button class="vakje"> {gameState.players[0].pits[5].nrOfStones} </button>
                <button class="kalaha"> kalaha: {gameState.players[0].pits[6].nrOfStones} </button>
            </div>

        </div>
    )
}