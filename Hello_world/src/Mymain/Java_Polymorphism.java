package Mymain;
class Animal {
    public void animalSound() {
      System.out.println("The animal makes a sound");
    }
  }
  
  class Pig extends Animal {
    public void animalSound() {
      System.out.println("The pig says: wee wee");
    }
  }
  
  class Dog extends Animal {
    public void animalSound() {
      System.out.println("The dog says: bow wow");
    }
  }
  class chicken extends Animal {
    public void animalSound() {
        System.out.println("The chicken says : kuk kuk");
    }
  }
  
   public class Java_Polymorphism {
    public static void main(String[] args) {
      Animal myAnimal = new Animal();  // Create a Animal object
      Animal myPig = new Pig();  // Create a Pig object
      Animal myDog = new Dog();
      Animal myChickeAnimal = new chicken();  // Create a Dog object
      myAnimal.animalSound();
      myPig.animalSound();
      myDog.animalSound();
      myChickeAnimal.animalSound();
    }
  }