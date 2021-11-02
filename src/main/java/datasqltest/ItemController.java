package datasqltest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {

    @FXML
    private Label nameLabel,idLabel;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(profileModel);
    }

    private ProfileModel profileModel;
    private MyListener myListener;

    public void setData(ProfileModel profileModel,MyListener myListener){
        this.profileModel = profileModel;
        this.myListener = myListener;
        nameLabel.setText(profileModel.getName());
        idLabel.setText(HelloApplication.CURRENCY + profileModel.getId());
        Image image = new Image(getClass().getResourceAsStream(profileModel.getImgSrc()));
        img.setImage(image);
    }
}
