package ru.job4j.lite.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class Organization.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 07.06.2017
 */
public class Organization {

    /**
     * Sorting in ascending order.
     * @param codes - array of strings.
     * @return - set of strings.
     */
    public Set<String> sortUp(String[] codes) {
        Set<String> list = new TreeSet<>();
        for (String str : codes) {
            if (this.subStr(str, 2) != null) {
                list.add(this.subStr(str, 2));
            }
            list.add(str);
        }
        return list;
    }

    /**
     * Sorting in decreasing order.
     * @param codes - array of strings.
     * @return - set of strings.
     */
    public List<String> sortDown(String[] codes) {
        Set<Department> list = new TreeSet<>((o1, o2) -> o2.name.compareTo(o1.name));
        Department dep1 = new Department(null, new TreeSet<>());
        Department dep2 = new Department(null, new TreeSet<>());
        for (String str : codes) {
            if (dep1.name == null) {
                dep1.name = this.subStr(str, 1);
            }
            if (dep1.name.equals(this.subStr(str, 1))) {
                if (this.subStr(str, 2) != null) {
                    dep1.subdivision.add(this.subStr(str, 2));
                }
                dep1.subdivision.add(str);
            }
            if (dep2.name == null && !dep1.name.equals(this.subStr(str, 1))) {
                dep2.name = this.subStr(str, 1);
            }
            if (dep2.name != null && dep2.name.equals(this.subStr(str, 1))) {
                if (this.subStr(str, 2) != null) {
                    dep2.subdivision.add(this.subStr(str, 2));
                }
                dep2.subdivision.add(str);
            }
        }
        list.add(dep1);
        list.add(dep2);
        List<String> result = new ArrayList<>();
        for (Department dep : list) {
            result.addAll(dep.subdivision);
        }
        return result;
    }

    /**
     * Method truncates a string to the character \.
     * @param str - string.
     * @param num - number.
     * @return - string.
     */
    private String subStr(String str, int num) {
        int pos;
        String result = null;
        if (str != null) {
            if (num == 1) {
                pos = str.indexOf("\\");
                if (pos == -1) {
                    result = str;
                }
            } else {
                pos = str.lastIndexOf("\\");
            }
            if (pos != -1) {
                result = str.substring(0, pos);
            }
        }
        return result;
    }

    /**
     * Class Department.
     */
    static class Department {
        /**
         * Name of department.
         */
        private String name;
        /**
         * List of divisions.
         */
        private Set<String> subdivision;

        /**
         * Constructor.
         * @param name - department name.
         * @param subdivision - list divisions.
         */
        Department(String name, Set<String> subdivision) {
            this.name = name;
            this.subdivision = subdivision;
        }
    }
}
