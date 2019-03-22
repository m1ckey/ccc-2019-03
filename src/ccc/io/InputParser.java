package ccc.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class InputParser {
  private int lvl;
  private File inputFolder;
  // private Map<String, File> filemap;

  public InputParser(int lvl) {
    this.lvl = lvl;
    this.inputFolder = new File("res/input/" + this.lvl);
    /*
      - Java reads ALL files in the /res/input/<lvl>/ directory
     */
  }

  public List<String> getExampleLines() throws IOException {
    File egFile = new File(String.format("%s/level%s_0.in", inputFolder.getAbsoluteFile(), lvl));
    List<String> ret = new ArrayList<>();
    Files.lines(egFile.toPath()).forEach(s -> ret.add(s));
    return ret;
  }

  public Map<String, List<String>> getAllLines() throws IOException {
    File[] directoryListing = this.inputFolder.listFiles();
    Map<String, List<String>> lines = new HashMap<>();
    for (File child : directoryListing) {
      if(child.getName().contains("level")){
        List<String> ret = new ArrayList<>();
        Files.lines(child.toPath()).forEach(s -> ret.add(s));
        lines.put(child.getName(), ret);
      }
    }
    return lines;
  }

  public List<File> getAllFiles() {
      return Arrays.asList(this.inputFolder.listFiles());
  }

  public static void main(String[] args) throws IOException {
    InputParser ip = new InputParser(1);
    System.out.println(ip.getAllLines().get("level1_1.in").get(0));
  }
}
