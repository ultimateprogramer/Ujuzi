/**
 * Copyright 2010 Ahmed Mohammed Maaway
 *
 * This file is part of Ujuzi.
 *
 * Ujuzi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Ujuzi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Ujuzi.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Additional information can be found in README.txt or at
 * <http://www.ujuziapp.com/>.
 *
 */

package com.ujuzi.xml;

import com.ujuzi.data.Category;
import java.util.Enumeration;
import java.util.Vector;
import nanoxmlj2me.kXMLElement;

/**
 *
 * @author Ahmed Maawy
 */
public class XMLCategories {

    private Vector categories;

    public XMLCategories() {
        categories = new Vector();
    }

    private void processEntry(String elementName, String elementValue, boolean isNew, boolean isChild) {

        Category myCategory;

        if(isNew) {
            // New category
            myCategory = new Category();
        } else {
            if(isChild) {
                // Get the child category
                myCategory = (Category)categories.elementAt(categories.size() - 1);
                myCategory = (Category)myCategory.getChildCategories().elementAt(myCategory.getChildCategories().size() - 1);
            } else {
                // Root category
                myCategory = (Category)categories.elementAt(categories.size() - 1);
            }
        }

        // Fill in the variable

        if(elementName.equals("categoryId")) {
            myCategory.setCategoryID(elementValue);
        } else if(elementName.equals("categoryName")) {
            myCategory.setCategoryName(elementValue);
        } else if(elementName.equals("depth")) {
            myCategory.setDepth(elementValue);
        } else if(elementName.equals("parentId")) {
            myCategory.setParentID(elementValue);
        }

        if(isNew) {
            // Add a new element
            if(isChild) {
                addChildElement(myCategory);
            } else {
                addRootElement(myCategory);
            }
        }
    }

    private void addChildElement(Category newCategory) {
        int currentElement = categories.size() - 1;
        Category currentCategory = (Category)categories.elementAt(currentElement);

        currentCategory.getChildCategories().addElement(newCategory);
    }

    private void addRootElement(Category newCategory) {
        categories.addElement(newCategory);
    }

    public void getCategories(String categoryXML) {
        // TODO add your handling code here:

        kXMLElement myXmlElement = new kXMLElement();

        myXmlElement.parseString(categoryXML);
        Enumeration en = myXmlElement.enumerateChildren();

        // Child tags        
        
        while(en.hasMoreElements()) {
            kXMLElement childElement = (kXMLElement)en.nextElement();

            Enumeration enChild = childElement.enumerateChildren();

            boolean isNewCategory = true;
            while(enChild.hasMoreElements()) {
                // Root Tags
                kXMLElement enChildElement = (kXMLElement)enChild.nextElement();
                // Tag Name
                String aName = enChildElement.getTagName();
                // Tag Value
                String aValue = enChildElement.getContents();

                if(aName.equals("childCategories")) {
                    // Has child categories
                    Enumeration enChildChild = enChildElement.enumerateChildren();

                    while(enChildChild.hasMoreElements()) {
                        // Process child categories
                        kXMLElement enChildChildElement = (kXMLElement)enChildChild.nextElement();
                        // Tag Name
                        Enumeration enChildChildChild = enChildChildElement.enumerateChildren();

                        boolean isNewChildCategory = true;
                        while(enChildChildChild.hasMoreElements()) {

                            kXMLElement enChildChildChildElement = (kXMLElement)enChildChildChild.nextElement();
                            aName = enChildChildChildElement.getTagName();
                            // Tag Value
                            aValue = enChildChildChildElement.getContents();

                            processEntry(aName, aValue, isNewChildCategory, true);
                            isNewChildCategory = false;
                        }
                    }
                } else {
                    processEntry(aName, aValue, isNewCategory, false);
                }

                isNewCategory = false;
            }
        }
    }

    public Category [] getCategories() {
        // Return an array of categories
        int arraySize = categories.size();
        Category [] myCategories = null;

        myCategories = new Category[arraySize];

        for(int arrayLoop = 0; arrayLoop < arraySize; arrayLoop++) {
            myCategories[arrayLoop] = (Category)categories.elementAt(arrayLoop);
        }

        return myCategories;
    }
}
