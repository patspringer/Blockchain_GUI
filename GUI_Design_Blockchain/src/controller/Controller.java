package controller;

import chart.CandleChart;
import chart.DecimalAxisFormatter;
import chart.TickData;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kordamp.ikonli.javafx.FontIcon;
import javafx.scene.image.ImageView;
import utils.currentpriceRequest;
import utils.transactionsRequest;

public class Controller implements Initializable {
    @FXML
    private Label portfolioLabel;
    @FXML
    private Label walletLabel;
    @FXML
    private Label exchangeLabel;
    @FXML
    private Label settingsLabel;
    @FXML
    private Label helpLabel;
    @FXML
    private Label valueLabel;

    //Wallet send/receive Views
    @FXML
    private AnchorPane sendReceiveBitcoin;
    @FXML
    private AnchorPane bitcoinsendPane;
    @FXML
    private AnchorPane bitcoinreceivePane;
    @FXML
    private AnchorPane ethereumsendPane;
    @FXML
    private AnchorPane ethereumreceivePane;
    @FXML
    private AnchorPane litecoinsendPane;
    @FXML
    private AnchorPane litecoinreceivePane;
    @FXML
    private AnchorPane monerosendPane;
    @FXML
    private AnchorPane moneroreceivePane;
    @FXML
    private JFXButton bitcoinSend;
    @FXML
    private JFXButton bitcoinReceive;
    @FXML
    private AnchorPane sendReceiveEthereum;
    @FXML
    private AnchorPane sendReceiveLitecoin;
    @FXML
    private AnchorPane sendReceiveMonero;
    @FXML
    private AnchorPane portfolioSection;
    @FXML
    private AnchorPane settingsSection;
    @FXML
    private FontIcon bitcoinChainRefresh;
    @FXML
    private FontIcon ethereumChainRefresh;
    @FXML
    private FontIcon litecoinChainRefresh;
    @FXML
    private ImageView litecoinLogo;
    @FXML
    private FontIcon moneroChainRefresh;
    @FXML
    private ImageView skinType;
    @FXML
    private JFXButton saveSkin;
    @FXML
    private JFXCheckBox spacexSkinSet;
    @FXML
    private JFXCheckBox californiaSkinSet;
    @FXML
    private JFXCheckBox ethereumSkinSet;

    //Types of wallets to send/receive crypto
    @FXML
    private AnchorPane cryptoLabels;
    @FXML
    private Label bitcoinwalletLabel;
    @FXML
    private Label ethereumwalletLabel;
    @FXML
    private Label litecoinwalletLabel;
    @FXML
    private Label monerowalletLabel;

    String accountValue;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CandleChart candleStickChart = new CandleChart("S&P 500 Index", buildBars());

        sendReceiveBitcoin.getChildren().add(candleStickChart);
        candleStickChart.setYAxisFormatter(new DecimalAxisFormatter("#000.00"));

        try {
            String json = new currentpriceRequest().get();
            JSONParser jsonParser = new JSONParser();

            JSONObject object = (JSONObject) jsonParser.parse(json);

            JSONObject bitcoinPrice = (JSONObject) object.get("USD");
            String price = bitcoinPrice.get("last").toString();
            System.out.println(price);
            accountValue=price;


        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }

        bitcoinsendPane.setVisible(false);
        bitcoinreceivePane.setVisible(false);
        ethereumsendPane.setVisible(false);
        ethereumreceivePane.setVisible(false);
        litecoinsendPane.setVisible(false);
        litecoinreceivePane.setVisible(false);
        monerosendPane.setVisible(false);
        moneroreceivePane.setVisible(false);
        litecoinChainRefresh.setVisible(false);
        cryptoLabels.setVisible(false);
        sendReceiveBitcoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        settingsSection.setVisible(false);
    }

    public void gotoWallet(MouseEvent event) {
        walletLabel.setStyle("-fx-text-fill:#b3ccff;");
        settingsSection.setVisible(false);
        portfolioSection.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        sendReceiveBitcoin.setVisible(true);
        cryptoLabels.setVisible(true);
    }

    public void gotoPortfolio(MouseEvent event) {
        settingsSection.setVisible(false);
        sendReceiveBitcoin.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        portfolioSection.setVisible(true);
        cryptoLabels.setVisible(false);
    }

    public void gotoExchange(MouseEvent event) {
        sendReceiveBitcoin.setVisible(false);
        portfolioSection.setVisible(false);
        cryptoLabels.setVisible(false);
    }

    public void walletDragOn(MouseEvent event) {
        walletLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void walletDragOff(MouseEvent event) {
        walletLabel.setStyle("-fx-text-fill:white;");
    }

    public void portfolioDragOn(MouseEvent event) {
        portfolioLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void portfolioDragOff(MouseEvent event) {
        portfolioLabel.setStyle("-fx-text-fill:white;");
    }

    public void exchangeDragOn(MouseEvent event) {
        exchangeLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void exchangeDragOff(MouseEvent event) {
        exchangeLabel.setStyle("-fx-text-fill:white;");
    }
    public void settingsDragOn(MouseEvent event) {
        settingsLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void settingsDragOff(MouseEvent event) {
        settingsLabel.setStyle("-fx-text-fill:white;");
    }
    public void helpDragOn(MouseEvent event) {
        helpLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void helpDragOff(MouseEvent event) {
        helpLabel.setStyle("-fx-text-fill:white;");
    }
    public void bitcoinwalletDragOn(MouseEvent event) {
        bitcoinwalletLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void bitcoinwalletDragOff(MouseEvent event) {
        bitcoinwalletLabel.setStyle("-fx-text-fill:white;");
    }
    public void ethereumwalletDragOn(MouseEvent event) {
        ethereumwalletLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void ethereumwalletDragOff(MouseEvent event) {
        ethereumwalletLabel.setStyle("-fx-text-fill:white;");
    }
    public void litecoinwalletDragOn(MouseEvent event) {
        litecoinwalletLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void litecoinwalletDragOff(MouseEvent event) {
        litecoinwalletLabel.setStyle("-fx-text-fill:white;");
    }
    public void monerowalletDragOn(MouseEvent event) {
        monerowalletLabel.setStyle("-fx-text-fill:#b3ccff;");
    }
    public void monerowalletDragOff(MouseEvent event) {
        monerowalletLabel.setStyle("-fx-text-fill:white;");
    }

    public void refreshbitcoinChain(MouseEvent event) {
        bitcoinChainRefresh.setIconLiteral("fa-refresh");

    }
    public void resetbitcoinLogo(MouseEvent event) {
        bitcoinChainRefresh.setIconLiteral("fab-bitcoin");

    }
    public void refreshethereumChain(MouseEvent event) {
        ethereumChainRefresh.setIconLiteral("fa-refresh");

    }
    public void resetethereumLogo(MouseEvent event) {
        ethereumChainRefresh.setIconLiteral("fab-ethereum");

    }
    public void refreshlitecoinChain(MouseEvent event) {
        litecoinLogo.setVisible(false);
        litecoinChainRefresh.setVisible(true);

    }
    public void resetlitecoinLogo(MouseEvent event) {
        litecoinChainRefresh.setVisible(false);
        litecoinLogo.setVisible(true);

    }
    public void refreshmoneroChain(MouseEvent event) {
        moneroChainRefresh.setIconLiteral("fa-refresh");

    }
    public void resetmoneroLogo(MouseEvent event) {
        moneroChainRefresh.setIconLiteral("fab-monero");

    }
    public void gotoSettings(MouseEvent event) {
        sendReceiveBitcoin.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        portfolioSection.setVisible(false);
        settingsSection.setVisible(true);
        cryptoLabels.setVisible(false);

    }
    public void saveSettings(MouseEvent event) {
        if (spacexSkinSet.isSelected())
        {
            Image skinOne = new Image(getClass().getResourceAsStream("/images/spacex-skin.jpg"));
            skinType.setImage(skinOne);
        }
        else if (californiaSkinSet.isSelected())
        {
            Image skinTwo = new Image(getClass().getResourceAsStream("/images/california-skin.jpg"));
            skinType.setImage(skinTwo);
        }
        else if (ethereumSkinSet.isSelected())
        {
            Image skinThree = new Image(getClass().getResourceAsStream("/images/ethereum-skin.jpg"));
            skinType.setImage(skinThree);
        }


    }
    public void gotoBitcoinWallet(MouseEvent event) {
        sendReceiveEthereum.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        sendReceiveBitcoin.setVisible(true);

        try {
            String transactionList = new transactionsRequest().get();
            JSONParser transactionParser = new JSONParser();

            JSONObject transactionObject = (JSONObject) transactionParser.parse(transactionList);

            JSONArray transactionTimes = (JSONArray) transactionObject.get("txs");

            for (Object transactionArray : transactionTimes)
            {
                //do something
            }

            System.out.println(transactionTimes);

        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }



    }
    public void gotoEthereumWallet(MouseEvent event) {
        sendReceiveBitcoin.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(false);
        sendReceiveEthereum.setVisible(true);


    }
    public void gotoLitecoinWallet(MouseEvent event) {
        sendReceiveBitcoin.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        sendReceiveMonero.setVisible(false);
        sendReceiveLitecoin.setVisible(true);


    }
    public void gotoMoneroWallet(MouseEvent event) {
        sendReceiveBitcoin.setVisible(false);
        sendReceiveEthereum.setVisible(false);
        sendReceiveLitecoin.setVisible(false);
        sendReceiveMonero.setVisible(true);


    }
    public void openbitcoinSend(MouseEvent event) {
        bitcoinsendPane.setVisible(true);
    }
    public void openbitcoinReceive(MouseEvent event) {
        bitcoinreceivePane.setVisible(true);

    }
    public void closebitcoinSend(MouseEvent event) {
        bitcoinsendPane.setVisible(false);
    }
    public void closebitcoinReceive(MouseEvent event) {
        bitcoinreceivePane.setVisible(false);

    }
    public void openethereumSend(MouseEvent event) {
        ethereumsendPane.setVisible(true);
    }
    public void openethereumReceive(MouseEvent event) {
        ethereumreceivePane.setVisible(true);

    }
    public void closeethereumSend(MouseEvent event) {
        ethereumsendPane.setVisible(false);
    }
    public void closeethereumReceive(MouseEvent event) {
        ethereumreceivePane.setVisible(false);

    }
    public void openlitecoinSend(MouseEvent event) {
        litecoinsendPane.setVisible(true);
    }
    public void openlitecoinReceive(MouseEvent event) {
        litecoinreceivePane.setVisible(true);

    }
    public void closelitecoinSend(MouseEvent event) {
        litecoinsendPane.setVisible(false);
    }
    public void closelitecoinReceive(MouseEvent event) {
        litecoinreceivePane.setVisible(false);

    }
    public void openmoneroSend(MouseEvent event) {
        monerosendPane.setVisible(true);
    }
    public void openmoneroReceive(MouseEvent event) {
        moneroreceivePane.setVisible(true);

    }
    public void closemoneroSend(MouseEvent event) {
        monerosendPane.setVisible(false);
    }
    public void closemoneroReceive(MouseEvent event) {
        moneroreceivePane.setVisible(false);

    }
    public void showusdValue(MouseEvent event) {
        valueLabel.setText("USD Value: " + accountValue);
        try {
            String json = new currentpriceRequest().get();
            JSONParser jsonParser = new JSONParser();

            JSONObject object = (JSONObject) jsonParser.parse(json);

            JSONObject bitcoinPrice = (JSONObject) object.get("USD");
            if (bitcoinPrice!=null)
            {
            String price = bitcoinPrice.get("last").toString();
            System.out.println(price);

                accountValue = price;
            }


        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
    public void showbitcoinValue(MouseEvent event) {
        valueLabel.setText("BTC Value: .144 btc");

    }
    public List<TickData> buildBars() {
        double previousClose = 1850;


        final List<TickData> bars = new ArrayList<>();
        GregorianCalendar now = new GregorianCalendar();
        for (int i = 0; i < 26; i++) {
            double open = getNewValue(previousClose);
            double close = getNewValue(open);
            double high = Math.max(open + getRandom(),close);
            double low = Math.min(open - getRandom(),close);
            previousClose = close;

            TickData bar = new TickData((GregorianCalendar) now.clone(), open, high, low, close, 1);
            now.add(Calendar.MINUTE, 5);
            bars.add(bar);
        }
        return bars;
    }


    protected double getNewValue( double previousValue ) {
        int sign;

        if( Math.random() < 0.5 ) {
            sign = -1;
        } else {
            sign = 1;
        }
        return getRandom() * sign + previousValue;
    }

    protected double getRandom() {
        double newValue = 0;
        newValue = Math.random() * 10;
        return newValue;
    }
}
