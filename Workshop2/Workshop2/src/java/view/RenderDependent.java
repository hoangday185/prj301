/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.Dependent;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author hoanghamhoc
 */
public class RenderDependent {

    public static String renderBirthday(Date birthday) {
        if (birthday == null) {
            return "<td>None</td>";
        }
        return "<td>" + birthday + "</td>";
    }

    public static String renderDependentBody(ArrayList<Dependent> listDependent) {
        String htmlDependent = "";
        for (Dependent dependent : listDependent) {
            String htmlBirthday = renderBirthday(dependent.getDepBirthday());
            htmlDependent += "<tr>\n"
                    + "          <td>" + dependent.getDepName() + "</td>\n"
                    + "          <td>" + dependent.getDepSex() + "</td>\n"
                    + htmlBirthday
                    + "          <td>" + dependent.getDepRelationship() + "</td>\n"
                    + "        </tr>";
        }
        return htmlDependent;
    }

    public static String renderTable(String htmlBody) {
        return "<table class=\"table table-bordered text-center\">\n"
                + "      <thead class=\"table-primary\">\n"
                + "        <tr>\n"
                + "          <td>Dependent name</td>\n"
                + "          <td>Gender</td>\n"
                + "          <td>Birthday</td>\n"
                + "          <td>Relationship</td>\n"
                + "        </tr>\n"
                + "      </thead>\n"
                + "      <tbody>\n"
                + htmlBody
                + "        </tr>\n"
                + "      </tbody>\n"
                + "    </table>";
    }
}
