package pl.susfenix.course.frontend;

import pl.susfenix.course.frontend.console.ConsoleStarter;
import pl.susfenix.course.frontend.desktop.DesktopStarter;

public class FrontendStarter {
    public static void main(String[] args) {
      //  if (args != null && args.length > 0 && args[0].equalsIgnoreCase("console")) {
            ConsoleStarter.start();
        //} else {
          //  DesktopStarter.start();
        //}
    }
}
