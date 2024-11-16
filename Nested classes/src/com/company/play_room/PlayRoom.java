package com.company.play_room;

import com.company.game.Game;
import com.company.game.Ganre;
import com.company.game.Type;
import com.company.game_console.Brand;
import com.company.game_console.ConsoleShutdownException;
import com.company.game_console.GameConsole;

import java.util.Arrays;
import java.util.Comparator;

public class PlayRoom {
    public static void main(String[] args) throws ConsoleShutdownException {
        Game.GameDisk[] physicalGames = new Game.GameDisk[4];
        physicalGames[0] = Game.getDisk("Gran Turismo", Ganre.RACE, "Realistic racing game with great graphics.");
        physicalGames[1] = Game.getDisk("FIFA 23", Ganre.SPORT, "The latest football simulator.");
        physicalGames[2] = Game.getDisk("The Witcher 3", Ganre.ACTION, "Action RPG in a fantasy world.");
        physicalGames[3] = Game.getDisk("Need for Speed", Ganre.RACE, "Fast-paced racing game.");

        Game.VirtualGame[] virtualGames = new Game.VirtualGame[4];
        virtualGames[0] = Game.getVirtualGame("Cyberpunk 2077", Ganre.ACTION, 4);
        virtualGames[1] = Game.getVirtualGame("Minecraft", Ganre.ADVENTURE, 3);
        virtualGames[2] = Game.getVirtualGame("Among Us", Ganre.PUZZLE, 5);
        virtualGames[3] = Game.getVirtualGame("Call of Duty", Ganre.ACTION, 2);

        // Создание игровой консоли
        GameConsole console = new GameConsole(Brand.SONY,"PlayStation 5");

        Arrays.sort(physicalGames, new Comparator<Game.GameDisk>() {

            @Override
            public int compare(Game.GameDisk o1, Game.GameDisk o2) {
                return o1.getDATA().getGANRE().compareTo(o2.getDATA().getGANRE());
            }
        });

        Arrays.sort(virtualGames, new Comparator<Game.VirtualGame>() {
            @Override
            public int compare(Game.VirtualGame a, Game.VirtualGame b) {
                return Double.compare(a.getRating(), b.getRating());
            }
        });

        console.loadGame(physicalGames[0].getDATA());
        console.playGame();
    }
}
