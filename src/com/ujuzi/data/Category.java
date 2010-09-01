/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ujuzi.data;

import java.util.Vector;

/**
 *
 * @author Ahmed Maawy
 */
public class Category {
    private String categoryID;
    private String categoryName;
    private String url;
    private String resourceCount;
    private String title;

    private String depth;
    private String parentID;

    private Vector childCategories;

    public Category() {
        childCategories = new Vector();
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(String resourceCount) {
        this.resourceCount = resourceCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public Vector getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Vector childCategories) {
        this.childCategories = childCategories;
    }
}
