package util;

/**
 * Created by Error_404 on 04.03.2015.
 */
public class MessageDialogs {

    public static void exceptionDialog(Exception e, String title, String reason){
        org.controlsfx.dialog.Dialogs.create()
                .title(title)
                .masthead(reason)
                .showException(e);
    }
}
