/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import com.ujuzi.api.ApiException;
import com.ujuzi.api.ApiMethods;
import com.ujuzi.data.Category;
import com.ujuzi.data.Resource;
import com.ujuzi.settings.ApplicationSettings;
import com.ujuzi.util.BootStrap;
import com.ujuzi.xml.XMLResources;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author Ahmed Maawy
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    private int selectedCategory;
    private int selectedSubCategory;
    private Resource [] searchResultResources;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command screenCommand;
    private Command advancedSearchCommand;
    private Command searchCommand;
    private Command searchExitCommand;
    private Command categoryBackCommand;
    private Command selectCategoryCommand;
    private Command getCategoryCommand;
    private Command selectSubCategoryCommand;
    private Command subCategoryBackCommand;
    private Command getSubCategoryCommand;
    private Command advancedSearchExitCommand;
    private Command searchBackCommand;
    private Command settingsCommand;
    private Command saveSettingsCommand;
    private Command settingsBackCommand;
    private Command resultsListOkCommand;
    private Command resultsListBackCommand;
    private Command selectSearchSubCategoryCommand;
    private Command detailsBackCommand;
    private SplashScreen splashScreen;
    private List categoryList;
    private List subCategoryList;
    private Form searchForm;
    private TextField textField1;
    private TextField textField;
    private TextField textField17;
    private List resultList;
    private Form settingsForm;
    private TextField textField6;
    private TextField textField7;
    private TextField textField4;
    private TextField textField5;
    private TextField textField8;
    private Form detailsForm;
    private TextField textField14;
    private TextField textField13;
    private TextField textField12;
    private TextField textField11;
    private TextField textField10;
    private TextField textField9;
    private TextField textField16;
    private TextField textField15;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
        selectedCategory = -1;
        selectedSubCategory = -1;

        searchResultResources = null;
    }

    private boolean doSearch(String searchText) {
        String categoryID;
        String apiResponse;

        if(selectedCategory > -1) {
            // Selection done on root
            categoryID = BootStrap.categoryList[selectedCategory].getCategoryID();

            if(selectedSubCategory > -1) {
                // Sub category selection done
                Category catSelectedSubCategory = (Category)BootStrap.categoryList[selectedCategory].getChildCategories().elementAt(selectedSubCategory);
                categoryID = catSelectedSubCategory.getCategoryID();
            }

            ApiMethods apiMethods = new ApiMethods(ApplicationSettings.BASE_URL, ApplicationSettings.BASE_POSTAL);

            try {
                apiResponse = apiMethods.getXMLResponse(ApplicationSettings.getApiContentByCateoryLatLon("en", categoryID, searchText, ApplicationSettings.BASE_LON, ApplicationSettings.BASE_LAT, ApplicationSettings.BASE_RADIUS));
            } catch (ApiException ex) {
                searchResultResources = null;
                return false;
            }

            XMLResources xmlResources = new XMLResources();
            xmlResources.getResources(apiResponse);

            searchResultResources = new Resource[xmlResources.getResources().length];
            searchResultResources = xmlResources.getResources();
        }

        switchDisplayable(null, getResultList());

        if(resultsListOkCommand != null) {
            getResultList().removeCommand(getResultsListOkCommand());
            resultsListOkCommand = null;
        }

        if(searchResultResources.length > 0) {
            getResultList().addCommand(getResultsListOkCommand());
        }
        
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == categoryList) {//GEN-BEGIN:|7-commandAction|1|30-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|30-preAction
                // write pre-action user code here
                categoryListAction();//GEN-LINE:|7-commandAction|2|30-postAction
                // write post-action user code here
            } else if (command == categoryBackCommand) {//GEN-LINE:|7-commandAction|3|60-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|4|60-postAction
                // write post-action user code here
            } else if (command == getCategoryCommand) {//GEN-LINE:|7-commandAction|5|62-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|6|62-postAction
                // write post-action user code here
                if(getCategoryList().size() > 0) {
                    selectedCategory = getCategoryList().getSelectedIndex();
                    selectedSubCategory = -1;
                    textField17.setString("");

                    String selectedCategoryName = BootStrap.categoryList[selectedCategory].getCategoryName();

                    getTextField().setString(selectedCategoryName);
                }
            }//GEN-BEGIN:|7-commandAction|7|123-preAction
        } else if (displayable == detailsForm) {
            if (command == detailsBackCommand) {//GEN-END:|7-commandAction|7|123-preAction
                // write pre-action user code here
                switchDisplayable(null, getResultList());//GEN-LINE:|7-commandAction|8|123-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|77-preAction
        } else if (displayable == resultList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|9|77-preAction
                // write pre-action user code here
                resultListAction();//GEN-LINE:|7-commandAction|10|77-postAction
                // write post-action user code here
            } else if (command == resultsListBackCommand) {//GEN-LINE:|7-commandAction|11|107-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|12|107-postAction
                // write post-action user code here
            } else if (command == resultsListOkCommand) {//GEN-LINE:|7-commandAction|13|109-preAction
                // write pre-action user code here
                if(getResultList().size() > 0) {
                    switchDisplayable(null, getDetailsForm());//GEN-LINE:|7-commandAction|14|109-postAction
                    // write post-action user code here

                    // Fill in the fields

                    int selectedListIndex = getResultList().getSelectedIndex();
                    Resource selectedResource = searchResultResources[selectedListIndex];

                    textField9.setString(selectedResource.getTitle());
                    textField10.setString(selectedResource.getPhoneLocal());
                    textField11.setString(selectedResource.getPhoneTollFree());
                    textField12.setString(selectedResource.getAddress());
                    textField13.setString(selectedResource.getCity());
                    textField14.setString(selectedResource.getState());
                    textField15.setString(selectedResource.getEmail());
                    textField16.setString(selectedResource.getWebsite());
                }
            }//GEN-BEGIN:|7-commandAction|15|49-preAction
        } else if (displayable == searchForm) {
            if (command == searchCommand) {//GEN-END:|7-commandAction|15|49-preAction
                // write pre-action user code here
                if(selectedCategory > - 1 || selectedSubCategory > -1) {
//GEN-LINE:|7-commandAction|16|49-postAction
                    // write post-action user code here

                    getResultList().deleteAll();

                    Thread mySearchThread = new Thread(new Runnable() {

                        public void run() {
                            if(doSearch(textField1.getString())) {
                                int numResults = searchResultResources.length;

                                for(int resultsLoop = 0; resultsLoop < numResults; resultsLoop++) {
                                    getResultList().append(searchResultResources[resultsLoop].getTitle(), null);
                                }
                            }
                        }

                    });

                    mySearchThread.start();
                }
            } else if (command == searchExitCommand) {//GEN-LINE:|7-commandAction|17|53-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|18|53-postAction
                // write post-action user code here
            } else if (command == selectCategoryCommand) {//GEN-LINE:|7-commandAction|19|57-preAction
                // write pre-action user code here
                switchDisplayable(null, getCategoryList());//GEN-LINE:|7-commandAction|20|57-postAction
                // write post-action user code here

                // Clear the list
                getCategoryList().deleteAll();

                int numItems = BootStrap.categoryList.length;

                for(int itemLoop = 0; itemLoop < numItems; itemLoop ++) {
                    String categoryName = BootStrap.categoryList[itemLoop].getCategoryName();

                    getCategoryList().append(categoryName, null);
                }
            } else if (command == selectSearchSubCategoryCommand) {//GEN-LINE:|7-commandAction|21|127-preAction
                // write pre-action user code here
                if(selectedCategory > -1) {
                    switchDisplayable(null, getSubCategoryList());//GEN-LINE:|7-commandAction|22|127-postAction
                    // write post-action user code here
                    getSubCategoryList().deleteAll();

                    int numSubCategories = BootStrap.categoryList[selectedCategory].getChildCategories().size();

                    // Add list items
                    for(int subCategoryLoop = 0; subCategoryLoop < numSubCategories; subCategoryLoop++) {
                        Category currentSubCategory = (Category)BootStrap.categoryList[selectedCategory].getChildCategories().elementAt(subCategoryLoop);

                        getSubCategoryList().append(currentSubCategory.getCategoryName(), null);
                    }
                }
            } else if (command == settingsCommand) {//GEN-LINE:|7-commandAction|23|94-preAction
                // write pre-action user code here
                switchDisplayable(null, getSettingsForm());//GEN-LINE:|7-commandAction|24|94-postAction
                // write post-action user code here

                textField4.setString(ApplicationSettings.BASE_URL);
                textField5.setString(ApplicationSettings.BASE_OEID);
                textField6.setString(ApplicationSettings.BASE_LAT);
                textField7.setString(ApplicationSettings.BASE_LON);
                textField8.setString(ApplicationSettings.BASE_RADIUS);
            }//GEN-BEGIN:|7-commandAction|25|89-preAction
        } else if (displayable == settingsForm) {
            if (command == saveSettingsCommand) {//GEN-END:|7-commandAction|25|89-preAction
                // write pre-action user code here

                // Save settings
                String settingsApiURL = textField4.getString();
                String settingsBasePostal = ApplicationSettings.BASE_POSTAL;
                String settingsBaseOEID = textField5.getString();
                String settingsBaseLat = textField6.getString();
                String settingsBaseLon = textField7.getString();
                String settingsBaseRadius = textField8.getString();

                BootStrap.updateSettingsRMS(settingsApiURL, settingsBasePostal, settingsBaseOEID, settingsBaseLat, settingsBaseLon, settingsBaseRadius);
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|26|89-postAction
                // write post-action user code here
            } else if (command == settingsBackCommand) {//GEN-LINE:|7-commandAction|27|91-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|28|91-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|29|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|30|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|33-preAction
        } else if (displayable == subCategoryList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|31|33-preAction
                // write pre-action user code here
                subCategoryListAction();//GEN-LINE:|7-commandAction|32|33-postAction
                // write post-action user code here
            } else if (command == getSubCategoryCommand) {//GEN-LINE:|7-commandAction|33|68-preAction
                // write pre-action user code here
                switchDisplayable(null, getSearchForm());//GEN-LINE:|7-commandAction|34|68-postAction
                // write post-action user code here

                if(getSubCategoryList().size() > 0) {
                    selectedSubCategory = getSubCategoryList().getSelectedIndex();

                    Category currentSelectedCategory = (Category)BootStrap.categoryList[selectedCategory].getChildCategories().elementAt(selectedSubCategory);
                    textField17.setString(currentSelectedCategory.getCategoryName());
                }
            } else if (command == subCategoryBackCommand) {//GEN-LINE:|7-commandAction|35|66-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|36|66-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|37|7-postCommandAction
        }//GEN-END:|7-commandAction|37|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|38|
    //</editor-fold>//GEN-END:|7-commandAction|38|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: screenCommand ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of screenCommand component.
     * @return the initialized component instance
     */
    public Command getScreenCommand() {
        if (screenCommand == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            screenCommand = new Command("Screen", Command.SCREEN, 0);//GEN-LINE:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return screenCommand;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchCommand ">//GEN-BEGIN:|48-getter|0|48-preInit
    /**
     * Returns an initiliazed instance of searchCommand component.
     * @return the initialized component instance
     */
    public Command getSearchCommand() {
        if (searchCommand == null) {//GEN-END:|48-getter|0|48-preInit
            // write pre-init user code here
            searchCommand = new Command("Search", Command.OK, 0);//GEN-LINE:|48-getter|1|48-postInit
            // write post-init user code here
        }//GEN-BEGIN:|48-getter|2|
        return searchCommand;
    }
    //</editor-fold>//GEN-END:|48-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            splashScreen.setTitle("Welcome to Ujuzi");
            splashScreen.setCommandListener(this);
            splashScreen.setText("Ujuzi v1.0");//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here

            BootStrap bootStrap = new BootStrap();
            bootStrap.initBootStrap();
        }//GEN-BEGIN:|22-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|22-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: categoryList ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of categoryList component.
     * @return the initialized component instance
     */
    public List getCategoryList() {
        if (categoryList == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            categoryList = new List("Category List", Choice.IMPLICIT);//GEN-BEGIN:|28-getter|1|28-postInit
            categoryList.addCommand(getCategoryBackCommand());
            categoryList.addCommand(getGetCategoryCommand());
            categoryList.setCommandListener(this);//GEN-END:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return categoryList;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: categoryListAction ">//GEN-BEGIN:|28-action|0|28-preAction
    /**
     * Performs an action assigned to the selected list element in the categoryList component.
     */
    public void categoryListAction() {//GEN-END:|28-action|0|28-preAction
        // enter pre-action user code here
        String __selectedString = getCategoryList().getString(getCategoryList().getSelectedIndex());//GEN-LINE:|28-action|1|28-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|28-action|2|
    //</editor-fold>//GEN-END:|28-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: subCategoryList ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of subCategoryList component.
     * @return the initialized component instance
     */
    public List getSubCategoryList() {
        if (subCategoryList == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            subCategoryList = new List("Sub Category List", Choice.IMPLICIT);//GEN-BEGIN:|32-getter|1|32-postInit
            subCategoryList.addCommand(getSubCategoryBackCommand());
            subCategoryList.addCommand(getGetSubCategoryCommand());
            subCategoryList.setCommandListener(this);//GEN-END:|32-getter|1|32-postInit
            // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return subCategoryList;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: subCategoryListAction ">//GEN-BEGIN:|32-action|0|32-preAction
    /**
     * Performs an action assigned to the selected list element in the subCategoryList component.
     */
    public void subCategoryListAction() {//GEN-END:|32-action|0|32-preAction
        // enter pre-action user code here
        String __selectedString = getSubCategoryList().getString(getSubCategoryList().getSelectedIndex());//GEN-LINE:|32-action|1|32-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|32-action|2|
    //</editor-fold>//GEN-END:|32-action|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchForm ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of searchForm component.
     * @return the initialized component instance
     */
    public Form getSearchForm() {
        if (searchForm == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            searchForm = new Form("Ujuzi Search", new Item[] { getTextField(), getTextField17(), getTextField1() });//GEN-BEGIN:|44-getter|1|44-postInit
            searchForm.addCommand(getSelectCategoryCommand());
            searchForm.addCommand(getSearchCommand());
            searchForm.addCommand(getSearchExitCommand());
            searchForm.addCommand(getSettingsCommand());
            searchForm.addCommand(getSelectSearchSubCategoryCommand());
            searchForm.setCommandListener(this);//GEN-END:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return searchForm;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            textField = new TextField("Category", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|45-getter|1|45-postInit
            // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of textField1 component.
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            textField1 = new TextField("Search text", null, 100, TextField.ANY);//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return textField1;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: advancedSearchCommand ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of advancedSearchCommand component.
     * @return the initialized component instance
     */
    public Command getAdvancedSearchCommand() {
        if (advancedSearchCommand == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            advancedSearchCommand = new Command("Advanced Search", Command.ITEM, 0);//GEN-LINE:|50-getter|1|50-postInit
            // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return advancedSearchCommand;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchExitCommand ">//GEN-BEGIN:|52-getter|0|52-preInit
    /**
     * Returns an initiliazed instance of searchExitCommand component.
     * @return the initialized component instance
     */
    public Command getSearchExitCommand() {
        if (searchExitCommand == null) {//GEN-END:|52-getter|0|52-preInit
            // write pre-init user code here
            searchExitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|52-getter|1|52-postInit
            // write post-init user code here
        }//GEN-BEGIN:|52-getter|2|
        return searchExitCommand;
    }
    //</editor-fold>//GEN-END:|52-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: selectCategoryCommand ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of selectCategoryCommand component.
     * @return the initialized component instance
     */
    public Command getSelectCategoryCommand() {
        if (selectCategoryCommand == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            selectCategoryCommand = new Command("Select category", Command.ITEM, 0);//GEN-LINE:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return selectCategoryCommand;
    }
    //</editor-fold>//GEN-END:|56-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: categoryBackCommand ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of categoryBackCommand component.
     * @return the initialized component instance
     */
    public Command getCategoryBackCommand() {
        if (categoryBackCommand == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            categoryBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return categoryBackCommand;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: getCategoryCommand ">//GEN-BEGIN:|61-getter|0|61-preInit
    /**
     * Returns an initiliazed instance of getCategoryCommand component.
     * @return the initialized component instance
     */
    public Command getGetCategoryCommand() {
        if (getCategoryCommand == null) {//GEN-END:|61-getter|0|61-preInit
            // write pre-init user code here
            getCategoryCommand = new Command("Select", Command.ITEM, 0);//GEN-LINE:|61-getter|1|61-postInit
            // write post-init user code here
        }//GEN-BEGIN:|61-getter|2|
        return getCategoryCommand;
    }
    //</editor-fold>//GEN-END:|61-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: subCategoryBackCommand ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initiliazed instance of subCategoryBackCommand component.
     * @return the initialized component instance
     */
    public Command getSubCategoryBackCommand() {
        if (subCategoryBackCommand == null) {//GEN-END:|65-getter|0|65-preInit
            // write pre-init user code here
            subCategoryBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|65-getter|1|65-postInit
            // write post-init user code here
        }//GEN-BEGIN:|65-getter|2|
        return subCategoryBackCommand;
    }
    //</editor-fold>//GEN-END:|65-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: getSubCategoryCommand ">//GEN-BEGIN:|67-getter|0|67-preInit
    /**
     * Returns an initiliazed instance of getSubCategoryCommand component.
     * @return the initialized component instance
     */
    public Command getGetSubCategoryCommand() {
        if (getSubCategoryCommand == null) {//GEN-END:|67-getter|0|67-preInit
            // write pre-init user code here
            getSubCategoryCommand = new Command("Select", Command.ITEM, 0);//GEN-LINE:|67-getter|1|67-postInit
            // write post-init user code here
        }//GEN-BEGIN:|67-getter|2|
        return getSubCategoryCommand;
    }
    //</editor-fold>//GEN-END:|67-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: selectSubCategoryCommand ">//GEN-BEGIN:|71-getter|0|71-preInit
    /**
     * Returns an initiliazed instance of selectSubCategoryCommand component.
     * @return the initialized component instance
     */
    public Command getSelectSubCategoryCommand() {
        if (selectSubCategoryCommand == null) {//GEN-END:|71-getter|0|71-preInit
            // write pre-init user code here
            selectSubCategoryCommand = new Command("Select Sub Category", Command.ITEM, 0);//GEN-LINE:|71-getter|1|71-postInit
            // write post-init user code here
        }//GEN-BEGIN:|71-getter|2|
        return selectSubCategoryCommand;
    }
    //</editor-fold>//GEN-END:|71-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchBackCommand ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initiliazed instance of searchBackCommand component.
     * @return the initialized component instance
     */
    public Command getSearchBackCommand() {
        if (searchBackCommand == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            searchBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|82-getter|1|82-postInit
            // write post-init user code here
        }//GEN-BEGIN:|82-getter|2|
        return searchBackCommand;
    }
    //</editor-fold>//GEN-END:|82-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: advancedSearchExitCommand ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initiliazed instance of advancedSearchExitCommand component.
     * @return the initialized component instance
     */
    public Command getAdvancedSearchExitCommand() {
        if (advancedSearchExitCommand == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            advancedSearchExitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|85-getter|1|85-postInit
            // write post-init user code here
        }//GEN-BEGIN:|85-getter|2|
        return advancedSearchExitCommand;
    }
    //</editor-fold>//GEN-END:|85-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: resultList ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of resultList component.
     * @return the initialized component instance
     */
    public List getResultList() {
        if (resultList == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            resultList = new List("Search Results", Choice.IMPLICIT);//GEN-BEGIN:|76-getter|1|76-postInit
            resultList.addCommand(getResultsListBackCommand());
            resultList.addCommand(getResultsListOkCommand());
            resultList.setCommandListener(this);//GEN-END:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return resultList;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resultListAction ">//GEN-BEGIN:|76-action|0|76-preAction
    /**
     * Performs an action assigned to the selected list element in the resultList component.
     */
    public void resultListAction() {//GEN-END:|76-action|0|76-preAction
        // enter pre-action user code here
        String __selectedString = getResultList().getString(getResultList().getSelectedIndex());//GEN-LINE:|76-action|1|76-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|76-action|2|
    //</editor-fold>//GEN-END:|76-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: saveSettingsCommand ">//GEN-BEGIN:|88-getter|0|88-preInit
    /**
     * Returns an initiliazed instance of saveSettingsCommand component.
     * @return the initialized component instance
     */
    public Command getSaveSettingsCommand() {
        if (saveSettingsCommand == null) {//GEN-END:|88-getter|0|88-preInit
            // write pre-init user code here
            saveSettingsCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|88-getter|1|88-postInit
            // write post-init user code here
        }//GEN-BEGIN:|88-getter|2|
        return saveSettingsCommand;
    }
    //</editor-fold>//GEN-END:|88-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: settingsBackCommand ">//GEN-BEGIN:|90-getter|0|90-preInit
    /**
     * Returns an initiliazed instance of settingsBackCommand component.
     * @return the initialized component instance
     */
    public Command getSettingsBackCommand() {
        if (settingsBackCommand == null) {//GEN-END:|90-getter|0|90-preInit
            // write pre-init user code here
            settingsBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|90-getter|1|90-postInit
            // write post-init user code here
        }//GEN-BEGIN:|90-getter|2|
        return settingsBackCommand;
    }
    //</editor-fold>//GEN-END:|90-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: settingsCommand ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of settingsCommand component.
     * @return the initialized component instance
     */
    public Command getSettingsCommand() {
        if (settingsCommand == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            settingsCommand = new Command("Settings", Command.ITEM, 0);//GEN-LINE:|93-getter|1|93-postInit
            // write post-init user code here
        }//GEN-BEGIN:|93-getter|2|
        return settingsCommand;
    }
    //</editor-fold>//GEN-END:|93-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: settingsForm ">//GEN-BEGIN:|87-getter|0|87-preInit
    /**
     * Returns an initiliazed instance of settingsForm component.
     * @return the initialized component instance
     */
    public Form getSettingsForm() {
        if (settingsForm == null) {//GEN-END:|87-getter|0|87-preInit
            // write pre-init user code here
            settingsForm = new Form("Ujuzi Settings", new Item[] { getTextField4(), getTextField5(), getTextField6(), getTextField7(), getTextField8() });//GEN-BEGIN:|87-getter|1|87-postInit
            settingsForm.addCommand(getSaveSettingsCommand());
            settingsForm.addCommand(getSettingsBackCommand());
            settingsForm.setCommandListener(this);//GEN-END:|87-getter|1|87-postInit
            // write post-init user code here
        }//GEN-BEGIN:|87-getter|2|
        return settingsForm;
    }
    //</editor-fold>//GEN-END:|87-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField4 ">//GEN-BEGIN:|96-getter|0|96-preInit
    /**
     * Returns an initiliazed instance of textField4 component.
     * @return the initialized component instance
     */
    public TextField getTextField4() {
        if (textField4 == null) {//GEN-END:|96-getter|0|96-preInit
            // write pre-init user code here
            textField4 = new TextField("Server URL", null, 100, TextField.ANY);//GEN-LINE:|96-getter|1|96-postInit
            // write post-init user code here
        }//GEN-BEGIN:|96-getter|2|
        return textField4;
    }
    //</editor-fold>//GEN-END:|96-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField5 ">//GEN-BEGIN:|97-getter|0|97-preInit
    /**
     * Returns an initiliazed instance of textField5 component.
     * @return the initialized component instance
     */
    public TextField getTextField5() {
        if (textField5 == null) {//GEN-END:|97-getter|0|97-preInit
            // write pre-init user code here
            textField5 = new TextField("OEID", null, 32, TextField.ANY);//GEN-LINE:|97-getter|1|97-postInit
            // write post-init user code here
        }//GEN-BEGIN:|97-getter|2|
        return textField5;
    }
    //</editor-fold>//GEN-END:|97-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField6 ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of textField6 component.
     * @return the initialized component instance
     */
    public TextField getTextField6() {
        if (textField6 == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            textField6 = new TextField("Latitiude", null, 32, TextField.ANY);//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        }//GEN-BEGIN:|102-getter|2|
        return textField6;
    }
    //</editor-fold>//GEN-END:|102-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField7 ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of textField7 component.
     * @return the initialized component instance
     */
    public TextField getTextField7() {
        if (textField7 == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            textField7 = new TextField("Longitude", null, 32, TextField.ANY);//GEN-LINE:|103-getter|1|103-postInit
            // write post-init user code here
        }//GEN-BEGIN:|103-getter|2|
        return textField7;
    }
    //</editor-fold>//GEN-END:|103-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField8 ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of textField8 component.
     * @return the initialized component instance
     */
    public TextField getTextField8() {
        if (textField8 == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            textField8 = new TextField("Radius (miles)", null, 32, TextField.ANY);//GEN-LINE:|104-getter|1|104-postInit
            // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return textField8;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: resultsListBackCommand ">//GEN-BEGIN:|106-getter|0|106-preInit
    /**
     * Returns an initiliazed instance of resultsListBackCommand component.
     * @return the initialized component instance
     */
    public Command getResultsListBackCommand() {
        if (resultsListBackCommand == null) {//GEN-END:|106-getter|0|106-preInit
            // write pre-init user code here
            resultsListBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|106-getter|1|106-postInit
            // write post-init user code here
        }//GEN-BEGIN:|106-getter|2|
        return resultsListBackCommand;
    }
    //</editor-fold>//GEN-END:|106-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: resultsListOkCommand ">//GEN-BEGIN:|108-getter|0|108-preInit
    /**
     * Returns an initiliazed instance of resultsListOkCommand component.
     * @return the initialized component instance
     */
    public Command getResultsListOkCommand() {
        if (resultsListOkCommand == null) {//GEN-END:|108-getter|0|108-preInit
            // write pre-init user code here
            resultsListOkCommand = new Command("Details", Command.OK, 0);//GEN-LINE:|108-getter|1|108-postInit
            // write post-init user code here
        }//GEN-BEGIN:|108-getter|2|
        return resultsListOkCommand;
    }
    //</editor-fold>//GEN-END:|108-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: detailsForm ">//GEN-BEGIN:|111-getter|0|111-preInit
    /**
     * Returns an initiliazed instance of detailsForm component.
     * @return the initialized component instance
     */
    public Form getDetailsForm() {
        if (detailsForm == null) {//GEN-END:|111-getter|0|111-preInit
            // write pre-init user code here
            detailsForm = new Form("Details", new Item[] { getTextField9(), getTextField10(), getTextField11(), getTextField12(), getTextField13(), getTextField14(), getTextField15(), getTextField16() });//GEN-BEGIN:|111-getter|1|111-postInit
            detailsForm.addCommand(getDetailsBackCommand());
            detailsForm.setCommandListener(this);//GEN-END:|111-getter|1|111-postInit
            // write post-init user code here
        }//GEN-BEGIN:|111-getter|2|
        return detailsForm;
    }
    //</editor-fold>//GEN-END:|111-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField9 ">//GEN-BEGIN:|114-getter|0|114-preInit
    /**
     * Returns an initiliazed instance of textField9 component.
     * @return the initialized component instance
     */
    public TextField getTextField9() {
        if (textField9 == null) {//GEN-END:|114-getter|0|114-preInit
            // write pre-init user code here
            textField9 = new TextField("Name", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|114-getter|1|114-postInit
            // write post-init user code here
        }//GEN-BEGIN:|114-getter|2|
        return textField9;
    }
    //</editor-fold>//GEN-END:|114-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField10 ">//GEN-BEGIN:|115-getter|0|115-preInit
    /**
     * Returns an initiliazed instance of textField10 component.
     * @return the initialized component instance
     */
    public TextField getTextField10() {
        if (textField10 == null) {//GEN-END:|115-getter|0|115-preInit
            // write pre-init user code here
            textField10 = new TextField("Phone (Local)", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|115-getter|1|115-postInit
            // write post-init user code here
        }//GEN-BEGIN:|115-getter|2|
        return textField10;
    }
    //</editor-fold>//GEN-END:|115-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField11 ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of textField11 component.
     * @return the initialized component instance
     */
    public TextField getTextField11() {
        if (textField11 == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            textField11 = new TextField("Phone (Toll free)", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|116-getter|1|116-postInit
            // write post-init user code here
        }//GEN-BEGIN:|116-getter|2|
        return textField11;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField12 ">//GEN-BEGIN:|117-getter|0|117-preInit
    /**
     * Returns an initiliazed instance of textField12 component.
     * @return the initialized component instance
     */
    public TextField getTextField12() {
        if (textField12 == null) {//GEN-END:|117-getter|0|117-preInit
            // write pre-init user code here
            textField12 = new TextField("Address", null, 200, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|117-getter|1|117-postInit
            // write post-init user code here
        }//GEN-BEGIN:|117-getter|2|
        return textField12;
    }
    //</editor-fold>//GEN-END:|117-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField13 ">//GEN-BEGIN:|118-getter|0|118-preInit
    /**
     * Returns an initiliazed instance of textField13 component.
     * @return the initialized component instance
     */
    public TextField getTextField13() {
        if (textField13 == null) {//GEN-END:|118-getter|0|118-preInit
            // write pre-init user code here
            textField13 = new TextField("City", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|118-getter|1|118-postInit
            // write post-init user code here
        }//GEN-BEGIN:|118-getter|2|
        return textField13;
    }
    //</editor-fold>//GEN-END:|118-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField14 ">//GEN-BEGIN:|119-getter|0|119-preInit
    /**
     * Returns an initiliazed instance of textField14 component.
     * @return the initialized component instance
     */
    public TextField getTextField14() {
        if (textField14 == null) {//GEN-END:|119-getter|0|119-preInit
            // write pre-init user code here
            textField14 = new TextField("State", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|119-getter|1|119-postInit
            // write post-init user code here
        }//GEN-BEGIN:|119-getter|2|
        return textField14;
    }
    //</editor-fold>//GEN-END:|119-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField15 ">//GEN-BEGIN:|120-getter|0|120-preInit
    /**
     * Returns an initiliazed instance of textField15 component.
     * @return the initialized component instance
     */
    public TextField getTextField15() {
        if (textField15 == null) {//GEN-END:|120-getter|0|120-preInit
            // write pre-init user code here
            textField15 = new TextField("Email", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|120-getter|1|120-postInit
            // write post-init user code here
        }//GEN-BEGIN:|120-getter|2|
        return textField15;
    }
    //</editor-fold>//GEN-END:|120-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField16 ">//GEN-BEGIN:|121-getter|0|121-preInit
    /**
     * Returns an initiliazed instance of textField16 component.
     * @return the initialized component instance
     */
    public TextField getTextField16() {
        if (textField16 == null) {//GEN-END:|121-getter|0|121-preInit
            // write pre-init user code here
            textField16 = new TextField("Website", null, 100, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|121-getter|1|121-postInit
            // write post-init user code here
        }//GEN-BEGIN:|121-getter|2|
        return textField16;
    }
    //</editor-fold>//GEN-END:|121-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: detailsBackCommand ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of detailsBackCommand component.
     * @return the initialized component instance
     */
    public Command getDetailsBackCommand() {
        if (detailsBackCommand == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            detailsBackCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return detailsBackCommand;
    }
    //</editor-fold>//GEN-END:|122-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField17 ">//GEN-BEGIN:|125-getter|0|125-preInit
    /**
     * Returns an initiliazed instance of textField17 component.
     * @return the initialized component instance
     */
    public TextField getTextField17() {
        if (textField17 == null) {//GEN-END:|125-getter|0|125-preInit
            // write pre-init user code here
            textField17 = new TextField("Sub Category", null, 32, TextField.ANY | TextField.UNEDITABLE);//GEN-LINE:|125-getter|1|125-postInit
            // write post-init user code here
        }//GEN-BEGIN:|125-getter|2|
        return textField17;
    }
    //</editor-fold>//GEN-END:|125-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: selectSearchSubCategoryCommand ">//GEN-BEGIN:|126-getter|0|126-preInit
    /**
     * Returns an initiliazed instance of selectSearchSubCategoryCommand component.
     * @return the initialized component instance
     */
    public Command getSelectSearchSubCategoryCommand() {
        if (selectSearchSubCategoryCommand == null) {//GEN-END:|126-getter|0|126-preInit
            // write pre-init user code here
            selectSearchSubCategoryCommand = new Command("Select Sub Category", Command.ITEM, 0);//GEN-LINE:|126-getter|1|126-postInit
            // write post-init user code here
        }//GEN-BEGIN:|126-getter|2|
        return selectSearchSubCategoryCommand;
    }
    //</editor-fold>//GEN-END:|126-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
