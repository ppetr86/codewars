package com.example.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gratipay {

    static class Project {
        public final String name;
        public final int nreceivingFrom;
        public final int receiving;

        Project(String name, int nreceivingFrom, int receiving) {
            this.name = name;
            this.nreceivingFrom = nreceivingFrom;
            this.receiving = receiving;
        }
    }

    public static Project[] getFeaturedProjects(Project[] allProjects) {
        for (int i = 0; i < allProjects.length; i++) {
            System.out.println("Project project" + i + "= new Project(" + allProjects[i].name + "," + allProjects[i].nreceivingFrom + "," + allProjects[i].receiving + ")");
        }
        if (allProjects.length <= 10)
            return allProjects;

        Map<Boolean, List<Project>> partitioned = Arrays.stream(allProjects).collect(Collectors.partitioningBy(project -> project.nreceivingFrom > 5));

        int popularCount = Math.min(partitioned.get(Boolean.TRUE).size(), 7);
        int unpopularCount = Math.max(3, 10 - popularCount);

        List<Project> popular7 = getRandomElementsFromList(popularCount, partitioned.get(Boolean.TRUE));
        List<Project> randomN = getRandomElementsFromList(unpopularCount, partitioned.get(Boolean.FALSE));
        List<Project> result = Stream.concat(popular7.stream(), randomN.stream()).collect(Collectors.toList());
        Collections.shuffle(result);
        return result.toArray(new Project[0]);
    }

    private static List<Project> getRandomElementsFromList(int size, List<Project> projects) {
        List<Project> result = new ArrayList<>();
        Set<Integer> generatedNumbers = new HashSet<>();
        for (int i = 0; i < Math.min(size, projects.size()); i++) {
            int randomIndex = new Random().nextInt(projects.size());
            while (generatedNumbers.contains(randomIndex))
                randomIndex = new Random().nextInt(projects.size());
            generatedNumbers.add(randomIndex);
            result.add(projects.get(randomIndex));
        }
        return result;
    }

    public static void main(String[] args) {
        /*Project project1 = new Project("Popular Project 0", 7, 10);
        Project project2 = new Project("Popular Project 1", 7, 10);
        Project project3 = new Project("Popular Project 2", 7, 10);
        Project project4 = new Project("Popular Project 3", 7, 10);
        Project project5 = new Project("Unpopular Project 0", 3, 4);
        Project project6 = new Project("Unpopular Project 1", 3, 4);
        Project project7 = new Project("Unpopular Project 2", 3, 4);
        Project project8 = new Project("Unpopular Project 3", 3, 4);
        Project project9 = new Project("Unpopular Project 4", 3, 4);
        Project project10 = new Project("Unpopular Project 5", 3, 4);
        Project project11 = new Project("Unpopular Project 6", 3, 4);
        Project project12 = new Project("Unpopular Project 7", 3, 4);
        Project project13 = new Project("Unpopular Project 8", 3, 4);
        Project project14 = new Project("Unpopular Project 9", 3, 4);*/

        //testMorePopularProjectsThanUnpopularProjects
        Project project1 = new Project("Popular Project 1", 7, 10);
        Project project2 = new Project("Popular Project 2", 7, 10);
        Project project3 = new Project("Popular Project 3", 7, 10);
        Project project4 = new Project("Popular Project 4", 7, 10);
        Project project5 = new Project("Popular Project 5", 7, 10);
        Project project6 = new Project("Popular Project 6", 7, 10);
        Project project7 = new Project("Popular Project 7", 7, 10);
        Project project8 = new Project("Popular Project 8", 7, 10);
        Project project9 = new Project("Popular Project 9", 7, 10);
        Project project10 = new Project("Popular Project 0", 7, 10);
        Project project11 = new Project("Unpopular Project 0", 3, 4);
        Project project12 = new Project("Unpopular Project 1", 3, 4);
        Project project13 = new Project("Unpopular Project 2", 3, 4);
        Project project14 = new Project("Unpopular Project 3", 3, 4);
        Project project15 = new Project("Unpopular Project 4", 3, 4);


        /*Project project1= new Project("Popular Project 1",7,10);
        Project project2= new Project("Popular Project 2",7,10);
        Project project3= new Project("Popular Project 3",7,10);
        Project project4= new Project("Popular Project 4",7,10);
        Project project5= new Project("Popular Project 5",7,10);
        Project project6= new Project("Popular Project 6",7,10);
        Project project7= new Project("Popular Project 7",7,10);
        Project project8= new Project("Popular Project 8",7,10);
        Project project9= new Project("Popular Project 9",7,10);
        Project project10= new Project("Popular Project 0",7,10);
*/
        //https://www.codewars.com/kata/591b9c07266a3164c90001fe/solutions/java
        Project[] projects = new Project[]{project1, project2, project3, project4, project5, project6, project7, project8, project9, project10, project11, project12, project13, project14};
        getFeaturedProjects(projects);


    }
}
