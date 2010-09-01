/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ujuzi.util;

import com.ujuzi.api.ApiException;
import com.ujuzi.api.ApiMethods;
import com.ujuzi.data.Category;
import com.ujuzi.settings.ApplicationSettings;
import com.ujuzi.xml.XMLCategories;
import java.util.Enumeration;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;
import nanoxmlj2me.kXMLElement;

/**
 *
 * @author Ahmed Maawy
 */
public class BootStrap {
    public static Category [] categoryList;

    private RecordStore categoryRecordStore;
    private RecordStore settingsRecordStore;

    public static boolean dataReadSuccess = false;
    public static boolean settingsReadSuccess = false;

    private static final String SETTINGS_RS_NAME = "Settings";
    private static final String DATA_RS_NAME = "Categories";

    public void initBootStrap() {
        // Open recordstores
        boolean settingsOpen = openSettingsRecordStore();
        boolean dataOpen = openDataRecordStore();
        
        if(settingsOpen) {
            if(!settingsOpen) {
                // Datastore not open
            } else {
                settingsReadSuccess = loadSettings();
            }
            // Loading of settings was successful
        } else {
            // We need to initiate the settings recordstore
            updateSettingsRMS(!settingsOpen);
        }

        if(dataOpen) {
            if(!dataOpen) {
                // Datastore not open
            } else {
                dataReadSuccess = loadData();
            }
            // Loading of the data from XML was successful
        } else {
            // We need to update our data
            updateDataRMS(!dataOpen);
        }

        // Close open recordstores
        
        if(settingsOpen) {
            try {
                settingsRecordStore.closeRecordStore();
            } catch (RecordStoreNotOpenException ex) {
                // Record store was not open
            } catch (RecordStoreException ex) {
                // General recordstore exception
            }
        }

        if(dataOpen) {
            try {
                categoryRecordStore.closeRecordStore();
            } catch (RecordStoreNotOpenException ex) {
                // Record store was not open
            } catch (RecordStoreException ex) {
                // General recordstore exception
            }
        }
    }

    private boolean openSettingsRecordStore() {
        try {
            settingsRecordStore = RecordStore.openRecordStore(SETTINGS_RS_NAME, false);
        } catch (RecordStoreFullException ex) {
            return false;
        } catch (RecordStoreNotFoundException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return true;
    }

    private boolean openDataRecordStore() {
        try {
            categoryRecordStore = RecordStore.openRecordStore(DATA_RS_NAME, false);
        } catch (RecordStoreFullException ex) {
            return false;
        } catch (RecordStoreNotFoundException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return true;
    }

    private boolean loadSettings() {
        // Loads settings from XML in RMS
        boolean dataRead = false;

        try {
            // Load data from XML stored in RMS
            RecordEnumeration re = settingsRecordStore.enumerateRecords(null, null, true);
            String settingsXML = "";

            while(re.hasNextElement()) {
                byte[] recordByte = re.nextRecord();
                settingsXML = new String(recordByte);

                dataRead = true;
            }

            if(dataRead) {
                // Process the XML
                kXMLElement myXmlElement = new kXMLElement();

                myXmlElement.parseString(settingsXML);
                Enumeration en = myXmlElement.enumerateChildren();

                while(en.hasMoreElements()) {
                    kXMLElement childElement = (kXMLElement)en.nextElement();

                    String tagName = childElement.getTagName();
                    String tagValue = childElement.getContents();

                    if(tagName.equals("apiURL")) {
                        // API address specified
                        ApplicationSettings.BASE_URL = tagValue;
                    } else if(tagName.equals("basePostal")) {
                        // Postal address specified
                        ApplicationSettings.BASE_POSTAL = tagValue;
                    } else if(tagName.equals("baseOEID")) {
                        // Postal address specified
                        ApplicationSettings.BASE_OEID = tagValue;
                    } else if(tagName.equals("baseLat")) {
                        // Postal address specified
                        ApplicationSettings.BASE_LAT = tagValue;
                    } else if(tagName.equals("baseLon")) {
                        // Postal address specified
                        ApplicationSettings.BASE_LON = tagValue;
                    } else if(tagName.equals("baseRadius")) {
                        // Postal address specified
                        ApplicationSettings.BASE_RADIUS = tagValue;
                    }
                }
            }
        } catch (RecordStoreNotOpenException ex) {
            return false;
        } catch (InvalidRecordIDException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return dataRead;
    }

    private boolean loadData() {
        boolean dataRead = false;

        try {
            // Load data from XML stored in RMS
            RecordEnumeration re = categoryRecordStore.enumerateRecords(null, null, true);
            String categoryXML = "";

            while(re.hasNextElement()) {
                byte[] recordByte = re.nextRecord();
                categoryXML = new String(recordByte);
                
                dataRead = true;
            }

            if(dataRead) {
                XMLCategories xmlCategories = new XMLCategories();
                xmlCategories.getCategories(categoryXML);
                categoryList = xmlCategories.getCategories();
            }
        } catch (RecordStoreNotOpenException ex) {
            return false;
        } catch (InvalidRecordIDException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return dataRead;
    }

    private boolean updateDataRMS(boolean createRecordStore) {
        try {
            // Update RMS with new XML we may get from the web services
            ApiMethods apiMethods = new ApiMethods(ApplicationSettings.BASE_URL, ApplicationSettings.BASE_POSTAL);
            String xmlResponse = apiMethods.getXMLResponse(ApplicationSettings.getApiAllCategories("en"));

            XMLCategories xmlCategories = new XMLCategories();
            xmlCategories.getCategories(xmlResponse);
            
            // Populate the global categories list
            categoryList = xmlCategories.getCategories();

            if(createRecordStore) {
                categoryRecordStore = RecordStore.openRecordStore(DATA_RS_NAME, true);
            }

            categoryRecordStore.addRecord(xmlResponse.getBytes(), 0, xmlResponse.getBytes().length);
        } catch (RecordStoreNotOpenException ex) {
            return false;
        } catch (RecordStoreFullException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        } catch (ApiException ex) {
            return false;
        }
        
        return true;
    }

    private boolean updateSettingsRMS(boolean createRecordStore) {
        try {
            // Update RMS with the settings
            String settingsXML = "<settings>";
            settingsXML += "<apiURL>" + ApplicationSettings.BASE_URL + "</apiURL>";
            settingsXML += "<basePostal>" + ApplicationSettings.BASE_POSTAL + "</basePostal>";
            settingsXML += "<baseOEID>" + ApplicationSettings.BASE_OEID + "</baseOEID>";
            settingsXML += "<baseLat>" + ApplicationSettings.BASE_LAT + "</baseLat>";
            settingsXML += "<baseLon>" + ApplicationSettings.BASE_LON + "</baseLon>";
            settingsXML += "<baseRadius>" + ApplicationSettings.BASE_RADIUS + "</baseRadius>";
            settingsXML += "</settings>";
            
            if (createRecordStore) {
                try {
                    settingsRecordStore = RecordStore.openRecordStore(SETTINGS_RS_NAME, true);
                } catch (RecordStoreNotFoundException ex) {
                    return false;
                } catch (RecordStoreFullException ex) {
                    return false;
                } catch (RecordStoreException ex) {
                    return false;
                }
            }

            settingsRecordStore.addRecord(settingsXML.getBytes(), 0, settingsXML.getBytes().length);

        } catch (RecordStoreNotOpenException ex) {
            return false;
        } catch (RecordStoreFullException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return true;
    }

    public static boolean updateSettingsRMS(String apiURL, String basePostal, String baseOEID, String baseLat, String baseLon, String baseRadius) {
        try {
            // Update RMS with the settings
            String settingsXML = "<settings>";
            settingsXML += "<apiURL>" + apiURL + "</apiURL>";
            settingsXML += "<basePostal>" + basePostal + "</basePostal>";
            settingsXML += "<baseOEID>" + baseOEID + "</baseOEID>";
            settingsXML += "<baseLat>" + baseLat + "</baseLat>";
            settingsXML += "<baseLon>" + baseLon + "</baseLon>";
            settingsXML += "<baseRadius>" + baseRadius + "</baseRadius>";
            settingsXML += "</settings>";

            RecordStore settingsRS;

            RecordStore.deleteRecordStore(SETTINGS_RS_NAME);

            try {
                settingsRS = RecordStore.openRecordStore(SETTINGS_RS_NAME, true);
            } catch (RecordStoreNotFoundException ex) {
                return false;
            } catch (RecordStoreFullException ex) {
                return false;
            } catch (RecordStoreException ex) {
                return false;
            }
            
            settingsRS.addRecord(settingsXML.getBytes(), 0, settingsXML.getBytes().length);
            settingsRS.closeRecordStore();

            ApplicationSettings.BASE_URL = apiURL;
            ApplicationSettings.BASE_POSTAL = basePostal;
            ApplicationSettings.BASE_OEID = baseOEID;
            ApplicationSettings.BASE_LAT = baseLat;
            ApplicationSettings.BASE_LON = baseLon;
            ApplicationSettings.BASE_RADIUS = baseRadius;

        } catch (RecordStoreNotOpenException ex) {
            return false;
        } catch (RecordStoreFullException ex) {
            return false;
        } catch (RecordStoreException ex) {
            return false;
        }

        return true;
    }
}
