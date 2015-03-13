package util;

import org.controlsfx.dialog.Dialogs;

/**
 * Created by Error_404 on 04.03.2015.
 */
public class MessageDialogs {

    public static void exceptionDialog(Exception e, String title, String reason){
        Dialogs.create()
                .title(title)
                .masthead(reason)
                .showException(e);
    }
}
