import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class HangMan{
  private String mAnswer;
  private int mAttempts;
  private String mDashed;
  private boolean mGameFinished;
  private String mPastGuesses;
  private ArrayList<String> mDictionary;
  private String mGuess;

  public HangMan(){
    mAttempts = 6;
    mGameFinished = false;
    mDictionary = new ArrayList<String>();
    mPastGuesses = "";
  }

  public void newHangMan(String answer){
    mAnswer = answer;
    mAttempts = 6;
    mDashed = mAnswer.replaceAll("[a-zA-Z]","-");
    mGameFinished = false;
    mPastGuesses = "";
  }

  public void computersWord(String difficulty){
    Random rnd = new Random();
    String newAnswer = "";
    int maxLength;
    int minLength;
    boolean running = true;

    if(difficulty.equalsIgnoreCase("easy")){
      minLength=0;
      maxLength = 6;
    }else if(difficulty.equalsIgnoreCase("medium")){
      minLength = 7;
      maxLength = 11;
    }else{
      minLength = 12;
      maxLength = 100;
    }
    while(running){
      int index = rnd.nextInt(mDictionary.size());
      if(mDictionary.get(index).length() >= minLength && mDictionary.get(index).length() <= maxLength){
        newAnswer = mDictionary.get(index);
        running = false;
      }
    }
    mAnswer = newAnswer;
  }


  public boolean guess(char guess){
    boolean found = false;
    mPastGuesses = mPastGuesses.concat(Character.toString(guess));
    char[] answerArray = mAnswer.toCharArray();
    StringBuilder str = new StringBuilder(mDashed);

    for (int i = 0; i < answerArray.length; i++) {
      if (guess == answerArray[i]) {
        found = true;
        str.setCharAt(i,guess);
        mDashed = str.toString();
        System.out.println(mPastGuesses);
        System.out.println(mDashed);
        System.out.println(answerArray[i]);
        return true;
      }
    }
    if(!found){
      mAttempts--;
      mDashed = str.toString();
      System.out.println(mPastGuesses);
      System.out.println(mDashed);
      System.out.println(answerArray);
      return false;
    }
    return false;



  }
  public void readFile(String fileName){
    try{
      FileReader inputFile = new FileReader(fileName);
      BufferedReader bufferRead = new BufferedReader(inputFile);
      String line;
      while((line=bufferRead.readLine())!=null){
        mDictionary.add(line);
      }
      bufferRead.close();
    }catch(Exception e){
      System.out.println("This failed");
    }
  }

  public boolean isFinished(){
    return mGameFinished;
  }

  public String getDashed(){
    return mDashed;
  }


  public String getAnswer(){
    return mAnswer;
  }

  public String getPastGuesses(){
    return mPastGuesses;
  }

  public int getAttempts(){
    return mAttempts;
  }
  public void setGuess(String _guess) {
    mGuess = _guess;
  }
  public String getGuess() {
    return mGuess;
  }

}
