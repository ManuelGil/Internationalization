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

import java.io.File;
import java.io.FilenameFilter;

/**
 * Class Filter
 */
public class Filter implements FilenameFilter {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    private final String extension;

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------
    /**
     * This method create a new Filter. <br>
     * <b>post: </b>Defined an extension.
     *
     * @param pExtension - extencion of the files
     */
    public Filter(String pExtension) {
        extension = pExtension;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * This method verifies that the file extension is correct.
     *
     * @param dir - Path of the language files
     * @param name - Name of the file
     */
    @Override
    public boolean accept(File dir, String name) {
        // Checks the extension of the file
        return name.endsWith(extension);
    }

}
