import daos.BoardGameDAO;
import models.BoardGame;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        BoardGameDAO dao = new BoardGameDAO();

        System.out.println("\n****************** All Records ******************");
        List<BoardGame> games = new ArrayList<BoardGame>(dao.findAll());
        for (BoardGame game : games) {
            System.out.println(game);
        }

        System.out.println("\n***************** Record by Id *****************");
        System.out.println(dao.findById(3));

        System.out.println("\n******* Update Record (numPLayers +/- 1) *******");
        BoardGame game = dao.findById(3);
        int numP = game.getNumPlayers();
        game.setNumPlayers((numP%2 == 0) ? numP+1 : numP-1);
        System.out.println(dao.update(game));

        System.out.println("\n************* Add and Delete Record ************");
        BoardGame newGame = new BoardGame("Trivial Pursuit","Parker Bros",1982,6);
        BoardGame createdGame = dao.create(newGame);
        int id = createdGame.getId();
        System.out.println(dao.findById(id));
        System.out.println("\n(Delete)");
        dao.delete(id);
        games = new ArrayList<BoardGame>(dao.findAll());
        for (BoardGame g : games) {
            System.out.println(g);
        }
    }

}
