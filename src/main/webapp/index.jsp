<%-- 
    Document   : index
    Created on : Feb 1, 2022, 11:08:09 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/main.css" type="text/css" />
    <title>Who You Are</title>
  </head>
  <body>    
    <table>
      <tr><td colspan="2"><h1 style="color:darkred;">Who You Are</h1></td></tr>
      <tr>
        <td style="width:50%;padding:20px;border: 1px solid green;">          
          <table>
            <form action="who" method="POST">
              <tr><td><label>Your Name</label></td><td><input type="text" name="name" value="" /></td></tr>
              <tr><td><input type="checkbox" name="canFly" value="ON" /><label>I Can Fly</label></td></tr>
              <tr><td><label>Intelligence</label></td>
                <td><select style="width:80px;" name="intelligence">
                    <option></option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                  </select></td></tr>
              <tr><td><label>Strength</label></td>
                <td><input type="radio" name="strength" value="1" /><label>1</label>
                  <input type="radio" name="strength" value="2" /><label>2</label>
                  <input type="radio" name="strength" value="3" /><label>3</label>
                  <input type="radio" name="strength" value="4" /><label>4</label>
                  <input type="radio" name="strength" value="5" /><label>5</label><br>
                  <input type="radio" name="strength" value="6" /><label>6</label>
                  <input type="radio" name="strength" value="7" /><label>7</label>
                  <input type="radio" name="strength" value="8" /><label>8</label>
                  <input type="radio" name="strength" value="9" /><label>9</label>
                  <input type="radio" name="strength" value="10" /><label>10</label></td></tr>
              <tr><td><label>Speed</label></td>
                <td><input type="range" name="speed" min="1" max="10" value="5"
                           oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><label>Energy</label></td>
                <td><input type="range" name="energy" min="1" max="10" value="5"
                           oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><label>Skill</label></td>
                <td><input type="range" name="skill" min="1" max="10" value="5"
                           oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><label>Leadership</label>
                </td><td><input type="range" name="leadership" min="1" max="10" value="5"
                                oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><label>Charm</label></td>
                <td><input type="range" name="charm" min="1" max="10" value="5"
                           oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><label>Luck</label></td>
                <td><input type="range" name="luck" min="1" max="10" value="5"
                           oninput="this.nextElementSibling.value = this.value"><output>5</output></td></tr>
              <tr><td><br><input type="submit" value="Who You Are" /></td></tr>
            </form>
          </table>
          <p style="color:red;">All fields are required.</p>
        </td>    
        <td style="text-align: center;width:50%;padding:20px;border: 1px solid green;">
          <h3>You Are: <span style="color:red;">Tippy-Toe</span></h3>
          <img alt="Tippy-Toe" src="https://lumiere-a.akamaihd.net/v1/images/marvelrising-characterpose-tippytoe_5d2caaf1.png?region=0%2C0%2C300%2C300"/><br>
          <a href="https://marvelrising.marvelhq.com/characters/tippy-toe" target="_blank">More Details About Tippy-Toe</a>
          <h3>Similarity: <span style="color:red;">10.0%</span></h3>
        </td>
      </tr>
      <tr><td colspan="2" style="text-align: center;">
          <table style="width:100%;text-align: center;padding:20px;border: 1px solid green;">
            <thead>
              <tr>
                <th>Name</th>
                <th>Can Fly</th>
                <th>Intelligence</th>
                <th>Strength</th>
                <th>Speed</th>
                <th>Energy</th>
                <th>Skill</th>
                <th>Leadership</th>
                <th>Charm</th>
                <th>Luck</th>
              </tr>
            </thead>
            <tbody>
              <tr style="border: 1px solid green;">
                <td>You</td>
                <td>false</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
              </tr>
              <tr style="border: 1px solid green;">
                <td>Tippy-Toe</td>
                <td>false</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
              </tr>
            </tbody>
          </table>
        </td></tr>
      <tr><td colspan="2" style="text-align: center;">
          <p style="font-size:85%;">*. All links and images used in this project are from 
            <a href="https://www.marvelhq.com/">https://www.marvelhq.com/</a> and 
            are greatly appreciated.<p></td></tr>

    </table>
  </body>
</html>