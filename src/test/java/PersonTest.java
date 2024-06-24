import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void canAddParents() {
        //arange
        Person child = new Person("Esmee","Janssen",32, "female");
        Person mother = new Person("Hanneke","Tos",60, "Female");
        Person father = new Person("Frans","Janssen",59,"male");
        //act
        child.addParents(mother, father);
        //assert
        assertEquals(child.getMother(),mother);
        assertEquals(child.getFather(), father);
    }

    @Test
    public void canAddchild() {
        //arange
        Person children = new Person("Arnold", "Herman", 2, "male");
        Person person = new Person("Esmee", "Janssen",32,"female");
        person.setChildren(new ArrayList<>());
        //act
        person.addChild(children);
        //assert
        assertTrue(person.getChildren().contains(children));
    }

    @Test
    public void canAddPet() {
        //arange
        Person person = new Person("Esmee","Janssen",32,"female");
        Pet pet = new Pet("Snuffie",5,"rabbit");
        person.setPets(new ArrayList<>());
        //act
        person.addPet(pet);
        //assert
        assertEquals("Snuffie", person.getPets().get(0).getName());
    }

    @Test
    public void canAddSibling() {
        //arange
        Person person = new Person("Esmee","Janssen",32,"female");
        Person sibling = new Person("Ron","Janssen",40,"male");
        person.setSiblings(new ArrayList<>());
        //act
        person.addSibling(sibling);
        //assert
        assertTrue(person.getSiblings().contains(sibling));
    }

    @Test
    public void canGetGrandchildren(){
        //arange
        Person grandParent = new Person("Hanneke","Tos",60,"female");
        Person parent = new Person("Esmee", "Janssen", 32, "female");
        Person child = new Person("Arnold","Herman",2,"male");

        grandParent.setChildren(new ArrayList<>());
        grandParent.getChildren().add(parent);

        parent.setChildren(new ArrayList<>());
        parent.getChildren().add(child);

        // Act
        List<Person> grandchildren = grandParent.getGrandChildren();

        // Assert
        assertTrue(grandchildren.contains(child));

    }


}