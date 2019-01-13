package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class Controller {
    @FXML
    HTMLEditor textArea;


    @FXML
    TextField textField;
    @FXML
    Button btn;
    private int i=1;

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
    public void sendMsg() {

        String first =textArea.getHtmlText();
        //Фиксируем URL
        String url= getClass().getResource("..").toString();
        //Вырезаем тэги из поля ввода
        String test=textField.getText();
        test=test.replaceAll("<.*>","");
       //Заменяем текст смайликами. (Не лучший вариант)
        if(test.hashCode()==0) test="...";
        for (int zi=1; zi<10; zi++) {
            String mm="Smile"+zi;
           test=test.replaceAll(mm, "<img src=\""+url+"/img/sm"+zi+".png\" width=\"30\"/>");
        }
        //Вставляем фотку
        String first1;
        if (i%2==0){
        first1="<img src=\""+getClass().getResource("../img/ia.png")+"\" width=\"40\" align=\"right\"/>";
        }
        else first1="<img src=\""+getClass().getResource("../img/no.jpg")+"\" width=\"40\" align=\"left\"/>";

        //Вывод текста в поле
        textArea.setHtmlText(first+""+first1+"<div contenteditable=\"false\" style=\""+styleForm(i)+"\">"+test+"</div><div style=\"clear:both\" contenteditable=\"false\">");
        //Увеличиваем счетчик четности
        i++;
        textField.clear();
        textField.requestFocus();

    }
    //Задаем стиль сообщения. Лучше через CSS. Не додумался как передать туда.
    private String styleForm(int zz){
        String sz;
        if (zz%2==0) sz="" +
                "border-radius: 10px; background:#92D1D3; color:000; padding: 5px 10px 5px 10px; margin-bottom:10px; margin-right: 10px; max-width:300px; float:right; text-align: right;";
        else sz="border-radius: 10px; background:#C9D9D9; color:000; padding: 5px 10px 5px 10px; margin-bottom:10px;float:left; max-width:300px;";
        return sz;
    }

}