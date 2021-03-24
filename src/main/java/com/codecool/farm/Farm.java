package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Cattle;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {
    List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }
    public List<Animal>getAnimals(){
        return animals;
    }
    public void feedAnimals(){
        for (Animal ani : animals) {
            ani.feed();
        }
    }

    public void butcher(Butcher butcher) {
        List<Animal> animalsSurvive=new ArrayList<Animal>();
        for (Animal ani : animals) {

            if (!butcher.canButcher(ani)) {
                animalsSurvive.add(ani);
            }
        }
        animals=animalsSurvive;
    }

    public boolean isEmpty() {
        if (animals.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    List<String> getStatus() {

        ArrayList<String> listOfAnimalString = new ArrayList<String>();

        for (Animal ani : animals) {
            String oneLineString;
            String sizeString = String.valueOf(ani.getSize());
            String nameString = "";

            if (ani instanceof Pig) {
                nameString = "pig";
            }
            if (ani instanceof Cattle) {
                nameString = "cattle";
            }
            oneLineString = "There is a " + sizeString + " sized " + nameString + " in the farm.";
            listOfAnimalString.add(oneLineString);
        }
        return listOfAnimalString;
    }
}
