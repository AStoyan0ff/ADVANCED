package _12DefiningClassesEX.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String birthday;

    private List<Person> parentsList = new ArrayList<>();
    private List<Person> childrenList = new ArrayList<>();

    public Person(String name, String birthday) {

        this.name = name;
        this.birthday = birthday;
    }

    public void setName(String name) {

        if (this.name == null) {
            this.name = name;
        }
    }

    public void setBirthday(String birthday) {

        if (this.birthday == null) {
            this.birthday = birthday;
        }
    }

    public String getName() {
        return name;
    }
    public List<Person> getParentsList() {
        return parentsList;
    }
    public List<Person> getChildrenList() {
        return childrenList;
    }

    public void addParent(Person parent) {

        if (!parentsList.contains(parent)) {
            parentsList.add(parent);
        }
    }

    public void addChild(Person child) {

        if (!childrenList.contains(child)) {
            childrenList.add(child);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, birthday);
    }
}





