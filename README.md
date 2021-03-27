Hangman game over a TCP connection that allows a client to connect to a server
and play hangman game. This report will detail the work of each class and the utility we used in the program to
accomplish this feat.

## Classes and Utilities:

###  Server:

```
o In order for the server to run, we need to create a server socket via importing
(java.net.ServerSocket) and, to teach it how to behave with this server socket, we also
imported (java.net.Socket) to create a client socket. This way, we can connect these two
sockets and create a TCP connection.
o We then created a server socket and initiated it to port (5056), which will accept client
sockets’ requests.
o We then run a loop that will keep the server listening on a port (5056) for new clients’
requests.
o For multithreading, and handling many clients at once, we created and started a thread for
every new client, and the server control will be passed to a class called “clientHandler”.
o The server class must run before clients can request to connect to it.
```
###  Client:

```
o The client must run after the server was started.
o Every time we run the client class, a new client socket will be created, and it will have a local
host IP address, and will try to connect to the server on port (5056).
```

```
o Every client is assigned a unique ID.
o The client can handle receiving and sending messages to the server.
```
###  Client Handler:

```
o The client handler is the core of this multithreaded connection.
o It will take a client’s socket and will be able to send and receive messages from and to the
client it is handling.
o As a result, this client handler will listen to clients’ requests. If this client sends “exit” at any
point during its connection, the client handler will close this client’s connection.
o Otherwise, the client will play a hangman game through the client handler.
```
###  Hangman Game:

```
o This class is similar in every way to the client handler.
o It will take a client’s socket and will be able to send and receive messages from and to the
client it is handling.
o It will run a new hangman game per the client’s request.
o Every client will be assigned a different hidden word and a score that is independent of other
clients’ scores.
o This class will keep running the hangman game for every client that is playing and will receive
guess letters and updates every client’s hidden word until the client decides to exit.
```

## Sample Runs:

![image](https://user-images.githubusercontent.com/50872362/112713173-fb049000-8ee4-11eb-9de8-69767af03208.png)
![image](https://user-images.githubusercontent.com/50872362/112713178-02c43480-8ee5-11eb-9919-23e245fdae07.png)
![image](https://user-images.githubusercontent.com/50872362/112713183-0a83d900-8ee5-11eb-95e1-f2c241d2d5d5.png)
![image](https://user-images.githubusercontent.com/50872362/112713188-0e176000-8ee5-11eb-8186-1dfa044dd99b.png)
![image](https://user-images.githubusercontent.com/50872362/112713192-1374aa80-8ee5-11eb-8dfa-703c11359430.png)


