package com.kevin.practise.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void should_throw_runtimeException_when_x_out_side_board() {
        assertThrows(RuntimeException.class, () -> ticTacToe.play(5, 2));
        assertThrows(RuntimeException.class, () -> ticTacToe.play(0, 2));
    }

    @Test
    public void should_throw_runtimeException_when_y_out_side_board() {
        assertThrows(RuntimeException.class, () -> ticTacToe.play(2, 5));
        assertThrows(RuntimeException.class, () -> ticTacToe.play(2, 0));
    }

    @Test
    public void should_throw_runtimeException_when_occupied() {
        ticTacToe.play(2, 1);
        assertThrows(RuntimeException.class, () -> ticTacToe.play(2, 1));
    }

    @Test
    public void should_get_playerX_when_first_turn() {
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void should_get_playerO_when_last_turn_was_X() {
        ticTacToe.play(1, 1);
        assertEquals('O', ticTacToe.nextPlayer());
    }

    @Test
    public void should_get_playerX_when_last_turn_was_O() {
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 2);
        assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void should_get_no_winner_when_play() {
        String actual = ticTacToe.play(1, 1);
        assertEquals("No winner", actual);
    }

    @Test
    public void should_get_winner_when_play_and_whole_horizontal_line() {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 1); //X
        ticTacToe.play(2, 2); //O
        String actual = ticTacToe.play(3, 1); //X
        assertEquals("X is the winner", actual);

    }

    @Test
    public void should_get_winner_when_play_and_whole_vertical_line() {
        ticTacToe.play(2, 1); //X
        ticTacToe.play(1, 1); //O
        ticTacToe.play(3, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 2); //X
        String actual = ticTacToe.play(1, 3); //O
        assertEquals("O is the winner", actual);
    }

    @Test
    public void should_get_winner_when_play_and_top_bottom_diagonal_line() {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(1, 3); //O
        String actual = ticTacToe.play(3, 3); //X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void should_get_winner_when_play_and_bottom_top_diagonal_line() {
        ticTacToe.play(1, 3); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(2, 2); //X
        ticTacToe.play(1, 1); //O
        String actual = ticTacToe.play(3, 1); //X
        assertEquals("X is the winner", actual);
    }

    @Test
    public void should_draw_when_all_boxes_are_filled() {
        ticTacToe.play(1, 1); //X
        ticTacToe.play(1, 2); //O
        ticTacToe.play(1, 3); //X

        ticTacToe.play(2, 1); //O
        ticTacToe.play(2, 3); //X
        ticTacToe.play(2, 2); //O

        ticTacToe.play(3, 1); //X
        ticTacToe.play(3, 3); //O
        String actual = ticTacToe.play(3, 2); //X
        assertEquals("The result is draw", actual);

    }
}
