package com.xu.day25__Thread;

public class SimpleFactoryPattern {

    public static void main(String[] args) {

    }

}
abstract class AbstractAnimalFactory {
    public abstract Animal creat();
}
class CatFactory extends AbstractAnimalFactory {
    @Override
    public Animal creat() {
        return new Cat();
    }
}
class Animal {
    public void eat(){}
}
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("eat shit");
    }
}
class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("eat fish");
    }
}
