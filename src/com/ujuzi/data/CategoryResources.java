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
public class CategoryResources {
    private Category category;
    private Vector resources;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Vector getResources() {
        return resources;
    }

    public void setResources(Vector resources) {
        this.resources = resources;
    }
}
