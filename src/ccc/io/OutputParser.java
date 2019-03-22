package ccc.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputParser {
  private int lvl;
  private File outputFolder;

  public OutputParser(int lvl) {
    this.lvl = lvl;
    this.outputFolder = new File("res/output/" + this.lvl);
    if(!outputFolder.exists()){
      outputFolder.mkdir();
    }

  }

  public void write(List<String> lines, String filename) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(String.format("%s/%s", outputFolder.getAbsoluteFile(), filename))));
    for(String s : lines){
      bw.write(s);
    }
    bw.flush();
    bw.close();
  }
}
