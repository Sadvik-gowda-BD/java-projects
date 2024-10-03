package com.it.designpatterns.structural.facade.example2;

// Component 1: DVD Player
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is ON");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player is OFF");
    }
}

// Component 2: Projector
class Projector {
    public void on() {
        System.out.println("Projector is ON");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }
}

// Component 3: Theater Lights
class TheaterLights {
    public void dim(int level) {
        System.out.println("Dimming the lights to " + level + "%");
    }

    public void on() {
        System.out.println("Theater lights are ON");
    }

    public void off() {
        System.out.println("Theater lights are OFF");
    }
}

// Component 4: Surround Sound System
class SurroundSoundSystem {
    public void on() {
        System.out.println("Surround Sound System is ON");
    }

    public void setVolume(int level) {
        System.out.println("Sound volume set to " + level);
    }

    public void off() {
        System.out.println("Surround Sound System is OFF");
    }
}

// Facade: Home Theater Facade
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private TheaterLights lights;
    private SurroundSoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, TheaterLights lights, SurroundSoundSystem soundSystem) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.lights = lights;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(30);
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(50);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the theater...");
        lights.on();
        projector.off();
        soundSystem.off();
        dvdPlayer.off();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Creating the components
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        SurroundSoundSystem soundSystem = new SurroundSoundSystem();

        // Creating the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, lights, soundSystem);

        // Using the facade to watch a movie
        homeTheater.watchMovie("The Matrix");

        // End the movie
        homeTheater.endMovie();
    }
}
