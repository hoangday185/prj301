/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.Employee;
import dto.TimeWork;
import java.util.ArrayList;

/**
 *
 * @author hoanghamhoc
 */
public class RenderTimeWork {

    public static String renderBodyTable(ArrayList<TimeWork> listTimeWork) {
        String htmlBody = "";
        for (TimeWork timeWork : listTimeWork) {
            htmlBody += " <tr>\n"
                    + "          <td>" + timeWork.getProject().getProName() + "</td>\n"
                    + "          <td>" + timeWork.getTime() + "</td>\n"
                    + "   </tr>";
        }
        return htmlBody;
    }

    public static String renderTotalAndBonus(ArrayList<TimeWork> listTimeWork, double bonus, Employee e) {
        String htmlTotalAndBonus = "";
        double income = e.getSalary();
        for (TimeWork timeWork : listTimeWork) {
            income += timeWork.getTime() * bonus;
        }
        return "<tr class='table-info'>\n"
                + "          <td>Bonus</td>\n"
                + "          <td>" + bonus + "/1 hour</td>\n"
                + "  </tr>"
                + "<tr class='table-success'>\n"
                + "          <td>Total</td>\n"
                + "          <td>" + income + "</td>\n"
                + "  </tr>";
    }

    public static String renderTableReport(String htmlTableBody, String htmlTotalAndBonus) {
        return "<table class=\"table table-bordered text-center\">\n"
                + "      <thead class=\"table-primary\">\n"
                + "        <tr>\n"
                + "          <td>Project name</td>\n"
                + "          <td>Time working</td>\n"
                + "        </tr>\n"
                + "      </thead>\n"
                + "      <tbody>\n"
                + htmlTableBody + htmlTotalAndBonus
                + "      </tbody>\n"
                + "    </table>";
    }
}
