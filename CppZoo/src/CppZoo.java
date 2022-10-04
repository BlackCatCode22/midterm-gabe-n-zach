import java.io.*;
import java.util.Random;

public class CppZoo {

    public static void main(String[] args) {

        String[] data;
        data = processArrivals();

        String[] names;
        names = processNames();


        String[][] zoo = new String[4][4];

        genZooHabitats(data, zoo);

        for(String[] habitat : zoo) {
            for(String animal : habitat){
                genBirthDay(animal);
                genUAnimalID(animal);
                genAnimalName(animal, names);
            }
        }



    }

    public static String[] processArrivals() {

        BufferedReader buffer;

        String path = "../arrivingAnimals.txt"; //Filepath

        String bufferLine = ""; //Temp variable for the lines
        int lineCount = 0; //Counter for the number of lines

        try {
            buffer = new BufferedReader(new FileReader(path)); //Create a buffered reader

           while((bufferLine = buffer.readLine()) != null) { //Get the number of lines in the file
                lineCount++;
            }

            String[] data = new String[lineCount]; //Create an array to store the data

            buffer = new BufferedReader(new FileReader(path)); //Create a new buffered reader

            int dataLineCount = 0; //Counter to add each line to the dataset

            while((bufferLine = buffer.readLine()) != null){ //Read through file and store each line in dataset
                data[dataLineCount] = bufferLine;
                dataLineCount++;
            }

            buffer.close(); //Close buffer
            return data; //Return the completed dataset

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] processNames() {

        String[] names = new String[4];

        String path = "../animalNames.txt";

        String bufferLine = "";

        int counter = 0;

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(path));

            while((bufferLine = buffer.readLine()) != null) {
                if(bufferLine.contains(",")){
                    names[counter] = bufferLine;
                    counter++;
                }
            }
            return names;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String genBirthDay(String animal) {

        Random random = new Random();

        String birthReport = "";

        int currentYear = 2022;
        String birthMonth = "";
        String birthDay = " " + String.valueOf(random.nextInt(28) + 1);

        String[] spring = {"March", "April", "May"};
        String[] summer = {"June", "July", "August"};
        String[] fall = {"September", "October", "November"};
        String[] winter = {"December", "January", "February"};

        int age = Integer.parseInt(animal.split(" ")[0]);

        int birthYear = currentYear - age;

        String season = animal.split(",")[1].split(" ")[3];

        switch (season) {
            case "spring":
                birthMonth = spring[random.nextInt(3)];
                break;
            case "summer":
                birthMonth = summer[random.nextInt(3)];
                break;
            case "fall":
                birthMonth = fall[random.nextInt(3)];
                break;
            case "winter":
                birthMonth = winter[random.nextInt(3)];
                break;
            default:
                birthMonth = "Unknown Birth";
                birthDay = "";
                break;
        }



        birthReport = age + " years old; birth date " + birthMonth + birthDay + ", " + birthYear;

        System.out.println(birthReport);

        return birthReport;
    }

    public static void genZooHabitats(String[] data, String[][] zoo) {

        int counter = 0;

        for(int i = 0; i < zoo.length; i++){
            for(int j = 0; j < zoo.length; j++){
                zoo[i][j] = data[counter];
                counter++;
            }
        }

    }

    public static String genUAnimalID(String animal) {
        Random random = new Random();
        String id = animal.split(",")[0].split(" ")[4].substring(0,2).toUpperCase() + String.valueOf(random.nextInt(999));
        System.out.println(id);
        return id;
    }

    public static String genAnimalName(String animal, String[] names) {

        return null;
    }
}
