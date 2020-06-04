package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
	
	public String connect(String text) {
		String myText = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dumble?serverTimezone=UTC",
					"root", "");

			Statement statement = con.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT * FROM Dumble.masterscplist Where Title like '%" + text + "%'");

			myText += "<style>\n" + "#customers {\n"
					+ "  font-family: \"Trebuchet MS\", Helvetica, Helvetica, Helvetica;\n"
					+ "  border-collapse: collapse;\n" + "  width: 100%;\n" + "}\n" + "\n"
					+ "#customers td, #customers th {\n" + "  border: 1px solid #ddd;\n" + "  padding: 8px;\n" + "}\n"
					+ "\n" + "#customers tr:nth-child(even){background-color: #f2f2f2;}\n" + "\n"
					+ "#customers tr:hover {background-color: lightpink;}\n" + "\n" + "#customers th {\n"
					+ "  padding-top: 12px;\n" + "  padding-bottom: 12px;\n" + "  text-align: left;\n"
					+ "  background-color: lightblue;\n" + "  color: black;\n" + "}\n" + "</style>" + "" + "" + "" + ""
					+ "" + "<table id=\"customers\">\n" + "  <tr>\n" + "    <th>Title</th>\n" + "    <th>Rating</th>\n"
					+ "    <th>Type</th>\n" + "  </tr>";

			while (result.next()) {

				myText += "<tr><td>";
				myText += result.getString("Title");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("rating");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("Type");
				myText += "</td>";
				myText += "</tr>";

			}

		} catch (Exception p) {
			System.out.println("error 1");
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dumble?serverTimezone=UTC",
					"root", "");

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Dumble.ikea_names Where name like '%" + text + "%'\n"
					+ "union\n" + "SELECT * FROM Dumble.ikea_names Where description like '%" + text + "%';");

			while (result.next()) {

				myText += "<tr><td>";
				myText += result.getString("name");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("description");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("Column_3");
				myText += "</td>";
				myText += "</tr>";

			}

		} catch (Exception p) {
			System.out.println("error 2");
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dumble?serverTimezone=UTC",
					"root", "");

			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Dumble.bearbase Where 'Character' like '%" + text
					+ "%'\n" + "union\n" + "SELECT * FROM Dumble.bearbase Where Origin like '%" + text + "%'\n"
					+ "union\n" + "SELECT * FROM Dumble.bearbase Where Notes like '%" + text + "%';");

			while (result.next()) {

				myText += "<tr><td>";
				myText += result.getString("Character");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("Origin");
				myText += "</td>";
				myText += "<td>";
				
				myText += result.getString("Creator");
				myText += "</td>";
				myText += "</tr>";
			
			}

			myText += "</table>";

		} catch (Exception p) {
			System.out.println("error 3");
		}

		return myText;
	}

}