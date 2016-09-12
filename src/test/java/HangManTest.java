import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class HangManTest{

  @Test
  public void HangMan_ObjectedCreated_true() {
    HangMan hang = new HangMan("Hi",5);
    assertEquals(true, hang instanceof HangMan);
  }

  @Test
  public void getAnswer_RetrieveAnswer_Hi() {
    HangMan hang = new HangMan("Hi",5);
    String expectedOutput = "Hi";
    assertEquals(expectedOutput, hang.getAnswer());
  }

  @Test
  public void HangMan_RetrieveAttempts_6() {
    HangMan hang = new HangMan("Hi",6);
    int expectedOutput = 6;
    assertEquals(expectedOutput, hang.getAttemps());
  }

  @Test
  public void getDash_ShowDashes_Dashes() {
    HangMan hang = new HangMan("Hello",5);
    String expectedOutput = "-----";
    assertEquals(expectedOutput, hang.getDashed());
  }

  @Test
  public void getDash_ShowDashesForMultipleWords_Dashes() {
    HangMan hang = new HangMan("Hello There",5);
    String expectedOutput = "----- -----";
    assertEquals(expectedOutput, hang.getDashed());
  }

  @Test
  public void guess_FoundTheLetter_h(){
    HangMan hang = new HangMan("Hello",5);
    String expectedOutput = "H----";
    assertEquals(expectedOutput, hang.guess('H'));
  }

  @Test
  public void guess_FoundMultipleLetters_l(){
    HangMan hang = new HangMan("Hello",5);
    String expectedOutput = "--ll-";
    assertEquals(expectedOutput, hang.guess('l'));
  }

  @Test
  public void guess_FoundMultipleLettersInMultipleWords_l(){
    HangMan hang = new HangMan("liam loves lions",5);
    String expectedOutput = "l--- l---- l----";
    assertEquals(expectedOutput, hang.guess('l'));
  }
  // @Test
  // public void isFound_FoundTheLetter_false(){
  //   HangMan hang = new HangMan("Hi",5);
  //   assertEquals(false, hang.isFound());
  // }
  // @Test
  // public void HangMan_ConvertAnswerToDashes_dashes() {
  //   HangMan hang = new HangMan("Hi",5);
  //   String expectedOutput = "--"
  //   assertEquals(expectedOutput, hang.convertToDash());
  // }

}
