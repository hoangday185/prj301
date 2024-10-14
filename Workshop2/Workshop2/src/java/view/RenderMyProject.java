/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.Project;
import java.util.ArrayList;

/**
 *
 * @author hoanghamhoc
 */
public class RenderMyProject {

    public static String renderMyProject(ArrayList<Project> listProject) {
        String htmlTableBodyRowElement = "";
        for (Project project : listProject) {
            htmlTableBodyRowElement
                    += "  <tr>\n"
                    + "          <td>" + project.getProNum() + "</td>\n"
                    + "          <td>" + project.getProName() + "</td>\n"
                    + "        </tr>";
        }
        String htmlTable = "<table class=\"table table-bordered text-center mt-3\">\n"
                + "      <thead class=\"table-success\">\n"
                + "        <tr>\n"
                + "          <td>Project num</td>\n"
                + "          <td>Project name</td>\n"
                + "        </tr>\n"
                + "      </thead>\n"
                + "      <tbody>\n"
                + htmlTableBodyRowElement
                + "      </tbody>\n"
                + "    </table>";
        return htmlTable;
    }
}
