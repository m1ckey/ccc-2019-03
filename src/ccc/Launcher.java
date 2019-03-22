package ccc;

import ccc.io.InputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Launcher {
  public static void main(String[] args) throws IOException {
    Scanner r = new Scanner(System.in);
    System.out.println("---------------------------");
    System.out.println("Coding Contest Framework v1");
    System.out.println("---------------------------");
    System.out.print("lvl: ");
    int lvl = r.nextInt();
    Level level = getLevel(lvl);
    System.out.print("dbg: ");
    boolean dbg = r.nextInt() != 0;
    try {
      run(level, dbg);
    } catch (IOException e) {
      System.err.println("Error while running the level: " + e.getMessage());
      System.exit(-1);
    }
  }

  public static Level getLevel(int lvl) {
    try {
      Object o = Class.forName(String.format("ccc.lvl%d.Level%d", lvl, lvl)).newInstance();
      return (Level) o;
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
      System.err.println("Level not found\n" + e.getMessage());
      System.exit(-1);
    }
    return null;
  }

  public static void run(Level level, boolean dbg) throws IOException {
    InputParser ip = new InputParser(level.lvl);
    if(dbg) {
      List<String> lines = ip.getExampleLines();
      LevelInput lvlInput = level.transformFromLines(lines);
      LevelOutput lvlOutput = level.run(lvlInput);
      List<String> resultLines = level.transformToLines(lvlOutput);
      level.writeConsole(resultLines, "example");
    } else {
      Map<String, List<String>> files = ip.getAllLines();
      for(Map.Entry<String, List<String>> entry: files.entrySet()) {
        String filename = entry.getKey();
        List<String> lines = entry.getValue();
        LevelInput lvlInput = level.transformFromLines(lines);
        LevelOutput lvlOutput = level.run(lvlInput);
        List<String> resultLines = level.transformToLines(lvlOutput);
        level.writeConsole(resultLines, filename);
        level.writeOutputFile(resultLines, filename);
      }
    }
  }
}
