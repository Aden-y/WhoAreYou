package com.sheridan.whoareyou.controller;

import com.sheridan.whoareyou.models.Avanger;
import com.sheridan.whoareyou.models.AvangerFileIO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.InputStream;
import java.util.List;

public class MainServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/avengers.csv");
        Avanger defaultAv = new Avanger("You", false, 0, 0, 0, 0, 0, 0, 0, 0, "", "");
        List<Avanger> list = AvangerFileIO.loadAvangers(path);
        
        String error = "";
        try {
            String name = request.getParameter("name");
            if(name.trim().equals("")) {
                error = "All fields are required.";
            }else {
                defaultAv.setName(name);
            }
            
            String cf = request.getParameter("canFly");
            boolean canFly = cf != null && cf.equals("ON");
            defaultAv.setCanFly(canFly);
            int intelligence = Integer.parseInt(request.getParameter("intelligence"));
            defaultAv.setIntelligence(intelligence);
                    int strength = Integer.parseInt(request.getParameter("strength"));
                    defaultAv.setStrength(strength);
                    int speed = Integer.parseInt(request.getParameter("speed"));
                    defaultAv.setSpeed(speed);
                    int energy = Integer.parseInt(request.getParameter("energy"));
                    defaultAv.setEnergy(energy);
                    int skill = Integer.parseInt(request.getParameter("skill"));
                    defaultAv.setSkill(skill);
                    int leadership = Integer.parseInt(request.getParameter("leadership"));
                    defaultAv.setLeadership(leadership);
                    int charm = Integer.parseInt(request.getParameter("charm"));
                    defaultAv.setCharm(charm);
                    int luck = Integer.parseInt(request.getParameter("luck"));
                    defaultAv.setLuck(luck);
        }catch(Exception ex) {
            error = "All fields are required.";
           ex.printStackTrace();
        }
        
        Avanger match = AvangerFileIO.findSimilar(defaultAv, list);
        double sim = defaultAv.getSimilarity(match);
        response.setContentType("text/html;charset=UTF-8");
        String html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "    <link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\" />\n" +
                    "    <title>Who You Are</title>\n" +
                    "  </head>\n" +
                    "  <body>    \n" +
                    "    <table>\n" +
                    "      <tr><td colspan=\"2\"><h1 style=\"color:darkred;\">Who You Are</h1></td></tr>\n" +
                    "      <tr>\n" +
                    "        <td style=\"width:50%;padding:20px;border: 1px solid green;\">          \n" +
                    "          <table>\n" +
                    "            <form action=\"who\" method=\"POST\">\n" +
                    "              <tr><td><label>Your Name</label></td><td><input type=\"text\" name=\"name\" value=\"\" /></td></tr>\n" +
                    "              <tr><td><input type=\"checkbox\" name=\"canFly\" value=\"ON\" /><label>I Can Fly</label></td></tr>\n" +
                    "              <tr><td><label>Intelligence</label></td>\n" +
                    "                <td><select style=\"width:80px;\" name=\"intelligence\">\n" +
                    "                    <option></option>\n" +
                    "                    <option>1</option>\n" +
                    "                    <option>2</option>\n" +
                    "                    <option>3</option>\n" +
                    "                    <option>4</option>\n" +
                    "                    <option>5</option>\n" +
                    "                    <option>6</option>\n" +
                    "                    <option>7</option>\n" +
                    "                    <option>8</option>\n" +
                    "                    <option>9</option>\n" +
                    "                    <option>10</option>\n" +
                    "                  </select></td></tr>\n" +
                    "              <tr><td><label>Strength</label></td>\n" +
                    "                <td><input type=\"radio\" name=\"strength\" value=\"1\" /><label>1</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"2\" /><label>2</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"3\" /><label>3</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"4\" /><label>4</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"5\" /><label>5</label><br>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"6\" /><label>6</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"7\" /><label>7</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"8\" /><label>8</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"9\" /><label>9</label>\n" +
                    "                  <input type=\"radio\" name=\"strength\" value=\"10\" /><label>10</label></td></tr>\n" +
                    "              <tr><td><label>Speed</label></td>\n" +
                    "                <td><input type=\"range\" name=\"speed\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                           oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><label>Energy</label></td>\n" +
                    "                <td><input type=\"range\" name=\"energy\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                           oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><label>Skill</label></td>\n" +
                    "                <td><input type=\"range\" name=\"skill\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                           oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><label>Leadership</label>\n" +
                    "                </td><td><input type=\"range\" name=\"leadership\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                                oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><label>Charm</label></td>\n" +
                    "                <td><input type=\"range\" name=\"charm\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                           oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><label>Luck</label></td>\n" +
                    "                <td><input type=\"range\" name=\"luck\" min=\"1\" max=\"10\" value=\"5\"\n" +
                    "                           oninput=\"this.nextElementSibling.value = this.value\"><output>5</output></td></tr>\n" +
                    "              <tr><td><br><input type=\"submit\" value=\"Who You Are\" /></td></tr>\n" +
                    "            </form>\n" +
                    "          </table>\n" +
                    "          <p style=\"color:red;\">"+error+"</p>\n" +
                    "        </td>    \n" +
                    "        <td style=\"text-align: center;width:50%;padding:20px;border: 1px solid green;\">\n" +
                    "          <h3>You Are: <span style=\"color:red;\">"+match.getName()+"</span></h3>\n" +
                    "          <img alt=\"Tippy-Toe\" src=\""+match.getImageUrl()+"\"/><br>\n" +
                    "          <a href=\""+match.getDetailUrl()+"\" target=\"_blank\">More Details About "+match.getName()+"</a>\n" +
                    "          <h3>Similarity: <span style=\"color:red;\">"+sim+"%</span></h3>\n" +
                    "        </td>\n" +
                    "      </tr>\n" +
                    "      <tr><td colspan=\"2\" style=\"text-align: center;\">\n" +
                    "          <table style=\"width:100%;text-align: center;padding:20px;border: 1px solid green;\">\n" +
                    "            <thead>\n" +
                    "              <tr>\n" +
                    "                <th>Name</th>\n" +
                    "                <th>Can Fly</th>\n" +
                    "                <th>Intelligence</th>\n" +
                    "                <th>Strength</th>\n" +
                    "                <th>Speed</th>\n" +
                    "                <th>Energy</th>\n" +
                    "                <th>Skill</th>\n" +
                    "                <th>Leadership</th>\n" +
                    "                <th>Charm</th>\n" +
                    "                <th>Luck</th>\n" +
                    "              </tr>\n" +
                    "            </thead>\n" +
                    "            <tbody>\n" +
                    "              <tr style=\"border: 1px solid green;\">\n" +
                    "                <td>"+defaultAv.getName()+"</td>\n" +
                    "                <td>"+defaultAv.isCanFly()+"</td>\n" +
                    "                <td>"+defaultAv.getIntelligence()+"</td>\n" +
                    "                <td>"+defaultAv.getStrength()+"</td>\n" +
                    "                <td>"+defaultAv.getSpeed()+"</td>\n" +
                    "                <td>"+defaultAv.getEnergy()+"</td>\n" +
                    "                <td>"+defaultAv.getSkill()+"</td>\n" +
                    "                <td>"+defaultAv.getLeadership()+"</td>\n" +
                    "                <td>"+defaultAv.getCharm()+"</td>\n" +
                    "                <td>"+defaultAv.getLuck()+"</td>\n" +
                    "              </tr>\n" +
                    "              <tr style=\"border: 1px solid green;\">\n" +
                    "                <td>"+match.getName()+"</td>\n" +
                    "                <td>"+match.isCanFly()+"</td>\n" +
                    "                <td>"+match.getIntelligence()+"</td>\n" +
                    "                <td>"+match.getStrength()+"</td>\n" +
                    "                <td>"+match.getSpeed()+"</td>\n" +
                    "                <td>"+match.getEnergy()+"</td>\n" +
                    "                <td>"+match.getSkill()+"</td>\n" +
                    "                <td>"+match.getLeadership()+"</td>\n" +
                    "                <td>"+match.getCharm()+"</td>\n" +
                    "                <td>"+match.getLuck()+"</td>\n" +
                    "              </tr>\n" +
                    "            </tbody>\n" +
                    "          </table>\n" +
                    "        </td></tr>\n" +
                    "      <tr><td colspan=\"2\" style=\"text-align: center;\">\n" +
                    "          <p style=\"font-size:85%;\">*. All links and images used in this project are from \n" +
                    "            <a href=\"https://www.marvelhq.com/\">https://www.marvelhq.com/</a> and \n" +
                    "            are greatly appreciated.<p></td></tr>\n" +
                    "\n" +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>";
        try ( PrintWriter out = response.getWriter()) {
            out.println(html);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
