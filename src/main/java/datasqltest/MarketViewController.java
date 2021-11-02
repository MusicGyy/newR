package datasqltest;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketViewController implements Initializable {

    @FXML
    private VBox chosenProfileCard;

    @FXML
    private Label profileNameLabel,profileIdLabel,priceLabel;

    @FXML
    private ImageView profileImage;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;


    private List<ProfileModel> profiles = new ArrayList<>();
    private Image image;
    private MyListener myListener;


    private List<ProfileModel> getData(){
        List<ProfileModel> profiles = new ArrayList<>();
        ProfileModel profile;



        profile = new ProfileModel(0,"",0,0,"","");
        profile.setName("Gygee");
        profile.setId(1);
        profile.setImgSrc("/image/Gygee.jpg");
        profile.setColor("6A7324");
        profile.setPrice(500.50);
        profile.setQuantity(5000);
        profiles.add(profile);

        profile = new ProfileModel(0,"",0,0,"","");
        profile.setName("Music");
        profile.setId(2);
        profile.setImgSrc("/image/Music.jpg");
        profile.setColor("6A7324");
        profile.setPrice(750.50);
        profile.setQuantity(4000);
        profiles.add(profile);

        profile = new ProfileModel(0,"",0,0,"","");
        profile.setName("Mewnich");
        profile.setId(3);
        profile.setImgSrc("/image/Mewnich.jpg");
        profile.setColor("6A7324");
        profile.setPrice(100.50);
        profile.setQuantity(3000);
        profiles.add(profile);


        return profiles;
    }

    private void setChosenProfile(ProfileModel profileModel){
        profileNameLabel.setText(profileModel.getName());
        profileIdLabel.setText(HelloApplication.CURRENCY + profileModel.getId());
        priceLabel.setText("Price " + String.valueOf(profileModel.getPrice())+" Baht/Piece");
        image = new Image(getClass().getResourceAsStream(profileModel.getImgSrc()));
        profileImage.setImage(image);
        chosenProfileCard.setStyle("-fx-background-color: #"+ profileModel.getColor() + ";\n" +
                "   -fx-background-radius: 30;");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profiles.addAll(getData());
        if (profiles.size() > 0){
            setChosenProfile(profiles.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(ProfileModel profileModel) {
                    setChosenProfile(profileModel);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < profiles.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/datasqltest/item-view.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(profiles.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane,column++, row);
                //set width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane,new Insets(10));

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
