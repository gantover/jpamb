package jpamb.cases;

import jpamb.utils.*;
import static jpamb.utils.Tag.TagType.*;

public class MyCases {

  @Case("() -> *")
  @Tag({ LOOP })
  public static int neverWorks() {
    int i = 1;
    while (i > 0) {
    }
    return 0 / 0;
  }
}
