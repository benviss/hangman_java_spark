import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

import java.io.Console;
import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    HangMan newGame = new HangMan();
    newGame.readFile("dictionary.txt");
    newGame.computersWord("medium");


    get("/", (request, response) -> {
    String userAlert = "";
    Map<String, Object> model = new HashMap<String, Object>();
    newGame.setGuess(request.queryParams("spark_Guess"));
    System.out.println("Guess string " + newGame.getGuess());
    if (newGame.getGuess() == null) {

    } else {
      char guessChar = newGame.getGuess().charAt(0);
      if(newGame.getPastGuesses().contains(newGame.getGuess())){
        userAlert = "You already guessed that!";
      } else if (newGame.getAttempts()==0){
        userAlert = "You lose\nThe word was: "+newGame.getAnswer();
      } else if (newGame.getAnswer().equals(newGame.getDashed())) {
        userAlert = "You win!";
      } else {
        if(newGame.guess(guessChar)) {
          userAlert = "You guessed correctly";
        } else {
          userAlert = "You guessed wrong!";
        }
    }
    }

    model.put("attempts", newGame.getAttempts());
    model.put("answer", newGame.getDashed());
    model.put("guesses", newGame.getPastGuesses());
    model.put("userAlert",userAlert);
    model.put("template", "templates/form.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    }


    public static String printGraph(Integer _attempts) {
      String graph = "";
      switch(_attempts) {
        case 6:
          graph = printZero();
          break;
        case 5:
          graph = printOne();
          break;
        case 4:
          graph = printTwo();
          break;
        case 3:
          graph = printThree();
          break;
        case 2:
          graph = printFour();
          break;
        case 1:
          graph = printFive();
          break;
        case 0:
          graph = printSix();
          break;
      }
      return graph;
    }
    public static String printZero() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                 \\|/  \n" +
      "    ||                  | \n" +
      "    ||                 / \\ \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printOne() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                 \\|/  \n" +
      "    ||                  | \n" +
      "    ||                 /  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printTwo() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                 \\|/  \n" +
      "    ||                  | \n" +
      "    ||                  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printThree() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                 \\| \n" +
      "    ||                  | \n" +
      "    ||                  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printFour() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                  |  \n" +
      "    ||                  | \n" +
      "    ||                  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printFive() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                  | \n" +
      "    ||                  O  \n" +
      "    ||                   \n" +
      "    ||                   \n" +
      "    ||                  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }
    public static String printSix() {
      return (
      "     ____________________\n" +
      "    ||__________________ |\n" +
      "    ||                 | |\n" +
      "    ||                 |_|\n" +
      "    ||                   \n" +
      "    ||                    \n" +
      "    ||                   \n" +
      "    ||                   \n" +
      "    ||                  \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "    ||                    \n" +
      "  // \\\\                    \n" +
      "_//___\\\\____________________\n"
      );
    }





  }
