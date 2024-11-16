package com.company.game;

public class Game {
    private final String NAME;
    private final Ganre GANRE;
    private final Type TYPE;

    private Game(String name, Ganre genre, Type type) {
        this.NAME = name;
        this.GANRE = genre;
        this.TYPE = type;
    }

    public static class GameDisk{
        private String description;
        private final Game DATA;

        private GameDisk(String name, Ganre ganre, String description){
            this.description = description;
            this.DATA = new Game(name, ganre, Type.PHYSICAL);
        }

        public String getDescription() {
            return description;
        }

        public Game getDATA() {
            return DATA;
        }
    }

    public static class VirtualGame{
        private int rating;
        private final Game DATA;

        private VirtualGame(String name, Ganre ganre, int rating){
            if (rating > 0 && rating <= 5) {
                this.rating = rating;
                this.DATA = new Game(name, ganre, Type.VIRTUAL);
            }else {
                throw new IllegalArgumentException("Rating must be between 0 and 5.");
            }
        }

        public int getRating() {
            return rating;
        }

        public Game getDATA() {
            return DATA;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

    public static GameDisk getDisk(String name, Ganre ganre, String description) {
        return new GameDisk(name, ganre, description);
    }

    public static VirtualGame getVirtualGame(String name, Ganre ganre, int rating) {
        return new VirtualGame(name, ganre, rating);
    }

    public String getNAME() {
        return NAME;
    }

    public Ganre getGANRE() {
        return GANRE;
    }

    public Type getTYPE() {
        return TYPE;
    }
}
