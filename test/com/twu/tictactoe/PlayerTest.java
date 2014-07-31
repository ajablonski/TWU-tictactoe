package com.twu.tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {


    @Test
    public void shouldTakeTurn() throws IOException {
        BufferedReader fakeBufferedReader = mock(BufferedReader.class);
        when(fakeBufferedReader.readLine()).thenReturn("2");

        Player player = new Player(fakeBufferedReader, "X");

        assertThat(player.getChoice(), is(2));
    }

    @Test
    public void shouldGetSymbol() {
        BufferedReader fakeBufferedReader = mock(BufferedReader.class);
        Player player = new Player(fakeBufferedReader, "X");
        assertThat(player.getSymbol(), is("X"));
    }

}