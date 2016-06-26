package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.Player;
import com.adaptionsoft.games.trivia.Outputs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GameTest {

    private Game aGame = new Game();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));


    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    private Random inputRandom;
    private String expectedOutput;

    public GameTest(Random inputRandom, String expectedOutput) {
        this.inputRandom = inputRandom;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new Random(0), Outputs.expectedOutputForRandomZero},
                {new Random(1), Outputs.expectedOutputForRandomOne},
                {new Random(2), Outputs.expectedOutputForRandomTwo},
                {new Random(3), Outputs.expectedOutputForRandomThree},
                {new Random(4), Outputs.expectedOutputForRandomFour},
                {new Random(5), Outputs.expectedOutputForRandomFive},
                {new Random(6), Outputs.expectedOutputForRandomSix},
                {new Random(7), Outputs.expectedOutputForRandomSeven}
        });
    }

    @Test
    public void testGame() {
        assertEquals(expectedOutput, runGame(inputRandom));
    }

    private String runGame(Random rand) {
        boolean aWinner;

        aGame.add(new Player("Chet"));
        aGame.add(new Player("Pat"));
        aGame.add(new Player("Sue"));

        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                aWinner = aGame.wrongAnswer();
            } else {
                aWinner = aGame.wasCorrectlyAnswered();
            }

        } while (!aWinner);

        return outContent.toString();
    }
}
