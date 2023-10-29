// Paul Hansen
// 8/9/2022
// CS 141
// Lab 5: Bar Chart Racer
//
// this program will present an animated bar graph based on data provided via files

import java.io.*; // for File objects
import java.util.*; // for Scanner

public class BarChartRacer {
   public static void main(String[] args) 
         throws FileNotFoundException {
      
      Scanner input = new Scanner(new File("cities.txt"));
      StdDraw.setCanvasSize(1000, 700);
      StdDraw.enableDoubleBuffering();
      
      String title = input.nextLine();
      String xAxis = input.nextLine();
      String source = input.nextLine();
      input.nextLine();
      String caption = null; 
      BarChart chart = new BarChart(title, xAxis, source);
      while (input.hasNext()) {
         if (input.hasNextInt())  {
            int n = input.nextInt();
            input.nextLine(); 
            fillChart(input, chart, n);
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
         } else { 
            input.nextLine();   
         }
      }                
}

   // takes an scanner input, chart to set caption, and int for number of bars. returns an array of bar objects
   public static void fillChart(Scanner input, BarChart chart, int n) {
      Bar[] bars = new Bar[n];      
      for (int i = 0; i < n; i++) {
         String s = input.nextLine();
         String[] data = s.split(",");
         // split makes (year, name, country, value, category) 
         chart.setCaption(data[0]);
         bars[i] = new Bar(data[1], Integer.parseInt(data[3]), data[4]);
         }
      Arrays.sort(bars);
      for (int i = 0; i < 10; i++) {
         String name = bars[i].getName();
         int value = bars[i].getValue();
         String category = bars[i].getCategory(); 
         chart.add(name, value, category);
      }
   }
} 
/* as is my norm, I tried to make this more complicated than it was. I made more methods for all manner of editing of values, but after them failing
   I check the calls within BarChart.java and looked at how I used them in my code. checking the Point object example, I was able to put two and two together
   and used the constructor method to write those bars in one line, insteasd of the six I had before that wern't working. */      