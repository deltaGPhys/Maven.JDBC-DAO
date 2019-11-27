import daos.BoardGameDAO;
import models.BoardGame;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        BoardGameDAO dao = new BoardGameDAO();

        System.out.println("\n****************** Add Records ******************");
        dao.create(new BoardGame("Settlers of Cataan","Acme",2010,4));
        dao.create(new BoardGame("Memoir 44","Days",2012,2));
        dao.create(new BoardGame("Monopoly","Acme",1960,4));
        dao.create(new BoardGame("Ouija Board","Parker Bros",1972,666));
        dao.create(new BoardGame("Sorry","Hasbro",1978,3));

        System.out.println("\n****************** All Records ******************");
        List<BoardGame> games = new ArrayList<BoardGame>(dao.findAll());
        for (BoardGame game : games) {
            System.out.println(game);
        }

        System.out.println("\n***************** Record by Id *****************");
        System.out.println(dao.findById(games.get(2).getId()));

        System.out.println("\n******* Update Record (numPLayers +/- 1) *******");
        BoardGame game = dao.findById(games.get(2).getId());
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
            dao.delete(g.getId());
        }
    }

}
