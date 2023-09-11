public class Info {

private String name;

private int number;

public Info(String name, int number) {

this.name = name;

this.number = number;

}

public String getName() {

return name;

}

public int getNumber() {

return number;

}

public void setName(String newName) {

this.name = newName;

}

public void setNumber(int newNumber) {

this.number = newNumber;

}

//@Override

public String toString() {

return name + " " + number;

}

}
