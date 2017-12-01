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
package Internationalization.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class MultiLanguage
 */
public class MultiLanguage {

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method return the value identified with a key. <br>
     * <b>post: </b>The strings is defined as key and value (key|value).
     *
     * @param pKey - the identifier of the string
     * @param pSourceFile - the language file
     * @return value - the value of the string
     */
    public String loadString(int pKey, String pSourceFile) {
        // Sets the variables
        File file;
        FileInputStream inputStream;
        InputStreamReader streamReader;
        BufferedReader bufferedReader;

        // Sets the deafult value
        String value = "??????";

        try {
            // Loads the languge file
            file = new File(pSourceFile);
            inputStream = new FileInputStream(file);
            // Encode the input in ISO-8859-1
            streamReader = new InputStreamReader(inputStream, "ISO-8859-1");
            // Creates a buffer of read
            bufferedReader = new BufferedReader(streamReader);

            String line;

            // Read the file in search of the key
            while ((line = bufferedReader.readLine()) != null) {
                // If the line contains the key
                if (line.contains(pKey + "|")) {
                    // Divide the string  by the character "|"
                    String[] subString = line.split("\\|");
                    // If the key contains a value
                    if (subString.length > 1) {
                        // Sets the value
                        value = subString[1];
                        break;
                    }
                }
            }

            // Closes the read
            bufferedReader.close();
        } catch (IOException e) {
            // Display the error in console
            System.err.println(e);
        }

        // Resturns the value
        return value;
    }

    /**
     * This method loads the files with the specified extension.
     *
     * @param pPath - the languages path
     * @param pExtension - the extension of files
     * @return files - the language files
     */
    public String[] getLanguageFiles(String pPath, String pExtension) {
        // Sets the variables
        String[] files = null;

        // Loads the languages path
        File directory = new File(pPath);

        // If the path has the directory property
        if (directory.isDirectory()) {
            // List the files with the specified extension
            files = directory.list(new Filter(pExtension));
        }

        // Returns the language files
        return files;
    }

}
