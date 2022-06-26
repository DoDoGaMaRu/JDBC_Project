package database;

import oracle.jdbc.internal.OracleTypes;

import java.sql.*;

public class ShowSubjectAttendance {
    protected String show(Connection con, int sbjId) {
        StringBuilder sb = new StringBuilder();
        String query = ("SELECT DISTINCT id FROM signUp "
                + "WHERE " + sbjId + " = signUp.subjectId");

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            sb.append("\t\t학번\n");
            while(rs.next()) {
                String id = rs.getString("id");

                sb.append("\t\t" + id);
                sb.append("\n\n");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
