package cinemasys.presentationa;


import cinemasys.application.domain.CinemaObserver;
import cinemasys.application.domain.CinemaSystem;
import cinemasys.application.domain.Screen;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffUI implements CinemaObserver {

  final static int         LEFT_MARGIN   = 50;
  final static int         TOP_MARGIN    = 50;
  final static int         BOTTOM_MARGIN = 50;
  final static int         ROW_HEIGHT    = 30;
  final static int         COL_WIDTH     = 60;
  final static int         PPM           = 2;                     // Pixels per minute
  final static int         PPH           = 60 * PPM;              // Pixels per hours
  final static int         TZERO         = 18;                    // Earliest time shown
  final static int         SLOTS         = 12;                    // Number of booking slots shown

  private CinemaSystem cs;
  private LocalDate displayedDate;
  private List<Screen> screens  = new ArrayList<Screen>();
  private int  firstX, firstY, currentX, currentY;
  private boolean mouseDown;

  @FXML
  private DatePicker datePicker;
  @FXML private Canvas canvas;
  @FXML private VBox box;

  /**
   * This methods is called after the constructor and after any FXML instance variable have been injected
   */
//  public void initialize() {
//    cs = CinemaSystem.getInstance();
//    bs.setDate(LocalDate.now());
//    bs.addObserver(this);
//    tables = BookingSystem.getTables();
//    datePicker.setValue(LocalDate.now());
//    displayedDate = LocalDate.now();
//
//    // code to be executed when mouse is pressed
//    canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
//      currentX = firstX = (int) e.getX();
//      currentY = firstY = (int) e.getY();
//      if (e.getButton() == MouseButton.PRIMARY) {
//        mouseDown = true;
//        bs.selectBooking(yToTable(firstY), xToTime(firstX));
//      }
//    });
//    // code to be executed when mouse is reeleased
//    canvas.addEventFilter(MouseEvent.MOUSE_RELEASED, (e) -> {
//      mouseDown = false;
//      Booking b = bs.getSelectedBooking();
//      if (b != null && (currentX != firstX || yToTable(currentY) != b.getTable().getNumber())) {
//        bs.changeSelected(xToTime(timeToX(b.getTime()) + currentX - firstX), yToTable(currentY));
//      }
//    });
//    // code to be executed when mouse is dragged
//    canvas.addEventFilter(MouseEvent.MOUSE_DRAGGED, (e) -> {
//      currentX = (int) e.getX();
//      currentY = (int) e.getY();
//      update();
//    });
//    box.layout();
//    update();
//
//  }


  @Override
  public void update() {

  }

  @Override
  public boolean message(String s, boolean confirm) {
    return false;
  }
}
