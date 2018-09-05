package visualizer;

import java.util.Optional;

public class XMLGen {
  private static String itemTemplate =
      "    <mxCell id=\"%s\" value=\"%s\" style=\"text;strokeColor=none;fillColor=none;align=left;verticalAlign=top;spacingLeft=4;spacingRight=4;overflow=hidden;rotatable=0;points=[[0,0.5],[1,0.5]];portConstraint=eastwest;\" vertex=\"1\" parent=\"2\">\n" +
      "      <mxGeometry %s as=\"geometry\"/>\n" +
      "    </mxCell>";
  public static String getItem(int id, String text, Optional<Integer> x, Optional<Integer> y){
    String posString = x.isPresent()? String.format("x=\"%s\"", x.get()):"";
    posString = posString + " "  + (y.isPresent()? String.format("y=\"%s\"", y.get()):"");
    String t = String.format(itemTemplate, id, text, posString);
    return t;
  }
}
