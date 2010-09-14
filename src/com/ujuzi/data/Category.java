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
