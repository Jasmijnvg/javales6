import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private String mother;
    private String father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public List<String> getSiblings() {
        return siblings;
    }

    public List<String> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addParents(Person mother, Person father) {
        if (mother != null) {
            this.mother = mother;
            mother.addChild(this);
        }
        if (father != null) {
            this.father = father;
            father.addChild(this);
        }
    }

    public void addChild(Person child) {
        if (child != null && !this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public void addPet(Pet pet) {
        if (pet != null && !this.pets.contains(pet)) {
            this.pets.add(pet);
            pet.setOwner(this);
        }
    }

    public void addSibling(Person siblings){
        if (siblings != null && !this.siblings.contains(siblings)) {
            this.siblings.add(siblings);
        }
    }

    public void getGrandChildren() {
        for (Person child : children) {
            child.getGrandChildren();
        }
    }
}
