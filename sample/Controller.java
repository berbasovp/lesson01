package sample;

import Server.AuthService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
    @FXML
    WebView textArea;

    @FXML
    TextField textField;
    @FXML
    Button btn;
    private int i=1;
    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;
    //Смайлики
    public void smile1() {
        textField.appendText("Smile1;");
    }
    public void smile2() {
        textField.appendText("Smile2;");
    }
    public void smile3() {
        textField.appendText("Smile3");
    }
    public void smile4() {
        textField.appendText("Smile4");
    }
    public void smile5() {
        textField.appendText("Smile5");
    }
    public void smile6() {
        textField.appendText("Smile6");
    }
    public void smile7() {
        textField.appendText("Smile7");
    }
    public void smile8() {
        textField.appendText("Smile8");
    }
    public void smile9() {
        textField.appendText("Smile9");
    }
    public String textSuda;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    private boolean isAuthorized;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if(!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
        }
    }
    public void connect() {

        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if(str.startsWith("/authok")) {
                                setAuthorized(true);
                                break;
                            } else {
                                mess(str);
                                textSuda=str;
                            }
                        }
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/serverClosed")) break;
                            mess(str);
                            textSuda=str;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setAuthorized(false);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
private void mess(String z){
    Platform.runLater(new Runnable() {
        @Override
        public void run() {
            final WebEngine webEngine = textArea.getEngine();
            webEngine.loadContent(z);
        }
    });
    }

    public void sendMsg() {
        try {
            //Фиксируем URL
            String url = getClass().getResource("..").toString();
            //Вырезаем тэги из поля ввода
            String test = textField.getText();
            test = test.replaceAll("<.*>", "");
            //Заменяем текст смайликами. (Не лучший вариант)
            if (test.hashCode() == 0) test = "...";
            for (int zi = 1; zi < 10; zi++) {
                String mm = "Smile" + zi;
                test = test.replaceAll(mm, "<img src=\"" + url + "/img/sm" + zi + ".png\" width=\"30\"/> ");
            }
            //Вставляем фотку
            String first1;
            if (i % 2 == 0) {
                first1 = "<img src=\"" + getClass().getResource("../img/ia.png") + "\" width=\"40\" align=\"right\" class=\"img\"/>";
            } else
                first1 = "<img src=\"" + getClass().getResource("../img/no.jpg") + "\" width=\"40\" align=\"left\" class=\"img\"/>";

            //добавляем скролинг
            StringBuilder scrollHtml = scrollWebView(0, 1000000, url);
            //Вывод страницы
            textSuda = scrollHtml + "" + textSuda + "" + first1 + "<div contenteditable=\"false\" class=\"" + styleForm(i) + "\">" + test + "</div><div style=\"clear:both\" contenteditable=\"false\">";
            out.writeUTF(textSuda);
            //Увеличиваем счетчик четности
            i++;
            textField.clear();
            textField.requestFocus();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Задаем стиль сообщения. Лучше через CSS. Не додумался как передать туда.
    private String styleForm(int zz){
        String sz;
        if (zz%2==0) sz="MoyText";
        else sz="Comp";
        return sz;
    }

    //Реализация прокрутки через JS
    public static StringBuilder scrollWebView(int xPos, int yPos, String url) {
        StringBuilder script = new StringBuilder().append("<html>");
        script.append("<head>");
        script.append("<link href=\""+url+"/css/pole.css\" rel=\"stylesheet\">");
        script.append("   <script language=\"javascript\" type=\"text/javascript\">");
        script.append("       function toBottom(){");
        script.append("           window.scrollTo(" + xPos + ", " + yPos + ");");
        script.append("       }");
        script.append("   </script>");
        script.append("</head>");
        script.append("<body onload='toBottom()'>");
        return script;
    }
    public void tryToAuth() {
        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}