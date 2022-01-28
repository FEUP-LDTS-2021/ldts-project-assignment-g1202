package com.dungeonboy.state;

import java.io.IOException;

public interface GameState {
    void goForward() throws IOException;
    void goBack() throws IOException;
    void win() throws IOException, InterruptedException;
    void lose() throws IOException;
    void display() throws IOException;
}
