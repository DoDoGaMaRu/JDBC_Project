package database;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ShowSubject {
    protected String show(Connection con) {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM Subject";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            sb.append("\t\t과목번호\t과목이름\n");
            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                String subjectName = rs.getString("subjectName");

                sb.append("\t\t" + subjectId + "\t\t" + subjectName);
                sb.append("\n\n");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
