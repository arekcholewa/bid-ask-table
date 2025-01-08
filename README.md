# JavaFX Application - Binance WebSocket Integration

This JavaFX application connects to the Binance WebSocket API to fetch the top 20 ask/bid orders for the `BTCUSDT` trading pair. The data is processed using the RXJava library for reactive programming.

## Technologies Used

The following technologies and libraries are used in this project:

- **JavaFX**: A framework for building the graphical user interface (GUI).
- **RXJava**: A reactive programming library used for handling asynchronous data streams from the WebSocket API.
- **WebSocket**: A communication protocol used to connect to the Binance WebSocket API and stream real-time data.
- **Binance WebSocket API**: The API used to subscribe to real-time market data, specifically for the order book of the `BTCUSDT` trading pair.
- **Maven**: A build automation tool used to manage project dependencies.

### Libraries

The project includes the following libraries:

- JavaFX (for building the GUI)
- RXJava (for reactive data processing from the WebSocket)
- Binance WebSocket Client (for connecting to the Binance WebSocket API)

#### Installation and Running
- Open Command Prompt in app directory
- Run maven command: javafx:run
