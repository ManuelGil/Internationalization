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
package Internationalization.Presentation;

import Internationalization.Logic.MultiLanguage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class CentralPanel
 */
public class CentralPanel extends JPanel {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    private JComboBox cmbLanguage;
    private JLabel lblExample;
    private JTextField txtExample;
    private JLabel lblLanguage;
    private JTextField txtLanguage;
    private JButton btnExit;

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final static String STR_DATA_DIR = "/data";
    private final static String STR_LANG_DIR = STR_DATA_DIR + "/lang";
    private final static String STR_LANG_EXT = ".lng";

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------
    private MultiLanguage languages;

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method summons the start of the components.
     */
    public CentralPanel() {
        initComponents();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method starts the variables and components of the panel.
     */
    private void initComponents() {
        // Gets a instance of the model
        languages = new MultiLanguage();
        // Loads the files on the app folder
        String[] languageFiles = languages.getLanguageFiles("." + STR_LANG_DIR, STR_LANG_EXT);

        // Gets the components of the central panel
        cmbLanguage = new JComboBox(languageFiles);
        lblExample = new JLabel("Example");
        txtExample = new JTextField("Example");
        lblLanguage = new JLabel("Language");
        txtLanguage = new JTextField("Language");
        btnExit = new JButton("Exit");

        this.setLayout(null);

        // Adds the components in the panel
        this.add(cmbLanguage);
        this.add(lblExample);
        this.add(txtExample);
        this.add(lblLanguage);
        this.add(txtLanguage);
        this.add(btnExit);

        // Position of the controls
        cmbLanguage.setBounds(5, 10, 280, 30);
        lblExample.setBounds(10, 50, 140, 30);
        txtExample.setBounds(160, 50, 120, 30);
        lblLanguage.setBounds(10, 90, 140, 30);
        txtLanguage.setBounds(160, 90, 120, 30);
        btnExit.setBounds(10, 130, 270, 30);

        // Adds the controller class to action of the controls
        cmbLanguage.addActionListener(new Controller());
        btnExit.addActionListener(new Controller());
    }

    /**
     * This method loads the resources of the selected file within the controls.
     * <br>
     * <b>post: </b>A resource is identified by a unique key.
     */
    public void loadResStrings() {
        // Gets the relative path of the file
        String file = "." + STR_LANG_DIR + "/" + cmbLanguage.getSelectedItem();
        // Load the resource in the text property
        lblExample.setText(languages.loadString(1001, file));
        txtExample.setText(languages.loadString(1002, file));
        lblLanguage.setText(languages.loadString(1003, file));
        txtLanguage.setText(languages.loadString(1004, file));
        btnExit.setText(languages.loadString(1005, file));
    }

    /**
     * Internal class controller
     */
    public class Controller implements ActionListener {

        // -----------------------------------------------------------------
        // Methods
        // -----------------------------------------------------------------
        /**
         * This method handles the behavior of controls.
         *
         * @param e - action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Gets the source of event
            Object source = e.getSource();

            // If the event occurs in the combo box
            if (source.equals(cmbLanguage)) {
                // Loads the resources
                loadResStrings();
            } else {
                // Else, close the program
                System.exit(0);
            }
        }

    }

}
