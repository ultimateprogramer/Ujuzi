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

import com.ujuzi.data.Resource;
import java.util.Enumeration;
import java.util.Vector;
import nanoxmlj2me.kXMLElement;

/**
 *
 * @author Ahmed Maawy
 */
public class XMLResources {

    private Vector resources;

    public XMLResources() {
        resources = new Vector();
    }

    private void processEntry(String elementName, String elementValue, boolean isNew, boolean isChild) {

        Resource myResource;

        if(isNew) {
            // New Resource
            myResource = new Resource();
        } else {
            if(isChild) {
                // Get the child Resource
                myResource = (Resource)resources.elementAt(resources.size() - 1);
            } else {
                // Root Resource
                myResource = (Resource)resources.elementAt(resources.size() - 1);
            }
        }

        // Fill in the variable
        if(elementName.equals("contentId")) {
            myResource.setContentID(elementValue);
        } else if(elementName.equals("title")) {
            myResource.setTitle(elementValue);
        } else if(elementName.equals("description")) {
            myResource.setDescription(elementValue);
        } else if(elementName.equals("areaServed")) {
            myResource.setAreaServed(elementValue);
        } else if(elementName.equals("populationServed")) {
            myResource.setPopulationServed(elementValue);
        } else if(elementName.equals("isDropInCenter")) {
            myResource.setIsDropInCenter(elementValue);
        } else if(elementName.equals("languages")) {
            myResource.setLanguages(elementValue);
        } else if(elementName.equals("cost")) {
            myResource.setCost(elementValue);
        } else if(elementName.equals("hours")) {
            myResource.setHours(elementValue);
        } else if(elementName.equals("address")) {
            myResource.setAddress(elementValue);
        } else if(elementName.equals("city")) {
            myResource.setCity(elementValue);
        } else if(elementName.equals("state")) {
            myResource.setState(elementValue);
        } else if(elementName.equals("zip")) {
            myResource.setZip(elementValue);
        } else if(elementName.equals("phoneLocal")) {
            myResource.setPhoneLocal(elementValue);
        } else if(elementName.equals("phoneTollFree")) {
            myResource.setPhoneTollFree(elementValue);
        } else if(elementName.equals("email")) {
            myResource.setEmail(elementValue);
        } else if(elementName.equals("website")) {
            myResource.setWebsite(elementValue);
        } else if(elementName.equals("foundIn")) {
            myResource.setFoundIn(elementValue);
        } else if(elementName.equals("isNational")) {
            myResource.setIsNational(elementValue);
        } else if(elementName.equals("matchType")) {
            myResource.setMatchType(elementValue);
        } else if(elementName.equals("dist")) {
            myResource.setDist(elementValue);
        } else if(elementName.equals("webcode")) {
            myResource.setWebCode(elementValue);
        } else if(elementName.equals("dcAlliance")) {
            myResource.setDcAlliance(elementValue);
        } else if(elementName.equals("medicaid")) {
            myResource.setMedicaID(elementValue);
        } 

        if(isNew) {
            // Add a new element
            if(isChild) {
                addChildElement(myResource);
            } else {
                addRootElement(myResource);
            }
        }
    }

    private void addChildElement(Resource newResource) {
        int currentElement = resources.size() - 1;
        Resource currentResource = (Resource)resources.elementAt(currentElement);

        // This class does not support this functionality yet
    }

    private void addRootElement(Resource newResource) {
        resources.addElement(newResource);
    }

    public void getResources(String resourceXML) {
        // TODO add your handling code here:

        kXMLElement myXmlElement = new kXMLElement();

        myXmlElement.parseString(resourceXML);
        Enumeration en = myXmlElement.enumerateChildren();

        // Child tags


        while(en.hasMoreElements()) {
            kXMLElement childElement = (kXMLElement)en.nextElement();

            Enumeration enChild = childElement.enumerateChildren();

            boolean isNewResource = true;
            while(enChild.hasMoreElements()) {
                // Root Tags
                kXMLElement enChildElement = (kXMLElement)enChild.nextElement();
                // Tag Name
                String aName = enChildElement.getTagName();
                // Tag Value
                String aValue = enChildElement.getContents();

                if(aName.equals("childResources")) {
                    // Has child categories
                    Enumeration enChildChild = enChildElement.enumerateChildren();

                    boolean isNewChildResource = true;
                    while(enChildChild.hasMoreElements()) {
                        // Process child categories
                        kXMLElement enChildChildElement = (kXMLElement)enChildChild.nextElement();
                        // Tag Name
                        aName = enChildChildElement.getTagName();
                        // Tag Value
                        aValue = enChildChildElement.getContents();

                        processEntry(aName, aValue, isNewChildResource, true);
                        isNewChildResource = false;
                    }
                } else {
                    processEntry(aName, aValue, isNewResource, false);
                }

                isNewResource = false;
            }
        }
    }

    public Resource [] getResources() {
        int arraySize = resources.size();
        Resource [] myResources = null;

        myResources = new Resource[arraySize];

        for(int arrayLoop = 0; arrayLoop < arraySize; arrayLoop++) {
            myResources[arrayLoop] = (Resource)resources.elementAt(arrayLoop);
        }

        return myResources;
    }
}
