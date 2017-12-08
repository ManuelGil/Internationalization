//    This file is part of Internationalization Project
//    Internationalization Free GNU Application
//    Copyright (C) 2017 Manuel Gil.
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * <p>
 * Title: Internationalization Project</p>
 * <p>
 * Description: Internationalization Free GNU Application</p>
 * <p>
 * Copyright: GPL product</p>
 * <p>
 * Company: <a href="https://github.com/ManuelGil">Manuel Gil</a></p>
 *
 * Problem: Internationalization Project
 *
 * @author $Author: Manuel Gil $
 * @version $Revision: 1.0.0.0001 $ $Date: 12/01/2017 $
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package Internationalization.View;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Class Main
 */
public class Main extends JFrame {

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method summons the start of the components.
     */
    public Main() {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method configures the window.
     */
    private void initComponents() {
        // Title of the window
        this.setTitle("Internationalization");
        // Size of the window
        this.setSize(300, 200);
        // Position of the window
        this.setLocationRelativeTo(null);
        // Close when leaving
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // No resizable
        this.setResizable(false);

        // Create a Central Panel
        CentralPanel centralPanel = new CentralPanel();
        // Adds the central panel in the window
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(centralPanel, BorderLayout.CENTER);
    }

    /**
     * This method starts the program. <br>
     * <b>post: </b>The parameters are not used.
     *
     * @param args - the command line arguments
     */
    public static void main(String[] args) {
        // New instance of the program
        Main frmMain = new Main();
        // Sets the window's visible value
        frmMain.setVisible(true);
    }

}
