package daos;

import models.BoardGame;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BoardGameDAO implements DAO<BoardGame> {

    private Connection connection = ConnectionFactory.getConnection();

    @Override
    public BoardGame findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            sql = String.format("SELECT * FROM BoardGames WHERE id=%d;", id);
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<BoardGame> results = new ArrayList<BoardGame>();

            if (rs.next()) {
                return new BoardGame(rs.getInt("id"), rs.getString("name"), rs.getString("mfr"), rs.getInt("year"), rs.getInt("numPlayers"));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<BoardGame> findAll()  {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            sql = "SELECT * FROM BoardGames;";
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            ArrayList<BoardGame> results = new ArrayList<BoardGame>();
            while (rs.next()) {
                results.add(new BoardGame(rs.getInt("id"),rs.getString("name"),rs.getString("mfr"),rs.getInt("year"),rs.getInt("numPlayers")));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BoardGame update(BoardGame object) {
        try {
            int id = object.getId();
            Statement stmt = connection.createStatement();
            String sql;
            sql = String.format("UPDATE BoardGames SET name='%s', mfr='%s', year=%d, numPlayers=%d WHERE id=%d;",object.getName(),object.getMfr(),object.getYear(),object.getNumPlayers(),id);

            if (stmt.executeUpdate(sql) == 1) {
                return findById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BoardGame create(BoardGame object) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            sql = String.format("INSERT INTO BoardGames (name, mfr, year, numPlayers) VALUES ('%s','%s',%d,%d);",object.getName(),object.getMfr(),object.getYear(),object.getNumPlayers());

            stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return findById(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            Statement stmt = connection.createStatement();
            String sql;
            sql = String.format("DELETE FROM BoardGames WHERE id=%d",id);

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
