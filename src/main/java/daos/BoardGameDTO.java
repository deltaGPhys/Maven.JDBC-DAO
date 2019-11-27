package daos;

import models.BoardGame;

public class BoardGameDTO implements DTO<BoardGame> {

    @Override
    public int getId(BoardGame boardGame) {
        return 0;
    }
}
